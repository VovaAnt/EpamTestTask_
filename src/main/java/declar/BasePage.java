package declar;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage  {
    WebDriver driver;
    protected void init(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.init(driver);
    }
}
