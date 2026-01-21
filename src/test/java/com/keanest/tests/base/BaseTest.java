package com.keanest.tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.keanest.framework.driver.BrowserType;
import com.keanest.framework.driver.DriverFactory;
import com.keanest.framework.driver.DriverManager;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.setDriver(
                DriverFactory.createDriver(BrowserType.CHROME)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
