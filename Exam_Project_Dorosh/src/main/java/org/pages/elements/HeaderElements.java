package org.pages.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.CommonActionsWithElements;
import org.pages.LoginPage;
import org.pages.MyAccountOrdersPage;

public class HeaderElements extends CommonActionsWithElements {
    private Logger logger = Logger.getLogger(getClass());


    @FindBy(xpath = "//div[@class='current-selected']")
    private WebElement buttonCurrentLanguage;

    @FindBy(xpath = "(//span[contains(@class, 'search-icon')])[1]")
    private WebElement buttonSearch;

    @FindBy(xpath = "(//input[@placeholder='Пошук'])[1]")
    private WebElement inputSearch;

    @FindBy(xpath = " (//div[@class=’code’ and text() = 'ENG'])[1]")
    private WebElement buttonEnglishLanguage;

    @FindBy(xpath = "//a[@data-target='login-panel']")
    private WebElement buttonAccount;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }


    public HeaderElements clickOnButtonSearch() {
        clickOnElement(buttonSearch);
        return this;
    }

    public HeaderElements clickOnButtonAccount() {
        clickOnElement(buttonAccount);
        return this;
    }


public MyAccountOrdersPage clickOnButtonAccountForLoggedUser() {
    By locator = By.xpath("//div[@class='header-main header-contents has-center logo-center']//a[@href='https://thelace.com.ua/my-account/' and not(contains(@class, 'active'))]");

    int retries = 3;
    for (int i = 0; i < retries; i++) {
        try {
            WebElement button = webDriverWait10
                    .withMessage("Element is not clickable")
                    .until(ExpectedConditions.elementToBeClickable(locator));
            button.click();
            logger.info("Account button (logged user) was clicked");
            return new MyAccountOrdersPage(webDriver);
        } catch (StaleElementReferenceException e) {
            logger.warn("Stale element detected. Retrying... [" + (i + 1) + "/" + retries + "]");
        }
    }

    throw new RuntimeException("Failed to click on 'Account' after login due to repeated StaleElementReferenceException");
}


    public HeaderElements clickOnButtonCurrentLanguage() {
        clickOnElement(buttonCurrentLanguage);
        return this;
    }



    public HeaderElements enterTextIntoInputSearch(String text) {
        clearAndEnterTextToElement(inputSearch, text);
        inputSearch.sendKeys(Keys.ENTER);             // нажимаем Enter
        return this;
    }
}