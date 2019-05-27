package main.java.logic;

import main.java.driver.Wait;
import main.java.pages.GooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GooglePageLogic extends GooglePage {

    private WebDriver driver;

    public GooglePageLogic(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ResultPageLogic search(String value){
        getSearchField().sendKeys(value);
        Wait.waitFor(driver, 10, getSearchButton());
        getSearchButton().click();
        return new ResultPageLogic(driver);
    }
}
