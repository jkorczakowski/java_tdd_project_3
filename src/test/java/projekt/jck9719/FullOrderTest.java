package projekt.jck9719;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import projekt.jck9719.pageobject.*;

import static org.junit.jupiter.api.Assertions.*;

public class FullOrderTest {
    private WebDriver chromeDriver;
    private Actions action;
    private CartSummary summary;
    private Clothes clothes;
    private Cart cart;
    private Account account;
    private ShoppingActions shoppingActions;
    private SignInForm signinForm;



    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeDriver = new ChromeDriver(chromeOptions);
        action = new Actions(chromeDriver);
        clothes = new Clothes(chromeDriver);
        cart = new Cart(chromeDriver);
        summary = new CartSummary(chromeDriver);
        shoppingActions = new ShoppingActions(chromeDriver);
        signinForm = new SignInForm(chromeDriver);
        account = new Account(chromeDriver);
        String baseUrl = "http://automationpractice.com/index.php";
        chromeDriver.get(baseUrl);
    }

    @AfterEach
    public void tearDown() {
        chromeDriver.quit();
    }

    @Test
    public void sitePositive() {
        assertTrue(clothes.getDressesBtn().isDisplayed());
    }

    @Test
    public void fullOrderHistoryCheck() {
        action.moveToElement(clothes.getDressesBtn()).perform();
        action.moveToElement(clothes.getCasualDressesBtn()).perform();
        clothes.getCasualDressesBtn().click();

        action.moveToElement(clothes.getCasualDressProduct(1)).perform();
        action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
        action.click(shoppingActions.getAddToCartBtn()).build().perform();
        action.click(shoppingActions.getContinueShopingBtn()).build().perform();

        action.moveToElement(cart.getCartTab()).perform();
        action.moveToElement(cart.getCartTabCheckOutBtn()).perform();
        action.click(cart.getCartTabCheckOutBtn()).build().perform();

        summary.getCartProceedBtn().click();

        signinForm.setEmailField("gaunt1111@gmail.com");
        signinForm.setPasswordField("testpass");
        signinForm.getSignInBtn().click();

        summary.getCartProceedBtnTwo().click();
        summary.getCartProceedBtnTwo().click();
        action.moveToElement(summary.getCartSummTermsOfServiceDialog()).perform();
        action.moveToElement(summary.getCartSummTermsOfServiceDialogClose()).perform();
        action.click(summary.getCartSummTermsOfServiceDialogClose()).build().perform();

        chromeDriver.navigate().refresh();

        summary.getCartSummTermsOfServiceCheck().click();
        summary.getCartProceedBtnTwo().click();
        summary.getCartSummPayByBankWire().click();
        summary.getCartSummOtherPaymentMethods().click();
        summary.getCartSummPayByCheck().click();
        summary.getCartSummConfirmOrderBtn().click();

        account.getAccountBtn().click();
        account.getAccountOrderHistoryBtn().click();
        account.getAccountBtn().click();
        account.getAccountOrderHistoryBtn().click();

        assertNotEquals(account.getAccountOrdersLis().size(), 0);

    }
}
