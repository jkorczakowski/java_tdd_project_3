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

public class DeleteItemTest {
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
    public void deleteOneItemPositive() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/" +
                "div[2]/h5/a"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        el = driver.findElement(By.xpath("//i[@class='icon-trash']"));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String value = driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText();
        assertEquals("Your shopping cart is empty.", value);

    }

//    @Test
//    public void deleteTwoItemsOfThreePositive() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        WebElement el = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/" +
//                "ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]/span[1]"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        el = driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']//span[1]"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        el = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/" +
//                "div[2]/div[2]/a[1]/span[1]"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable
//                (By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]" +
//                        "/li[2]/div[1]/div[2]/div[2]/a[1]/span[1]"))).click();
//
//
//        el = driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']//span[1]"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        el = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]" +
//                "/div[1]/div[2]/div[2]/a[1]/span[1]"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        el = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        el = driver.findElement(By.xpath("//a[@id='2_7_0_0']//i[@class='icon-trash']"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        el = driver.findElement(By.xpath("//a[@id='1_1_0_0']//i[@class='icon-trash']"));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.click();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        String value = driver.findElement(By.xpath("//span[@class='heading-counter']")).getText();
//        assertEquals("Your shopping cart contains: 1 Product", value);
//
//    }

}
