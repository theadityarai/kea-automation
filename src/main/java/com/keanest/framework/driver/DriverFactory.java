package com.keanest.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    public static WebDriver createDriver(BrowserType browser) {

        WebDriver driver;

        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;

            case EDGE:
                driver = new EdgeDriver();
                break;

            case CHROME:
            default:
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        return driver;
    }
}
