package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends ParentPage{

    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//h2[text()='EMAIL']")
    private WebElement emailChapter;


    public ContactPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeURL() {
        return "/kontakty/";
    }

    public ContactPage checkIsRedirectToContactPage() {
        checkURL();
        return this;
    }

    public ContactPage checkTextInPageTitle(String expectedMessageText) {
        checkTextInElement(pageTitle, expectedMessageText);
        return this;
    }

    public ContactPage checkEmailChapterVisible() {
        checkIsElementDisplayed(emailChapter);
        return this;
    }
}
