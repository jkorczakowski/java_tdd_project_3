package projekt.jck9719;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class AddItemTest {
    private static  WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void itemExistsPositive() {
        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/" +
                "div[2]/h5/a"));
        assertNotNull(el);
    }

    @Test
    public void itemClickProperRedirectPositive() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/" +
                "div[2]/h5/a"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();
        String pageTitle = driver.getTitle();
        assertEquals("Faded Short Sleeve T-shirts - My Store", pageTitle);
    }

    @Test
    public void addOneItemPositive() {
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

        String value = driver.findElement(By.xpath("//span[@class='ajax_cart_quantity unvisible']")).getText();
        assertEquals(1, Integer.parseInt(value));

    }

//    @Test
//    public void addTwoItemPositive() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/" +
//                "div[2]/h5/a"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        el = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        el = driver.findElement(By.xpath("//span[@class='cross']"));
//        wait.until(ExpectedConditions.visibilityOf(el));
//        el.click();
//
//        el = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//
//        el = driver.findElement(By.xpath("//span[@class='cross']"));
//        wait.until(ExpectedConditions.visibilityOf(el));
//        el.click();
//
//        String value = driver.findElement(By.xpath("//span[@class='ajax_cart_quantity unvisible']")).getText();
//        assertEquals(2, Integer.parseInt(value));
//
//    }
}
