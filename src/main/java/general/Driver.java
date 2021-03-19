package general;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    protected  WebDriver driver = null;

    Variables vars = new Variables();
    String driverType = vars.getDriverType();
    private int timeout = 2;

    private WebDriver init(){
            switch (this.driverType) {
                //choose FireFox to run tests
                case "FireFox":
                    driver = firefoxDriver();
                    break;

                //choose Chrome to run tests
                case "Chrome":
                    driver = chromeDriver();
                    break;

                default:
                    try {
                        throw new Exception("Incorrect text for driverType value. FireFox, Chrome, IE9, Safari are allowed");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

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
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    //FireFox driver initialization
    public WebDriver firefoxDriver() {
        throw new RuntimeException("FireFox is not implemented");
    }

}

