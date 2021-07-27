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

public class SearchDressSteps {

    private static WebDriver driver;
    private static String value;

    @Given("A chrome browser")
    public void aChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("I get to shop site")
    public void iGetToSite() {
        driver.get("http://automationpractice.com/index.php");
    }

    @When("I type dress name")
    public void typeDressInSearchForm() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement el = driver.findElement(By.cssSelector("#search_query_top"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.sendKeys("dress");
        el.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='heading-counter']")));

        value = driver.findElement(By.xpath("//span[@class='heading-counter']")).getText();
    }

    @Then("There should be some clothes to buy")
    public void dresses() {
        assertEquals("7 results have been found.", value);
    }

    @AfterScenario(uponOutcome = AfterScenario.Outcome.SUCCESS)
    public void tearDown(){
        driver.quit();
    }
}
