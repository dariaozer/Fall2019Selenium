package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex_P5 {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click();
        Select stateSelect = new Select(driver.findElement(By.id("state")));

        stateSelect.selectByIndex(9); //District of Columbia //index starts from 0.
        BrowserUtils.wait(3);

        //select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);




        BrowserUtils.wait(3);
        driver.quit();

//        List<WebElement> stateLst = selectState.getOptions();
//        int count = 0;
//        for (WebElement eachState: stateLst) {
//            count++;
//            System.out.println( count + " = " +eachState.getText());

    }
}
