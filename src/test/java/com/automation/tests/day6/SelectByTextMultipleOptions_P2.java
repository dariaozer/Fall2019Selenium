package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByTextMultipleOptions_P2 {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple); // if it is true we can select multiple options at once
        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");



        BrowserUtils.wait(3);
        driver.quit();
    }
}
