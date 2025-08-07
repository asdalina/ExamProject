package org.cartTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class CartTest extends BaseTest {


    private String pageTitle="КОШИК";
    private String emptyCartMessage = "Ваш кошик порожній.";

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
                .clickOnSelectedProduct()
                .checkProductTitleContains(selectedProductName)
                .clickOnButtonAddToBasket();
        pageProvider.getHomePage()
                .getHeaderElement()
                .clickOnButtonCart()
                .clickOnButtonViewBasket()
                .checkIsRedirectToCartPage()
                .checkTextInPageTitle(pageTitle)
                .checkProductNameInCartContains(selectedProductName)
                .clickOnButtonEmptyCart()
                .checkTextInMessageEmptyCart(emptyCartMessage)
                ;
    }


}
