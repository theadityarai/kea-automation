package com.keanest.tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.keanest.framework.config.ConfigReader;
import com.keanest.framework.config.EnvironmentConfig;
import com.keanest.framework.driver.BrowserType;
import com.keanest.framework.driver.DriverFactory;
import com.keanest.framework.driver.DriverManager;

public class BaseTest {

    @Parameters({"env", "browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String xmlEnv, String xmlBrowser) {

        // Resolve environment
        String env = (xmlEnv != null && !xmlEnv.isEmpty())
                ? xmlEnv
                : ConfigReader.getRunProperty("env");

        // Resolve browser
        String browser = (xmlBrowser != null && !xmlBrowser.isEmpty())
                ? xmlBrowser
                : ConfigReader.getRunProperty("browser");

        BrowserType browserType =
                BrowserType.valueOf(browser.toUpperCase());

        DriverManager.setDriver(
                DriverFactory.createDriver(browserType)
        );

        // Open application URL
        DriverManager.getDriver()
                .get(EnvironmentConfig.getEnvProperty("base.url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
