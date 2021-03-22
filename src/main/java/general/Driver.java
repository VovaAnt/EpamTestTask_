package general;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

public class Driver {

    protected WebDriver driver = null;

    Variables vars = new Variables();
    String browserName = vars.getBrowserType();
    private int timeout = 2;

    private WebDriver init() {
        switch (this.browserName.toLowerCase()) {
            //choose FireFox to run tests
            case FIREFOX:
                driver = firefoxDriver();
                break;
            //choose Chrome to run tests
            case GOOGLECHROME:
            case CHROME:
                driver = chromeDriver();
                break;
            default:
                throw new WebDriverException(String.format("Incorrect browserType %s. FireFox, Chrome are allowed", browserName));
        }
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = init();
        }
        return driver;
    }

    //Chrome driver initialization
    private WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    //FireFox driver initialization
    private WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
