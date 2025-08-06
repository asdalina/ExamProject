package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.elements.HeaderElements;

import java.time.Duration;
import java.util.List;

public class HomePage extends ParentPage{
    private Logger logger = Logger.getLogger(getClass());


    @FindBy(xpath = "//p[@class='woocommerce-info']")
    private WebElement alertTextMessage;

    @FindBy(xpath = "(//span[@class='konte-button button-outline button large square'])[1]")
    private WebElement linkToShop;
    @FindBy(xpath = "(//a[contains(@href, '/en') and contains(., 'ENG')])[1]")
    private WebElement buttonEnglishLanguage;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeURL() {
        return "";
    }

    public HomePage openHomePage() {
        webDriver.get(baseURL);
        logger.info("Login page was opened with url " + baseURL);
        return this;
    }

    public HomePage clickOnButtonEnglishLanguage() {
               clickOnElement(buttonEnglishLanguage);
               return this;
    }

    public HeaderElements getHeaderElement() {
        return new HeaderElements(webDriver);
    }

    public HomePage checkAlertMessageVisible() {
        checkIsElementDisplayed(alertTextMessage);
        return this;
    }

    public HomePage checkTextInAlertMessage(String expectedMessageText) {
        checkTextInElement(alertTextMessage, expectedMessageText);
        return this;
    }

    public HomePage checkLinkToShopVisible() {
        checkIsElementDisplayed(linkToShop);
        return this;
    }

    public HomePage checkTextInLinkToShop(String expectedMessageText) {
        checkTextInElement(linkToShop, expectedMessageText);
        return this;
    }

    public void closeLanguageNoticeIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

            // Проверяем, есть ли кнопка закрытия
            List<WebElement> closeButtons = webDriver.findElements(By.cssSelector(".notice-close"));

            if (!closeButtons.isEmpty()) {
                wait.until(ExpectedConditions.elementToBeClickable(closeButtons.get(0)));
                closeButtons.get(0).click();
                logger.info("Language/currency notice was closed.");
            }
        } catch (Exception e) {
            logger.warn("No language notice found or couldn't close it.");
        }
    }
}
