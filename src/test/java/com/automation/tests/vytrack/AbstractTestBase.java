package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public abstract class AbstractTestBase {
    //we made TestBase class abract bec. we want it to be implemented.
    //anything that is not private will be inherited by its child class.
    //if we setup/design TestBase---> it will help us when we have so many codes in our classes in the future.
    //in TestBAse we will not have @Test
    //will be visible in the subclass, regardless on subclass location(same package or not)
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    public void setupTest() {
        report = new ExtentReports();
        String reportPath = "";
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";
        }
        //is an HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }

    @AfterTest
    public void tearDownTest() {
        report.flush(); // to release report
    }


    @BeforeMethod
    public void setup() {
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15); //creating explicit wait object so that in the Test (subclass)
        //if we  need wait we will just call wait.until...........
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult class describes the result of a test.
        //if test fails, take a screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = BrowserUtils.getScreenShot(iTestResult.getName());
            test.addScreenCaptureFromPath(screenshotPath); //attach screenshot
            test.fail(iTestResult.getName());//attach test name that failed
            test.fail(iTestResult.getThrowable()); //get console output
        }
        Driver.closeDriver();
    }
}
//Driver.getDriver().get(URL);
//We instantiate webDriver (=new className) in Driver class under utilities package.
//getDriver();  method will return us driver object that comes from driver class.
//call the static getDriver() method through the classNAme
//By doing this; we will know that we are always calling the same driver