package stepdefs;

import declar.GooglePage;
import general.Variables;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Slf4j
public class Tests {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        this.driver = new general.Driver().getDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void shutDown() {
        driver.close();
    }

    @Test
    public void SearchTest() {
        GooglePage myGogl = new GooglePage(this.driver);
        myGogl.makeSearchInGoogle(Variables.getSearchingWord());
        log.info("Search was successful");
        Assertions.assertThat(this.driver.getTitle())
                .as("The title doesn't contain required word {}",Variables.getSearchingWord())
                .contains(Variables.getSearchingWord());
    }

    @Test
    public void SearchInFirstFivePages() {
        GooglePage myGogl = new GooglePage(this.driver);
        myGogl.makeSearchInGoogle(Variables.getSearchingWord());
        log.info("Search was successful");
        Assertions.assertThat(myGogl.searchingDomainOnPages(5, Variables.getSearchingDomain()))
                .as("There no such domain which we looking for {}",Variables.getSearchingDomain())
                .isTrue();
    }
}
