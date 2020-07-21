package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/olu/IdeaProjects/QA_Practices/src/test/Features/selectDropdownList.feature",
        glue = "stepDefinitions/select_dropdown_list_Demo"

)
public class selectDropdownList_testRunner {

}