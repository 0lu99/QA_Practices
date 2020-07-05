package stepDefinitions.basic_auth_login_Demo;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic_auth_login {

    // initialising WebDriver
    WebDriver driver;

    @Given("I launch Google Chrome")
    public void i_launch_Google_Chrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/olu/Desktop/BrowserDriver/chromedriver");
        driver = new ChromeDriver(); // launch Chrome browser
        driver.manage().window().maximize();

    }

    @When("I go to the basic auth web page")
    public void i_go_to_the_basic_auth_web_page() {
        // directing to the web page
        driver.get("http://the-internet.herokuapp.com/basic_auth");
    }

    @When("I enter the correct credentials")
    public void i_enter_the_correct_credentials(){
        /*
            username: admin
            password: admin
         */
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @Then("I see the basicAuth success message")
    public void i_see_the_basicAuth_success_message() {
        // verify is message appears on the web page
        if (driver.getPageSource().contains("Congratulations! You must have the proper credentials")){
            System.out.println("************\nTEST PASSED\n************");
        }else{
            // fail test if message isn't present
            System.out.println("************\nTEST FAILED\n************");
            Assert.assertTrue(false);
            driver.quit();
        }
    }

    @After
    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();
    }
}
