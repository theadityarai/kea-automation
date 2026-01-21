package com.keanest.framework.utils;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.keanest.framework.driver.DriverManager;

public class ScreenshotUtil {

    public static File captureScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);
    }
}
