package projekt.jck9719;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class EditItemTest {
    private static  WebDriver driver;

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
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void editQuantityOfItemAddOnePositive() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement el = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/" +
                "li[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//button[@name='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//i[@class='icon-plus']"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();
        driver.navigate().refresh();

        String value = driver.findElement(By.xpath("//input[@name='quantity_1_1_0_0']")).getAttribute("value");

        assertEquals(2, Integer.parseInt(value));

    }

    @Test
    public void editQuantityOfItemManualPositive() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement el = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/" +
                "li[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//button[@name='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//input[@name='quantity_1_1_0_0']"));
        el.sendKeys("7");

        wait.until(ExpectedConditions.visibilityOf(el));

        String value = driver.findElement(By.xpath("//input[@name='quantity_1_1_0_0']")).getAttribute("value");

        assertEquals(7, Integer.parseInt(value));

    }

    @Test
    public void editQuantityAndSizeAndColourOfItemPositive() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement el = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/" +
                "li[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.cssSelector("#quantity_wanted"));
        el.clear();
        el.sendKeys("7");

        el = driver.findElement(By.cssSelector("#group_1"));
        el.click();
        el.sendKeys("M");

        el = driver.findElement(By.cssSelector("#color_14"));
        el.click();

        el = driver.findElement(By.xpath("//button[@name='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();


        String colAndSize = driver.findElement(By.linkText("Color : Blue, Size : M")).getText();

        String value = driver.findElement(By.xpath("//input[@name='quantity_1_4_0_0']")).getAttribute("value");

        assertAll(
                () -> assertEquals("Color : Blue, Size : M", colAndSize),
                () -> assertEquals(7, Integer.parseInt(value))
        );

    }
}
