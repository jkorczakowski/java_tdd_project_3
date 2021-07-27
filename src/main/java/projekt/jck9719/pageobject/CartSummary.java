package projekt.jck9719.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projekt.jck9719.Utils;

public class CartSummary {

    private WebDriver driver;

    public CartSummary(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCartSummQtyMinus(int numOfProduct) {
        return Utils.waitToBeClickable(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//a[@title=\"Subtract\"]"), 30);
    }

    public WebElement getCartSummQtyPlus(int numOfProduct) {
        return Utils.waitToBeClickable(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//a[@title=\"Add\"]"), 30);
    }

    public WebElement getCartSummTotalProductsPrice() {
        return Utils.waitForElementPresence(driver, By.id("total_product"), 30);
    }

    public WebElement getCartProceedBtn() {
        return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"), 30);
    }


    public WebElement getCartProceedBtnTwo() {
        return Utils.waitToBeClickable(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"Proceed to checkout\")]"), 30);
    }


    public WebElement getCartSummTermsOfServiceCheck() {
        return Utils.waitForElementPresence(driver, By.id("cgv"), 30);
    }

    public WebElement getCartSummTermsOfServiceDialog() {
        return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"You must agree to the terms of service before continuing.\")]"), 30);
    }

    public WebElement getCartSummTermsOfServiceDialogClose() {
        return Utils.waitForElementPresence(driver, By.xpath("//a[@class=\"fancybox-item fancybox-close\"]"), 30);
    }

    public WebElement getCartSummPayByBankWire() {
        return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Pay by bank wire\"]"), 30);
    }

    public WebElement getCartSummPayByCheck() {
        return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Pay by check.\"]"), 30);
    }

    public WebElement getCartSummConfirmOrderBtn() {
        return Utils.waitToBeClickable(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"I confirm my order\")]"), 30);
    }

    public WebElement getCartSummOtherPaymentMethods() {
        return Utils.waitToBeClickable(driver, By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=order&step=3\"]"), 30);
    }

}