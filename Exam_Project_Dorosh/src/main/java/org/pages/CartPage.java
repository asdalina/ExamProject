package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.elements.HeaderElements;

import java.time.Duration;

public class CartPage extends ParentPage{
    private Logger logger = Logger.getLogger(getClass());


    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//td[@class='product-name']")
    private WebElement productInCartName;


    @FindBy(xpath = "//button[@name='empty_cart']")
    private WebElement buttonEmptyCart;

    @FindBy(xpath = "//div[@class='cart-empty woocommerce-info']")
    private WebElement messageEmptyCart;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeURL() {
        return "/cart/";
    }

    public CartPage checkTextInPageTitle(String expectedMessageText) {
        checkTextInElement(pageTitle, expectedMessageText);
        return this;
    }

    public CartPage checkIsRedirectToCartPage() {
        checkURL();
        return this;
    }


    public CartPage checkProductNameInCartContains(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productInCartName));

        String actualTitle = productInCartName.getText().toLowerCase();
        assert actualTitle.contains(expectedTitle) :
                "Назва товару не співпадає! Очікувалось: " + expectedTitle + ", але отримано: " + actualTitle;
        logger.info("Назва товару співпала");
        return this;
    }

    public CartPage clickOnButtonEmptyCart() {
        clickOnElement(buttonEmptyCart);
        return this;
    }

    public CartPage checkTextInMessageEmptyCart(String expectedMessageText) {
        checkTextInElement(messageEmptyCart, expectedMessageText);
        return this;
    }
}
