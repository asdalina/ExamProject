package org.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pages.CartPage;
import org.pages.CommonActionsWithElements;

public class CartPreview extends CommonActionsWithElements {

    @FindBy(xpath = "//a[@class='button wc-forward']")
    private WebElement buttonViewBasket;


    public CartPreview(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPage clickOnButtonViewBasket() {
        clickOnElement(buttonViewBasket);
        return new CartPage(webDriver);
    }


}
