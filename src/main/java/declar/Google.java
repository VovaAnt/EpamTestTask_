package declar;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


@Slf4j
@Getter
public class Google extends BasePage {

    String URL = "https://www.google.com/webhp?hl=ru&sa=X&ved=0ahUKEwi78ta16qzvAhXFDewKHfOQAzMQPAgI";

    @FindBy(name = "q")
    public WebElement searchField;

    String pages = "//a[@class='fl' and contains(@aria-label, 'Page %d')]";
    String domain = "//a//cite[contains(.,'%s')]";

    public Google(WebDriver driver) {
        super(driver);
    }


    public void goToGoogle() {
        driver.get(URL);
    }

    public void makeSearchInGoogle(String searchWord) {

        log.info("Go to google for searching");
        goToGoogle();

        log.info("Type  {}  into search field ", searchWord);
        searchField.sendKeys(searchWord);

        log.info("Press Enter for start searching");
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean searchingDomainOnPages(int pageNumbers, String searchingDomain) {
        int i = 1;
        while (++i <= pageNumbers) {
            driver.findElement(By.xpath(String.format(pages, i))).click();
            try {
                driver.findElement(By.xpath(String.format(getDomain(), searchingDomain)));
                return true;
            } catch (NoSuchElementException e) {}
        }
        return false;
    }
}
