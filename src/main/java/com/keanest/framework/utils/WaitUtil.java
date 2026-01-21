package com.keanest.framework.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.keanest.framework.driver.DriverManager;

public class WaitUtil {

    public static void waitForVisible(By locator, int seconds) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
