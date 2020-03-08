package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText_P1 {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //create a webelement object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //provide weblement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        //and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");

        //
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("2003");
        selectMonth.selectByVisibleText("January");
        selectDay.selectByVisibleText("25");


        //select all months one by one.
        //.getOptions(); returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for(WebElement eachMonth : months){
            selectMonth.selectByVisibleText(eachMonth.getText());
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(4);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District Of Columbia");
        //option that currently sselected.
        //getFirstSelectedOption() -- returns webElement that's why we call getText();
        //getText(); retrieves visible text from the web Element

        String selected = stateSelect.getFirstSelectedOption().getText();
        if(selected.equals("District Of Columbia")){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed!");
        }

        List<WebElement> states = stateSelect.getOptions();
        for(WebElement stateOption : states){
            System.out.println(stateOption.getText());
        }
        BrowserUtils.wait(3);
        driver.quit();
    }
}
