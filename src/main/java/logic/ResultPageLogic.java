package main.java.logic;

import main.java.pages.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResultPageLogic extends ResultPage {
    private WebDriver driver;

    public ResultPageLogic(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openWebSiteInTheList(int number){
        getWebSiteLinks().get(number - 1).click();
    }
}
