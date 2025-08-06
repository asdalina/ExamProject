package org.loginTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {


    private String expectedPageTitle = "ЗАМОВЛЕННЯ";

    @Test
    public void TC003_validLogin() {
        pageProvider.getHomePage()
                .openHomePage()
                .closeLanguageNoticeIfPresent();
        pageProvider.getHomePage()
                .getHeaderElement()
                .clickOnButtonAccount();
        pageProvider.getHomePage()
                .closeLanguageNoticeIfPresent();
                pageProvider.getLoginPage()
                .enterValidCredentials()
                .clickOnButtonLogin();
        pageProvider.getHomePage()
                .getHeaderElement()
                .clickOnButtonAccountForLoggedUser()
                .checkIsRedirectToMyAccountPage()
                .checkTextInPageTitle(expectedPageTitle);

    }
}
