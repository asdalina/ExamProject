package org.cartTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class CartTest extends BaseTest {


    @Test
    public void TC005_addAndDeleteItemFromCart() {
        pageProvider.getHomePage()
                .openHomePage()
                .closeLanguageNoticeIfPresent();
        pageProvider.getHomePage()
                .clickOnHamburgerMenu()
                .clickOnLinkNewIn()
                .checkIsRedirectToNewInPage();

        String selectedProductName = pageProvider.getNewInPage().getSelectedProductName();

        pageProvider.getNewInPage()
                .clickOnSelectedProduct();
    }


}
