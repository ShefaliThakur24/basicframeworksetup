package com.basicsetup.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners implements ITestListener {
    ////https://learn-automation.com/extent-report-with-selenium-webdriver/
    public ExtentSparkReporter spark;
    public ExtentReports extent;
    public ExtentTest test;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();//making test object of extent test thread safe

    @Override
    public void onStart(ITestContext testContext) {
        //specify location of the report

        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
        extent = new ExtentReports();

        spark.config().setDocumentTitle("Automation Report"); // Tile of report
        spark.config().setReportName("Rest API Testing Report"); // name of the report
        //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
        spark.config().setTheme(Theme.DARK);

        extent.attachReporter(spark);
        extent.setSystemInfo("Project Name", "Employee Database API");
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environemnt", "QA");
        extent.setSystemInfo("user", "shefali");
        extent.setReportUsesManualConfiguration(true);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());// create new entry in th report
        extentTest.set(test);//setting test object to extentTest threadsafe variable

    }


    @Override
    public void onTestSuccess(ITestResult result) {
        //test=extent.createTest(result.getClass().getName());
        //test.createNode(result.getName());

        extentTest.get().log(Status.PASS, "Test Case PASSED IS " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {


        extentTest.get().log(Status.PASS, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
        extentTest.get().log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush();
    }

}

