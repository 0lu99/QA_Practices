package stepDefinitions.checkbox_Demo;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class checkbox {

    WebDriver driver;

    @Given("I launch Google Chrome")
    public void i_launch_Google_Chrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/olu/Desktop/BrowserDriver/chromedriver");
        driver = new ChromeDriver(); // launch Chrome browser
        driver.manage().window().maximize();
    }

    @When("I go to the checkbox web page")
    public void i_go_to_the_checkbox_web_page() {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }

    /*
        Scenario 1: Checking a checkbox will display a success message
     */

    @When("I check the single checkbox")
    public void i_check_the_single_checkbox() {
       driver.findElement(By.xpath("//div//div//div[1]//div[2]//div[1]//label[1]//input[1]")).click();
    }

    @Then("I see the checkbox success message")
    public void i_see_the_checkbox_success_message() {
      String successMsg = driver.findElement(By.xpath("//div//div//div//div[1]//div[2]//div[2]")).getText();
        String expectedMsg = "Success - Check box is checked";

        try {
            assertEquals(successMsg,expectedMsg);
            System.out.println("*******************\nSC1: TEST PASSED\n*******************\n");
        }catch (AssertionError e) {
            System.out.println("*******************\nSC1: TEST FAILED\n*******************");
            throw e;
        }
    }

    /*
        Scenario 2: Unchecking a checkbox will remove the success message
     */

    @When("I uncheck the single checkbox")
    public void i_uncheck_the_single_checkbox() throws Exception {
        WebElement singleCheckbox = driver.findElement(By.xpath("//div//div//div[1]//div[2]//div[1]//label[1]//input[1]"));
        boolean isBoxChecked = true;

        try {
            if (singleCheckbox.isSelected()){
                singleCheckbox.click();
                isBoxChecked = false;
            }
            assertFalse(isBoxChecked);
        }catch (AssertionError e){
            System.out.println("The checkbox has not been checked");
            throw e;
        }
    }

    @Then("the checkbox success message will no longer be present")
    public void the_checkbox_success_message_will_no_longer_be_present() throws Exception {
        String successMsg = driver.findElement(By.xpath("//div//div//div//div[1]//div[2]//div[2]")).getText();
        boolean isMsgVisible = true;

        try {
            if (successMsg.isEmpty()){
                isMsgVisible = false;
            }
            assertFalse(isMsgVisible);
            System.out.println("*******************\nSC2: TEST PASSED\n*******************");
        }catch (AssertionError e){
            System.out.println("*******************\nSC1: TEST FAILED\n*******************");
            System.out.println("The success message is being displayed");
            throw e;
        }
    }

    @After
    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();
    }
}
