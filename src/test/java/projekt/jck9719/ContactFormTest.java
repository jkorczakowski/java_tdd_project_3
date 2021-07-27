package projekt.jck9719;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactFormTest {
    private static  WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.firefoxdriver().setup();

    }

    @BeforeEach
    public void setUp() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        driver = new FirefoxDriver(firefoxOptions);
        driver.get("http://automationpractice.com/index.php");
        wait = new WebDriverWait(driver, 10);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void contactFormPositive() {
        WebElement el = driver.findElement(By.linkText("Contact us"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();
        el = driver.findElement(By.xpath("//select[@id='id_contact']"));
        Select dropDown = new Select(el);
        dropDown.selectByIndex(1);
        el = driver.findElement(By.cssSelector("#email"));
        wait.until(ExpectedConditions.visibilityOf(el));
        el.sendKeys("test@test.com");
        el = driver.findElement(By.cssSelector("#id_order"));
        wait.until(ExpectedConditions.visibilityOf(el));
        el.sendKeys("12");
        el = driver.findElement(By.cssSelector("#message"));
        wait.until(ExpectedConditions.visibilityOf(el));
        el.sendKeys("Just testing with selenium");
        el = driver.findElement(By.xpath("//span[contains(text(),'Send')]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//        el = driver.findElement(By.xpath("//div[@class='columns-container']//div[@class='row']//span[1]"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        assertNotNull(el);

    }


}
