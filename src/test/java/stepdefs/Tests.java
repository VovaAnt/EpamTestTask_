//package stepdefs;
//
//import declar.Google;
//import general.Variables;
//import lombok.extern.slf4j.Slf4j;
//import org.assertj.core.api.Assertions;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.*;
//
//@Slf4j
//public class Tests {
//
//    private WebDriver driver;
//
//    @BeforeTest
//    public void setUp() {
//        this.driver = new general.Driver().getDriver();
//        driver.manage().window().maximize();
//    }
//
////    @AfterTest
////    public void shutDown() {
////        driver.close();
////    }
//
//
////    @Test
////    public void SearchTest() {
//////        this.driver = new general.Driver().getDriver();
////        String expectedTitle = "automation";
////        Google myGogl = new Google(this.driver);
////        log.info("Test_______1");
////        myGogl.makeSearchInGoogle(Variables.getSearchingWord());
////        log.info("Before sleep");
////        try {
////
////            Thread.sleep(2000);
////        }catch (Exception e){
////
////        }
////        log.info("After sleep");
////        log.info("Search was successful");
////        Assertions.assertThat(this.driver.getTitle())
////                .as("The title doesn't contain required word (automation)")
////                .contains(expectedTitle);
////    }
////
////    @Test
////    public void SearchInFirstFivePages() {
//////        this.driver = new general.Driver().getDriver();
////        String expectedDomain = "testautomationday.com";
////        Google myGogl = new Google(this.driver);
////        log.info("Test_______2");
////        myGogl.makeSearchInGoogle(Variables.getSearchingWord());
////        log.info("Before sleep");
////        try {
////
////            Thread.sleep(2000);
////        }catch (Exception e){
////
////        }
////        log.info("After sleep");
////        log.info("Search was successful");
////        Assertions.assertThat(myGogl.searchingDomainOnPages(5, expectedDomain))
////                .as("There no such domain which we looking for (testautomationday.com)")
////                .isTrue();
////    }
//}
