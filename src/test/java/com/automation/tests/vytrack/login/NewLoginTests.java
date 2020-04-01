package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {
    /**
     * lOG IN AND VERIFY THAT PAGE TITLE IS A "daSHBOARD"
     */
//we use encapsulation because we want to hide data from hackers.
    //it is about design. we want to design our
    //we make our code more organized and forced ........
    @Test
    public void verifyPageTitle(){
        //test-->extentTest object
        //we must add to every test at the beginning
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        //if assertion passed, it will et tet status in report to passed.
        test.pass("Page title Dashboard was verified");
    }

    /**
     * Enter wrong credentials and verify warning message
     */


    @Test
    public void verifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        //take a screenshot

        BrowserUtils.getScreenShot("loginPage");
    }
}