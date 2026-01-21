package com.keanest.framework.base;

import org.openqa.selenium.WebDriver;
import com.keanest.framework.driver.DriverManager;

public class BasePage {

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
