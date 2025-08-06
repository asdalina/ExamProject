package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountOrdersPage extends ParentPage{


    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement pageTitle;

    public MyAccountOrdersPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeURL() {
        return "/my-account/orders/";
    }


    public MyAccountOrdersPage checkIsRedirectToMyAccountPage() {
        checkURL();
        return this;
    }

    public MyAccountOrdersPage checkTextInPageTitle(String expectedMessageText) {
        checkTextInElement(pageTitle, expectedMessageText);
        return this;
    }
}
