package stepDefinitions.basic_auth_login_Demo;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

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
    public void i_enter_the_correct_credentials() {
        /*
            username: admin
            password: admin
         */
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @Then("I see the basicAuth success message")
    public void i_see_the_basicAuth_success_message() {
        String actualMessage = (driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/p[1]"))).getText();
        String expectedMessage = "Congratulations! You must have the proper credentials.";
        // verify is message appears on the web page
        try {
            assertEquals(actualMessage, expectedMessage);
            System.out.println("*******************\nTEST PASSED\n*******************\n");
        } catch (AssertionError e) {
            System.out.println("*******************\nTEST FAILED\n*******************");
            throw e;
        }
    }

    @After
    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();
    }
}
