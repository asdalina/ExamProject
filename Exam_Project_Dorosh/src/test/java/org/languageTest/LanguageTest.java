package org.languageTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class LanguageTest extends BaseTest {
    private String expectedTextInLinkToShop = "ДО КОЛЕКЦІЇ";
    private String expectedTextInLinkToShopEng = "SHOP NOW";

    @Test
    public void TC002_switchingToEnglish() {
        pageProvider.getHomePage()
                .openHomePage()
                .checkLinkToShopVisible()
                .checkTextInLinkToShop(expectedTextInLinkToShop)
                .closeLanguageNoticeIfPresent();
        pageProvider.getHomePage()
                .getHeaderElement()
                .clickOnButtonCurrentLanguage();
        pageProvider.getHomePage()
                .clickOnButtonEnglishLanguage()
                .checkLinkToShopVisible()
                .checkTextInLinkToShop(expectedTextInLinkToShopEng)
                ;
    }
}
