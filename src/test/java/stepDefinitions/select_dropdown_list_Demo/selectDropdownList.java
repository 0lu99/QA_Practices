package stepDefinitions.select_dropdown_list_Demo;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class selectDropdownList {

    WebDriver driver;
    public static WebElement random;

    @Given("I launch Google Chrome")
    public void i_launch_Google_Chrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/olu/Desktop/BrowserDriver/chromedriver");
        driver = new ChromeDriver(); // launch Chrome browser
        driver.manage().window().maximize();
    }

    @When("I go to the select dropdown list page")
    public void i_go_to_the_select_dropdown_list_page() {
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
    }

    @When("I click on a random day")
    public void i_click_on_a_random_day() {
        WebElement dates = driver.findElement(By.xpath("//div//div//div[1]//div[2]//select[1]"));
        List<WebElement> listofDates = (dates.findElements(By.tagName("option"))).subList(1, 8);
        Random rand = new Random();
        int randomDay = rand.nextInt(listofDates.size());
        random = (listofDates.get(randomDay));
        random.click();
    }

    @Then("I see a message saying that random day has been selected")
    public void i_see_a_message_saying_that_random_day_has_been_selected(){
        String daySelectedMessage = (driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/p[2]"))).getText();
        String expectedMessage = "Day selected :- " + random.getText();

        try {
            assertEquals(daySelectedMessage,expectedMessage);
            System.out.println("*******************\nTEST PASSED\n*******************\n");
        }catch (AssertionError e) {
            System.out.println("*******************\nEST FAILED\n*******************");
            throw e;
        }
    }


    @After
    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();
    }

}
