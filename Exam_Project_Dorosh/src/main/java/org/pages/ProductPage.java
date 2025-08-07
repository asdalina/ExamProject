package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends ParentPage{
    private Logger logger = Logger.getLogger(getClass());
 @FindBy(xpath = "//h1[@class='product_title entry-title']")
 private WebElement productTitle;

    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    private WebElement buttonAddToBasket;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeURL() {
        return "";
    }

    public ProductPage clickOnButtonAddToBasket() {
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", buttonAddToBasket);
        clickOnElement(buttonAddToBasket);
        return this;
    }

public ProductPage checkProductTitleContains(String expectedTitle) {
 WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(productTitle));

        String actualTitle = productTitle.getText().toLowerCase();
        assert actualTitle.contains(expectedTitle) :
                "Назва товару не співпадає! Очікувалось: " + expectedTitle + ", але отримано: " + actualTitle;
        logger.info("Назва товару співпала");
        return this;
    }
}
