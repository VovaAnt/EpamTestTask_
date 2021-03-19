package stepdefs;

import declar.Google;
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
    Google myGogl = new Google(driver);

    @Given("^We are on Google Search page$")
    public void We_are_on_Google_Search_page() {
        log.info("Go to google for searching");
        myGogl.goToGoogle();
    }

    @When("^make Search in google for \"([^\"]*)\"$")
    public void make_Search_in_google(String searchWord) {
        log.info("Type  {}  into search field ", searchWord);
        myGogl.searchField.sendKeys(searchWord);
        log.info("Press Enter for start searching");
        myGogl.searchField.sendKeys(Keys.ENTER);
    }

    @Then("^Verifying Title \"([^\"]*)\"$")
    public void verifyingTitle(String title) throws Throwable {
        log.info("Verifying Title {}", title);
        Assertions.assertThat(driver.getTitle())
                .as("The title doesn't contain required word (automation)")
                .contains(title);
    }

    @Then("^Verifying Title on (.*) pages \"([^\"]*)\"$")
    public void verifyingDomainOnPages(Integer numberOfPages, String title) throws Throwable {
        log.info("Verifying Title {}", title);
        Assertions.assertThat(myGogl.searchingDomainOnPages(numberOfPages, title))
                .as("The title '%s' doesn't contain required word on %s pages", title, numberOfPages)
                .isTrue();
    }
}
