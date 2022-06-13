package com.basicsetup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.basicsetup.handlers.PostHandler;
import com.basicsetup.model.responseDto.fastapi.GetResponse;
import com.basicsetup.utils.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class GetApi extends BaseClass {
    private ExtentReports extent;

    private PostHandler postHelper;

//    @BeforeTest
//    public void config() {
//
//        String path = System.getProperty("user.dir") + "/reports/Report.html";
//        ExtentSparkReporter spark = new ExtentSparkReporter(path);
//        spark.config().setReportName("Get Api Results");
//        spark.config().setDocumentTitle("Test Results");
//
//        extent = new ExtentReports();
//        extent.attachReporter(spark);
//        extent.setSystemInfo("Tester", "Shefali");
//    }

    @BeforeClass
    public void init() {
        postHelper = new PostHandler();

    }


    @Test(groups = {"sanity"})
    public void testGetPosts() {

        logger.info("Starting Get Request");
        List<GetResponse> response = postHelper.getPostResponse();
        Assert.assertNotNull(response, "response is not empty");
        Assert.assertEquals(response.get(0).getPost().getContent(), "checkout these awesome beaches");

        // Assert.assertEquals(list.get(1).getPost().getContent(),equals(""));
    }

}
