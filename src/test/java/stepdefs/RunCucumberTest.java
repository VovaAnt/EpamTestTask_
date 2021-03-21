package stepdefs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features", //the path of the feature files
        glue = {"stepdefs"},//the path of the step definition files
        plugin = {"pretty:target/cucumber-pretty.txt",
                "html:target/cucumber-html-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        } //to generate different types of reporting
//        monochrome = true, //display the console output in a proper readable format
////        strict = true, //it will check if any step is not defined in step definition file
//        dryRun = true //to check the mapping is proper between feature file and step definition file )
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
