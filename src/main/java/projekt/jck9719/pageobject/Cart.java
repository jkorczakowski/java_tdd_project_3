package projekt.jck9719.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projekt.jck9719.Utils;

import java.util.List;

public class Cart {
    private WebDriver driver;

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCartTab() {
        return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"Cart\")]/.."), 30);
    }

    public WebElement getCartProductDeleteX(int numOfElement) {
        return Utils.waitToBeClickable(driver, By.xpath("//dt[" + numOfElement + "]//a[@class=\"ajax_cart_block_remove_link\"]"), 30);
    }


    public WebElement getCartShipingCost() {
        return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"cart-prices\"]//span[contains(.,\"$2.00\")]"), 30);
    }

    public WebElement getCartTotalPrice() {
        return Utils.waitForElementPresence(driver, By.xpath("//span[@class=\"price cart_block_total ajax_block_cart_total\"]"), 30);
    }

    public WebElement getCartTabCheckOutBtn() {
        return Utils.waitToBeClickable(driver, By.xpath("//a[@id=\"button_order_cart\"]/span[contains(text(), \"Check out\")]"), 30);
    }

    public List<WebElement> getCartProductsQty() {
        return driver.findElements(By.xpath("//dt"));
    }
}
