package stepDefinitions.simpleForm;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class simpleForm {

    WebDriver driver;
    String message = "Hello World";

    @io.cucumber.java.en.Given("I launch Google Chrome")
    public void i_launch_Google_Chrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/olu/Desktop/BrowserDriver/chromedriver");
        driver = new ChromeDriver(); // launch Chrome browser
        driver.manage().window().maximize();
    }

    @When("I go to the form page")
    public void i_go_to_the_form_page() {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
    }

    @When("I type in a message and click show message")
    public void i_type_in_a_message_and_click_show_message() {
        driver.findElement(By.xpath("//div//div//div[1]//div[2]//form[1]//div[1]//input[1]"))
                .sendKeys(message);

        driver.findElement(By.xpath("//div//div//div[1]//div[2]//form[1]//button[1]")).click();
    }

    @Then("I should see my messaged outputted")
    public void i_should_see_my_messaged_outputted() {
        String displayedMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]")).getText();
        try {
            assertEquals(message, displayedMessage);
            System.out.println("************\nTEST PASSED\n************");
        }catch (AssertionError e) {
            System.out.println("************\nTEST FAILED\n************");
            throw e;

        }
    }

    @After
    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();
    }
}
