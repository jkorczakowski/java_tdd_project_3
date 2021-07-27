package projekt.jck9719;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class LogInTest {
    private static  WebDriver driver;
    private static final String email = "gaunt1111@gmail.com";
    private static final String pass = "testpass";

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginElementExistsPositive() {
        WebElement element;
        element = driver.findElement(By.className("login"));
        assertNotNull(element);
    }

    @Test
    public void loginPageTitlePositive() {
        driver.findElement(By.className("login")).click();
        String pageTitle = driver.getTitle();
        assertEquals("Login - My Store", pageTitle);
    }

    @Test
    public void loginEmailInputPositive() {
        driver.findElement(By.className("login")).click();
        WebElement input = driver.findElement(By.id("email"));
        input.sendKeys(email);
        String tempEmail = driver.findElement(By.id("email")).getAttribute("value");
        assertEquals(tempEmail, email);
    }

    @Test
    public void loginPasswordInputPositive() {
        driver.findElement(By.className("login")).click();
        WebElement input = driver.findElement(By.id("passwd"));
        input.sendKeys(pass);
        String tempPass = driver.findElement(By.id("passwd")).getAttribute("value");
        assertEquals(tempPass, pass);
    }

    @Test
    public void loginPositive() {
        driver.findElement(By.className("login")).click();
        WebElement input = driver.findElement(By.id("email"));
        input.sendKeys(email);
        input = driver.findElement(By.id("passwd"));
        input.sendKeys(pass);
        driver.findElement(By.id("SubmitLogin")).click();
        String loginPageTitle = driver.getTitle();
        assertEquals("My account - My Store", loginPageTitle);
    }


}
