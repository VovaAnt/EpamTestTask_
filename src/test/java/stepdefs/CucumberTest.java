package stepdefs;


import declar.GooglePage;
import general.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


@Slf4j
public class CucumberTest {

    WebDriver driver = new Driver().getDriver();
    GooglePage googlePage = new GooglePage(driver);

    @Given("We are on Google Search page")
    public void weAreOnGoogleSearchPage() {
        log.info("Go to google for searching");
        googlePage.goToGoogle();
    }

    @When("Make Search in google for {string}")
    public void makeSearchInGoogle(String searchWord) {
        log.info("Type {} into search field ", searchWord);
        googlePage.searchField.sendKeys(searchWord);
        log.info("Press Enter for start searching");
        googlePage.searchField.sendKeys(Keys.ENTER);
    }

    @Then("Verifying Title {string}")
    public void verifyingTitle(String title) {
        log.info("Verifying Title {}", title);
        googlePage.waiter().until((a) -> driver.getTitle().contains(title));
        Assertions.assertThat(driver.getTitle())
                .as("The title doesn't contain required word (automation)")
                .contains(title);
    }

    @Then("Verifying Title on {int} pages {string}")
    public void verifyingDomainOnPages(Integer numberOfPages, String title) {
        log.info("Verifying Title {}", title);
        Assertions.assertThat(googlePage.searchingDomainOnPages(numberOfPages, title))
                .as("The title '%s' doesn't contain required word on %s pages", title, numberOfPages)
                .isTrue();
    }
}
