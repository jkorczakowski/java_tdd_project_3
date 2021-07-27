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


public class AddItemPOTest {
    private WebDriver chromeDriver;
    private Actions action;

    private Clothes clothes;
    private Cart cart;
    private ShoppingActions shoppingActions;



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
        shoppingActions = new ShoppingActions(chromeDriver);
        String baseUrl = "http://automationpractice.com/index.php";
        chromeDriver.get(baseUrl);
    }

    @AfterEach
    public void tearDown() {
        chromeDriver.quit();
    }

//    @Test
//    public void addTwoDressesCheckQtPositive() {
//        action.moveToElement(clothes.getDressesBtn()).perform();
//        action.moveToElement(clothes.getSummerDressesBtn()).perform();
//        clothes.getSummerDressesBtn().click();
//
//        action.moveToElement(clothes.getSummerDressProduct(1)).perform();
//        action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
//        action.click(shoppingActions.getAddToCartBtn()).build().perform();
//        action.click(shoppingActions.getContinueShopingBtn()).build().perform();
//
//        action.moveToElement(clothes.getDressesBtn()).perform();
//        action.moveToElement(clothes.getCasualDressesBtn()).perform();
//        clothes.getCasualDressesBtn().click();
//
//        action.moveToElement(clothes.getCasualDressProduct(1)).perform();
//        action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
//        action.click(shoppingActions.getAddToCartBtn()).build().perform();
//        action.click(shoppingActions.getContinueShopingBtn()).build().perform();
//        action.moveToElement(cart.getCartTab()).perform();
//
//        assertEquals(2, cart.getCartProductsQty().size());
//    }

    @Test
    public void addOneCasualDressCheckQtPositive() {
        action.moveToElement(clothes.getDressesBtn()).perform();
        action.moveToElement(clothes.getCasualDressesBtn()).perform();
        clothes.getCasualDressesBtn().click();

        action.moveToElement(clothes.getCasualDressProduct(1)).perform();
        action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
        action.click(shoppingActions.getAddToCartBtn()).build().perform();
        action.click(shoppingActions.getContinueShopingBtn()).build().perform();

        action.moveToElement(cart.getCartTab()).perform();

        assertEquals(1, cart.getCartProductsQty().size());

    }

    @Test
    public void addThreeDressesCheckTotalAndShippingPricePositive() {
        action.moveToElement(clothes.getDressesBtn()).perform();
        action.moveToElement(clothes.getSummerDressesBtn()).perform();
        clothes.getSummerDressesBtn().click();

        action.moveToElement(clothes.getSummerDressProduct(1)).perform();
        action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
        action.click(shoppingActions.getAddToCartBtn()).build().perform();
        action.click(shoppingActions.getContinueShopingBtn()).build().perform();

        action.moveToElement(clothes.getDressesBtn()).perform();
        action.moveToElement(clothes.getCasualDressesBtn()).perform();
        clothes.getCasualDressesBtn().click();

        action.moveToElement(clothes.getCasualDressProduct(1)).perform();
        action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
        action.click(shoppingActions.getAddToCartBtn()).build().perform();
        action.click(shoppingActions.getContinueShopingBtn()).build().perform();

        action.moveToElement(clothes.getDressesBtn()).perform();
        action.moveToElement(clothes.getEveningDressesBtn()).perform();
        clothes.getEveningDressesBtn().click();

        action.moveToElement(clothes.getEveningDressProduct(1)).perform();
        action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
        action.click(shoppingActions.getAddToCartBtn()).build().perform();
        action.click(shoppingActions.getContinueShopingBtn()).build().perform();

        action.moveToElement(cart.getCartTab()).perform();
        action.moveToElement(cart.getCartShipingCost()).perform();
        action.moveToElement(cart.getCartTotalPrice()).perform();

        assertAll(
                () -> assertEquals("$2.00", cart.getCartShipingCost().getText()),
                () -> assertEquals("$107.97", cart.getCartTotalPrice().getText())
        );

    }
}
