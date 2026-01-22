package com.keanest.tests.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.keanest.framework.config.ConfigReader;
import com.keanest.framework.driver.BrowserType;
import com.keanest.framework.driver.DriverFactory;
import com.keanest.framework.driver.DriverManager;

public class BaseTest {

    protected Logger logger = LogManager.getLogger(this.getClass());

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional String browserFromXml) {

        logger.info("Starting test execution");

        // 1. Resolve browser: TestNG XML > run-config.properties
        String browserName = (browserFromXml != null && !browserFromXml.isEmpty())
                ? browserFromXml
                : ConfigReader.getRunProperty("browser");

        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());

        // 2. Create WebDriver and bind to ThreadLocal
        DriverManager.setDriver(
                DriverFactory.createDriver(browserType)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        logger.info("Ending test execution");

        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
