package org.workWithElementsTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class ContactsTest extends BaseTest {
    private String expectedPageTitle = "КОНТАКТИ";


    @Test
    public void TC004_checkContactsTest() {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnLinkContacts()
                .checkIsRedirectToContactPage()
                .checkTextInPageTitle(expectedPageTitle)
                .checkEmailChapterVisible();
    }
}
