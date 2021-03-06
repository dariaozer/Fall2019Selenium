package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue_P4 {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click();
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("DC");

        String expected = "District Of Columbia";

        String actual = stateSelect.getFirstSelectedOption().getText();
        if(expected.equals(actual)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }



        BrowserUtils.wait(3);
        driver.quit();
    }
}
