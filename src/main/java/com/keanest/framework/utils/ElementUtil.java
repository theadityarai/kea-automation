package com.keanest.framework.utils;

import org.openqa.selenium.By;
import com.keanest.framework.driver.DriverManager;

public class ElementUtil {

    public static void click(By locator) {
        DriverManager.getDriver().findElement(locator).click();
    }

    public static void type(By locator, String value) {
        DriverManager.getDriver().findElement(locator).sendKeys(value);
    }

    public static String getText(By locator) {
        return DriverManager.getDriver().findElement(locator).getText();
    }
}
