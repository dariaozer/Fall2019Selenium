package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectByText_P1 {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //Create a WebElelment obj. for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //Provide WebElement obj. into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown); //passing the webElement into select constructor
        //Select by visible text.
        selectSimpleDropdown.deselectByVisibleText("option 2");

        BrowserUtils.wait(3);
        driver.quit();
    }
}
