package runners;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/Features/newCustomer.feature",
        glue = "StepDefinitions",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty","html:target/Reports/Report.html"}


)
public class basicRunner extends AbstractTestNGCucumberTests{
}
