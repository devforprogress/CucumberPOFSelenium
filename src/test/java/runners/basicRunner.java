package runners;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/Features",
        glue = "StepDefinitions",
        monochrome = true,
        dryRun = false,
        tags = "@NonReg",
        plugin = {"summary","pretty","html:target/Reports/Report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}


)
public class basicRunner extends AbstractTestNGCucumberTests{
}
