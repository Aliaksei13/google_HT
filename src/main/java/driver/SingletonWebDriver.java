package main.java.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SingletonWebDriver {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static SingletonWebDriver instance;

    private SingletonWebDriver() {
    }

    public static SingletonWebDriver getInstance(){
        if(instance == null){
            instance = new SingletonWebDriver();
        }
        return instance;
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    public void initialize() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\anduser\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        driver.set(new FirefoxDriver());
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void quit() {
        getDriver().quit();
    }

    public void close() {
        getDriver().close();
    }

    public void openURL(String URL) {
        getDriver().get(URL);
    }
}
