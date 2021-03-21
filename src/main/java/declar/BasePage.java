package declar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    WebDriver driver;

    protected void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.init(driver);
    }

    public Wait waiter(int second, int q) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(second, TimeUnit.SECONDS)
                .pollingEvery(q, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return wait;
    }

    public Wait waiter(int timeout) {
        return this.waiter(timeout, 1);
    }

    public Wait waiter() {
        return this.waiter(15, 1);
    }
}
