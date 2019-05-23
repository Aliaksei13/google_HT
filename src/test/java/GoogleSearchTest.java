package test.java;

import main.java.driver.PropertyManager;
import main.java.driver.SingletonWebDriver;
import main.java.logic.MainPageLogic;
import main.java.logic.ResultPageLogic;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    private MainPageLogic mainPage;
    private SingletonWebDriver singletonWebDriver = SingletonWebDriver.getInstance();
    private PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    public void setUp(){
        singletonWebDriver.initialize();
        singletonWebDriver.openURL(propertyManager.getPropertyValue("google"));
        mainPage = new MainPageLogic(singletonWebDriver.getDriver());
    }

    @AfterClass
    public void shutDown(){
        singletonWebDriver.quit();
    }

    @Test
    public void searchAndOpenWebSite(){
        ResultPageLogic resultPage = mainPage.search("Test");
        resultPage.openWebSiteInTheList(1);
        Assert.assertTrue(singletonWebDriver.getDriver().getCurrentUrl().contains("test"),
                "Test is not contain in URL");
    }
}
