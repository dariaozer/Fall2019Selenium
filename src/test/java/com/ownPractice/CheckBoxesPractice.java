package com.ownPractice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesPractice {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)")).click();
        BrowserUtils.wait(3);
        driver.navigate().refresh();
        //when we work with check boxes, we should check if it is already dselected or not.
        //if it is selected an we click on it it will be unselected.

        //2nd way findelements and put them into List of web elements.

        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        for(WebElement checkbox : checkboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
                BrowserUtils.wait(5);
            }
        }
        driver.navigate().refresh();

        //3rd way finding webelements with

    }
}
