package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElements{
    private Logger logger = Logger.getLogger(getClass());

    protected String baseURL = "https://thelace.com.ua";
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }
    protected void checkURL() {
        Assert.assertEquals("URL is not expected"
                , baseURL + getRelativeURL()
                , webDriver.getCurrentUrl()

        );
        logger.info("URL is expected");
    }
    abstract protected String getRelativeURL();

}
