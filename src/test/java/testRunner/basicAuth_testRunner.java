package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                    features = "/Users/olu/IdeaProjects/QA_Practices/src/test/Features/basicAuth.feature",
                    glue = "stepDefinitions/basic_auth_login_Demo"

)

public class basicAuth_testRunner {

}
