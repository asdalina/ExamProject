package org.searchTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class SearchTest extends BaseTest {

    private String searchText ="qwerty";
    private String expectedAlertMessageText = "Не знайдено товарів, що відповідають вашому вибору.";

    @Test
    public void TC001_searchNonExistingProduct() {
        pageProvider.getHomePage()
                .openHomePage().
                getHeaderElement()
                .clickOnButtonSearch()
                .enterTextIntoInputSearch(searchText);
        pageProvider.getHomePage()
                .checkAlertMessageVisible()
                .checkTextInAlertMessage(expectedAlertMessageText)
                ;
    }

}