package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/olu/IdeaProjects/QA_Practices/src/test/Features/checkbox.feature",
        glue = "stepDefinitions/checkbox_Demo"

)
public class checkbox_testRunner {

}
