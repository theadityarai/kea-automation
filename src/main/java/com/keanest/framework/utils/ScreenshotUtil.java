package com.keanest.framework.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.keanest.framework.driver.DriverManager;

public final class ScreenshotUtil {

    private ScreenshotUtil() {
        // Utility class – prevent instantiation
    }

    public static String captureScreenshot(String testName, String status) {
        WebDriver driver = DriverManager.getDriver();

        if (driver == null) {
            return null;
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotDir = System.getProperty("user.dir") + File.separator
                + "test-output" + File.separator + "screenshots";

        new File(screenshotDir).mkdirs();

        String screenshotPath = screenshotDir + File.separator
                + status + "_" + testName + "_" + timestamp + ".png";

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotPath);

        try {
            org.openqa.selenium.io.FileHandler.copy(source, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
