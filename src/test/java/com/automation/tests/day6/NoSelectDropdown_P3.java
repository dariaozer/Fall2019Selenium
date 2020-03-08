package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NoSelectDropdown_P3 {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click(); //to expand dropdown so that we can see what's inside the box
       // BrowserUtils.wait(2);
       // driver.findElement(By.linkText("Amazon")).click(); //to click on Amazon
        //BrowserUtils.wait(1);
        driver.findElement(By.linkText("Google")).click();
        BrowserUtils.wait(3);
        driver.quit();
    }
}

