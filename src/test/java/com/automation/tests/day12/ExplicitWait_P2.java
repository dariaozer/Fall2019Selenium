package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait_P2 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= DriverFactory.createDriver("chrome");
    }

    @Test
    public void waitForTitle(){
        driver.get("https://www.google.com/");
  //in order to use Explicit wait--> first we need to create WebDriverWait object
        //we need to pass driver, and wait time inside the constructor.
        WebDriverWait wait = new WebDriverWait(driver,10);
        //wait upto 10 seconds until title contains google
        wait.until(ExpectedConditions.titleContains("Google"));
        driver.navigate().to("https://www.amazon.com/");
        wait.until(ExpectedConditions.titleContains("Amazon"));
    }

    @Test
    public void waitForVisibility(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.tagName("button")).click();
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        String expected ="Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void waitForElementToBeClickableTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait = new WebDriverWait(driver,20);

        WebElement userName = driver.findElement(By.cssSelector("input[type='username']"));
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
//  It threw the following exception---> ElementClickInterceptedException: element click intercepted: something else was clicked instead of your element.
        //Other element would receive the click: <div class="loadingoverlay" st......
        //above one was in the console for reason of exception. it was clicked instead of submitBtn
        //this uploads and then disaperas.
        //overlay screen ==> div element goes on top of page we have this page this screen, it will show up but not immediately there is a gap
//selenium starts manipulating once load done, but there is a gap=> between loading complete - overlay screen pop up
//submit button condition not helpful cause it becomes true even before overlay appears
//so we put condition:
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        userName.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        submitBtn.click();


        String expected ="Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual, expected);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
