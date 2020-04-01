package com.officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UnderstandingJavaSScriptExecutor {
    @Test(priority = 0, description = "Send text Serch box on Etsy")
    public void test1(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.etsy.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'"); //we can put two thins in here
                             // 1. whole java script --> documet.getElementById('element id').value='send thses characters'
    }


    @Test(priority = 2, description = "clicking on element")
    public void testcase2(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('catnav-primary-link-891').click();");
    }

    @Test(priority = 1,description = "get the page Title")
    public void testcase3(){
        //when you are looking a value to get
        //you need to use return keyword to get that value
        //if you don't use return keyword selenium will confuse and will not work.
        //this return keyword is for selenium not for java script. If you pass it on console on the website for javascript
        //it will give syntax error
        // but we are using it in intelliJ for selenium so that it can return something.
        WebDriver driver = DriverFactory.createDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println(pageTitle);
    }

    @Test
    public void test4(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://temp-mail.org/en/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualEmail = driver.findElement(By.id("mail")).getText();
        String emailCurrent = "giyin81020@itiomail.com";
        Assert.assertEquals(actualEmail, emailCurrent);

    }


    }

