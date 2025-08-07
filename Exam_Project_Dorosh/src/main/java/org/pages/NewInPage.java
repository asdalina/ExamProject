package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewInPage extends ParentPage{
    private Logger logger = Logger.getLogger(getClass());

    @FindBy(xpath = "(//div[@class='woocommerce-loop-product__title'])[2]")
    private WebElement selectedProduct;

    public NewInPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeURL() {
        return "/product-category/novynky/";
    }

    public NewInPage checkIsRedirectToNewInPage() {
        checkURL();
        return this;
    }

    public ProductPage clickOnSelectedProduct() {
        clickOnElement(selectedProduct);
        return new ProductPage(webDriver);
    }

    public String getSelectedProductName() {
        String titleOfSelectedProduct = selectedProduct.getText();
        logger.info("Назва товару - " + titleOfSelectedProduct);
        return titleOfSelectedProduct;

    }



}
