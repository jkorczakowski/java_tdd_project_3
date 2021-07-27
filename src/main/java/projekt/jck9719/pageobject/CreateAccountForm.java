package projekt.jck9719.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import projekt.jck9719.Utils;

public class CreateAccountForm {

    private WebDriver driver;

    public CreateAccountForm(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement successfullyCreatedAccount() {
        return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Welcome to your account.\")]"), 30);
    }






}