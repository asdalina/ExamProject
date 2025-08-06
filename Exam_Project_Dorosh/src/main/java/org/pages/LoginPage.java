package org.pages;

import org.apache.log4j.Logger;
import org.data.TestData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pages.elements.HeaderElements;

import static java.awt.SystemColor.text;
import static org.data.TestData.VALID_EMAIL_UI;
import static org.data.TestData.VALID_PASSWORD_UI;

public class LoginPage extends ParentPage{
    private Logger logger = Logger.getLogger(getClass());

    @FindBy(xpath = "//div[@class='login-panel offscreen-panel open']//input[@name='username']")
    private WebElement inputUserName;

    @FindBy(xpath = "//div[@class='login-panel offscreen-panel open']//input[@id='panel_password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@class='login-panel offscreen-panel open']//button[@name='login']")
    private WebElement buttonLogin;



    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeURL() {
        return "";
    }

    public LoginPage enterValidCredentials() {
        clearAndEnterTextToElement(inputUserName, VALID_EMAIL_UI);
        clearAndEnterTextToElement(inputPassword, VALID_PASSWORD_UI);
        return this;
    }

    public void clickOnButtonLogin() {
        clickOnElement(buttonLogin);
    }
}
