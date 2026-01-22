package com.keanest.framework.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.keanest.framework.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.createTest(
                result.getMethod().getMethodName(),
                result.getMethod().getDescription()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getExtentTest().pass("Test passed");

        String screenshotPath = ScreenshotUtil.captureScreenshot(
                result.getMethod().getMethodName(),
                "PASS"
        );

        if (screenshotPath != null) {
            try {
                ExtentTestManager.getExtentTest()
                        .addScreenCaptureFromPath(screenshotPath, "PASS Screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getExtentTest().fail(result.getThrowable());

        String screenshotPath = ScreenshotUtil.captureScreenshot(
                result.getMethod().getMethodName(),
                "FAIL"
        );

        if (screenshotPath != null) {
            try {
                ExtentTestManager.getExtentTest()
                        .addScreenCaptureFromPath(screenshotPath, "FAIL Screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getExtentTest().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtent().flush();
        ExtentTestManager.unload();
    }
}
