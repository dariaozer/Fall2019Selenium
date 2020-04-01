package com.ownPractice.SCookB.SynchronizingTests;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaits {
    //if WebDriver cannot find an element in the DOM,
    // it will wait for defined amount of time for the element to be appear.
//    The default setting is 0
    // Once the specified wait time
//    is over, it will try searching for the element once again. If the element is not found in specified
//    time, it will throw the NoSuchElement exception.
    private WebDriver driver;
    @Test
    public void testWithImplicitWait(){
       driver = DriverFactory.createDriver("chrome");
       driver.get("http://cookbook.seleniumacademy.com/AjaxDemo.html");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
// Get link for Page 4 and click on it
            driver.findElement(By.linkText("Page 4")).click();
// Get an element with id page4 and verify it's text
            WebElement message = driver.findElement(By.id("page4"));
           Assert.assertTrue(message.getText().contains("Nunc nibh tortor"));
        } finally {
            driver.quit();
        }

    }
}
// we can have try without catch block by using finally block.
//You can use try with finally.
//finally block always executes even if you have exception or
// return statement in try block except in case of System.exit().
//if you have return statement in try block the flow will be:
//1- try block statement  2- finallyblock statement 3-- try block return(goes back to try block for return)
//if both, try and finally blocks have return statement:
//then, return of finally will override the return of try block.
//what if exception is thrown in try block: If exception is thrown in try block, still finally block executes.