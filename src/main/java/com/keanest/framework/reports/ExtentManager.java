package com.keanest.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public final class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
        // prevent instantiation
    }

    public static synchronized ExtentReports getExtent() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + File.separator
                    + "test-output" + File.separator + "ExtentReport.html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("Kea Automation Test Report");
            sparkReporter.config().setDocumentTitle("Kea Automation Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "Kea Automation Framework");
            extent.setSystemInfo("Domain", "Healthcare SaaS");
        }
        return extent;
    }
}
