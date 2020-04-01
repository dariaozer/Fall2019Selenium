package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class WarmUp_WebTable {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    /**
     * Warm-up task for 15 minutes:
     * Go to http://practice.cybertekschool.com/tables
     * Click on "Last name" column name
     * Verfiy that table is sorted by last name in alphabetic order.
     */

    @Test
    public void verifyLastNamesAreSorted(){
      driver.findElement(By.xpath("//table[1]//th[1]")).click();
        List<WebElement> lastNames =driver.findElements(By.xpath("//table[1]//tbody//tr"));
        for(int i = 0; i<lastNames.size()-1; i++){
            String value = lastNames.get(i).getText();
            String nextValue = lastNames.get(i+1).getText();
            Assert.assertTrue(value.compareTo(nextValue)<=0);
        }

    }
    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(5);
        driver.quit();
    }

}
