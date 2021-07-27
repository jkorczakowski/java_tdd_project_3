package testJBehave.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class LogInSteps {

    private static WebDriver driver;
    private static String value;
    private static WebElement el;
    private static WebDriverWait wait = new WebDriverWait(driver, 10);

    @Given("A chrome browser")
    public void aChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("I go to login page")
    public void iGoToLoginPage() {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign"));
    }

    @When("I enter valid data")
    public void iEnterData() {

        el = driver.findElement(By.cssSelector("#email"));
        wait.until(ExpectedConditions.visibilityOf(el));
        el.sendKeys("gaunt1111@gmail.com");
        el = driver.findElement(By.cssSelector("#passwd"));
        wait.until(ExpectedConditions.visibilityOf(el));
        el.sendKeys("testpass");
        el = driver.findElement(By.xpath("//p[@class='submit']//span[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();
        value = driver.getTitle();
    }

    @Then("I should be logged")
    public void iAmLogged() {
        assertEquals("My account - My Store", value);

    }

    @AfterScenario(uponOutcome = AfterScenario.Outcome.SUCCESS)
    public void tearDown(){
        driver.quit();
    }
}
