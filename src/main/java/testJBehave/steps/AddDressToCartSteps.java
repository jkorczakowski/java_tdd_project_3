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

public class AddDressToCartSteps {

    private static WebDriver driver;
    private static String value;

    @Given("A chrome browser")
    public void aChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("I add item to cart")
    public void iGetToSiteAndAddItem() {
        driver.get("http://automationpractice.com/index.php");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/" +
                "div[2]/h5/a"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//span[@class='cross']"));
        wait.until(ExpectedConditions.visibilityOf(el));
        el.click();

        value = driver.findElement(By.xpath("//span[@class='ajax_cart_quantity unvisible']")).getText();
    }


    @Then("It should be present in cart")
    public void dresses() {
        assertEquals(1, Integer.parseInt(value));
    }

    @AfterScenario(uponOutcome = AfterScenario.Outcome.SUCCESS)
    public void tearDown(){
        driver.quit();
    }
}
