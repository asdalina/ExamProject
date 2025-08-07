package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class ParentPage extends CommonActionsWithElements{
    private Logger logger = Logger.getLogger(getClass());
    protected JavascriptExecutor jsExecutor;


    protected String baseURL = "https://thelace.com.ua";

    public ParentPage(WebDriver webDriver) {

        super(webDriver);
        this.jsExecutor = (JavascriptExecutor) webDriver;

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
