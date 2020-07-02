package stepDefinitions.simpleForm_Demo;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;


public class simpleForm {

    WebDriver driver;
    String message = "Hello World";
    int valueA = 5;
    int valueB = 7;
    int aplusb = valueA + valueB;

    /*
        ******************************************
        Scenario 1: Single Input Field
        ******************************************
     */

    @Given("I launch Google Chrome")
    public void i_launch_Google_Chrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/olu/Desktop/BrowserDriver/chromedriver");
        driver = new ChromeDriver(); // launch Chrome browser
        driver.manage().window().maximize();
    }

    @When("I go to the form page")
    public void i_go_to_the_form_page() {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
    }

    @When("I type in a message")
    public void i_type_in_a_message() {
        driver.findElement(By.xpath("//div//div//div[1]//div[2]//form[1]//div[1]//input[1]"))
                .sendKeys(message);
    }

    @Then("I should see my message outputted when I click show message")
    public void i_should_see_my_message_outputted_when_I_click_show_message() {
        driver.findElement(By.xpath("//div//div//div[1]//div[2]//form[1]//button[1]")).click();
        String displayedMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]")).getText();
        try {
            assertEquals(message, displayedMessage);
            System.out.println("*******************\nSC1: TEST PASSED\n*******************");
        }catch (AssertionError e) {
            System.out.println("*******************\nSC1: TEST FAILED\n*******************");
            throw e;
        }

    }

    /*
        ******************************************
        Scenario: Two Input Fields
        ******************************************
     */

    @When("I type in a message in a A and B")
    public void i_type_in_a_message_in_a_A_and_B() {
        driver.findElement(By.xpath("//body//div//div//div//div[2]//div[2]//div[1]//input[1]")).sendKeys(""+valueA);
        driver.findElement(By.xpath("//div//div//div//div//div//div[2]//input[1]")).sendKeys(""+valueB);
    }

    @Then("I should see the total when I click Get Total")
    public void i_should_see_the_total_when_I_click_Get_Total() {
        driver.findElement(By.xpath("//body//div//div//div//div[2]//div[2]//button[1]")).click();
        int totalValue = Integer.parseInt(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/span[1]")).getText());
        try {
            assertEquals(aplusb,totalValue);
            System.out.println("*******************\nSC2: TEST PASSED\n*******************");
        }catch (AssertionError e) {
            System.out.println("*******************\nSC2: TEST FAILED\n*******************");
            throw e;
        }
    }

    @After
    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();
    }
}
