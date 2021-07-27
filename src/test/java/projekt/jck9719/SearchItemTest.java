package projekt.jck9719;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;


public class SearchItemTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        //System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        WebDriverManager.firefoxdriver().setup();

    }

    @BeforeEach
    public void setUp() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addArguments("--headless");
        driver = new FirefoxDriver(firefoxOptions);
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sitePositive() {
        String pageTitle = driver.getTitle();
        assertEquals("My Store", pageTitle);
    }

    @Test
    public void searchForDressesCountPositive() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement el = driver.findElement(By.cssSelector("#search_query_top"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.sendKeys("chiffon dress");
        el.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='heading-counter']")));

        el = driver.findElement(By.xpath("//span[@class='heading-counter']"));

        assertEquals("2 results have been found.", el.getText());
    }

    @Test
    public void searchForDressesCountNegative() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement el = driver.findElement(By.cssSelector("#search_query_top"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.sendKeys("chiffon dress");
        el.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='heading-counter']")));

        el = driver.findElement(By.xpath("//span[@class='heading-counter']"));

        assertNotEquals("3 results have been found. ", el.getText());
    }
}
