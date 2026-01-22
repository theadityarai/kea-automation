package com.keanest.framework.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    private ExtentTestManager() {
        // prevent instantiation
    }

    public static synchronized void createTest(String testName, String description) {
        ExtentTest test = ExtentManager.getExtent().createTest(testName, description);
        extentTest.set(test);
    }

    public static synchronized ExtentTest getExtentTest() {
        return extentTest.get();
    }

    public static synchronized void unload() {
        extentTest.remove();
    }
}
