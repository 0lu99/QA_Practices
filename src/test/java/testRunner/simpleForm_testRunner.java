package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                    features = "/Users/olu/IdeaProjects/QA_Practices/src/test/Features/simpleForm.feature",
                    glue = "stepDefinitions/simpleForm_Demo"

)

public class simpleForm_testRunner {

}
