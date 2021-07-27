//package projekt.jck9719;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.opera.OperaDriver;
//import projekt.jck9719.pageobject.CreateAccountForm;
//import projekt.jck9719.pageobject.SignInForm;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class LogInPOTest {
//    private WebDriver operaDriver;
//    private CreateAccountForm createAccountForm;
//    private SignInForm signin;
//
//    @BeforeAll
//    public static void setupDriver() {
//        WebDriverManager.operadriver().setup();
//    }
//
//    @BeforeEach
//    public void setUp() {
//        operaDriver = new OperaDriver();
//        operaDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        createAccountForm = new CreateAccountForm(operaDriver);
//        signin = new SignInForm(operaDriver);
//
//        String baseUrl = "http://automationpractice.com/index.php?controller=authentication";
//        operaDriver.get(baseUrl);
//    }
//
//    @AfterEach
//    public void tearDown() {
//        operaDriver.quit();
//    }
//
//    @Test
//    public void sitePositive() {
//        assertAll(
//                () -> assertTrue(signin.getSignInForm().isDisplayed()),
//                () -> assertTrue(signin.getSignInEmailField().isDisplayed()),
//                () -> assertTrue(signin.getSignInPasswordField().isDisplayed()),
//                () -> assertTrue(signin.getSignInBtn().isEnabled())
//        );
//    }
//
//    @Test
//    public void invalidEmailPositive() {
//        signin.setEmailField("wrong@gmail.com");
//        signin.setPasswordField("testpass");
//        signin.getSignInBtn().click();
//
//        assertTrue(signin.getAuthenticationFailedError().isDisplayed());
//    }
//
//    @Test
//    public void invaildPasswordPositive() {
//        signin.setEmailField("gaunt1111@gmail.com");
//        signin.setPasswordField("wrongpass");
//        signin.getSignInBtn().click();
//
//        assertTrue(signin.getAuthenticationFailedError().isDisplayed());
//
//    }
//
//    @Test
//    public void invalidEmailAndPasswordPositive() {
//        signin.setEmailField("wrong@gmail.com");
//        signin.setPasswordField("wrongpass");
//        signin.getSignInBtn().click();
//
//        assertTrue(signin.getAuthenticationFailedError().isDisplayed());
//    }
//
//    @Test
//    public void emptyEmailPositive() {
//        signin.setEmailField("");
//        signin.setPasswordField("testpass");
//        signin.getSignInBtn().click();
//
//        assertTrue(signin.getEmailRequiredError().isDisplayed());
//    }
//
//    @Test
//    public void emptyPasswordPositive() {
//        signin.setEmailField("gaunt1111@gmail.com");
//        signin.setPasswordField("");
//        signin.getSignInBtn().click();
//
//        assertTrue(signin.getPasswordRequiredError().isDisplayed());
//    }
//
//    @Test
//    public void emptyEmailAndPasswordNegative() {
//        signin.setEmailField("");
//        signin.setPasswordField("");
//        signin.getSignInBtn().click();
//
//        assertTrue(signin.getEmailRequiredError().isDisplayed());
//    }
//
//    @Test
//    public void invalidEmailFormatPositive() {
//        signin.setEmailField("email");
//        signin.getSignInPasswordField().click();
//
//        assertTrue(signin.getEmailHighlightedRed().isDisplayed());
//    }
//
//    @Test
//    public void validEmailFormatPositive() {
//        signin.setEmailField("gaunt1111@gmail.com");
//        signin.getSignInPasswordField().click();
//
//        assertTrue(signin.getEmailHighlightedGreen().isDisplayed());
//    }
//
//    @Test
//    public void logInNegative() {
//        signin.setEmailField("gaunt1111@gmail.com");
//        signin.setPasswordField("testpass");
//        signin.getSignInBtn().click();
//
//        assertTrue(createAccountForm.successfullyCreatedAccount().isDisplayed());
//    }
//}
