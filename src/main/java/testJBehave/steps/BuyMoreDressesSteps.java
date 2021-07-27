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

public class BuyMoreDressesSteps {

    private static WebDriver driver;
    private static String value;
    private static WebElement el;
    private static WebDriverWait wait = new WebDriverWait(driver, 10);

    @Given("A chrome browser")
    public void aChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("I add item to cart")
    public void iAddItem() {
        driver.get("http://automationpractice.com/index.php");

        el = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/" +
                "div[2]/h5/a"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();
    }

    @When("I proceed to checkout")
    public void iProceed() {

        el = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

    }

    @When("I click on plus")
    public void iClick() {


        el = driver.findElement(By.xpath("//i[@class='icon-plus']"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        driver.navigate().refresh();

        value = driver.findElement(By.xpath("//span[@class='heading-counter']")).getText();
    }


    @Then("I have two dresses in cart")
    public void dresses() {
        assertEquals("I add item to cart", value);
    }

    @AfterScenario(uponOutcome = AfterScenario.Outcome.SUCCESS)
    public void tearDown(){
        driver.quit();
    }
}
