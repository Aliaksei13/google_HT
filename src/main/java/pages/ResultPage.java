package main.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage {
    @FindAll(@FindBy(xpath = "//a/ancestor::div[@class='r']"))
    private List<WebElement> webSiteLinks;

    public List<WebElement> getWebSiteLinks() {
        return webSiteLinks;
    }
}
