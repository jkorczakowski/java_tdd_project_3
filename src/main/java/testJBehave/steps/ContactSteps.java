package testJBehave.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;


public class ContactSteps {
    private static WebDriver driver;

    @Given("a chrome browser")
    public void aChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("I get to http://automationpractice.com/index.php")
    public void iGetToSite() {
        driver.get("http://automationpractice.com/index.php");
    }

    @When("I click on contact page")
    public void clickContactPage() {
        driver.findElement(By.linkText("Contact us")).click();
    }

    @Then("There is a contact site")
    public void contactPage() {
        assertEquals("Contact us - My Store", driver.getTitle());
    }

    @AfterScenario(uponOutcome = AfterScenario.Outcome.SUCCESS)
    public void tearDown(){
        driver.quit();
    }


}
