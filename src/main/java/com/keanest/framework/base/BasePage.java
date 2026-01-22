package com.keanest.framework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.keanest.framework.driver.DriverManager;

public class BasePage {

    protected WebDriver driver;
    protected Logger logger;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.logger = LogManager.getLogger(this.getClass());
    }
}
