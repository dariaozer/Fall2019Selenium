package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        //If we want to reach one specific element, for example black:
        //we will use id, bec.id is unique. Below is the input tag with the attributes inside it
//<input type="radio" id="black" name="color">
        WebElement blackButton = driver.findElement(By.id("black"));
        //in the below if statement--> we are checking if black button is exist and if it is enabled to be clicked.
        //if so, we will click other wise no logic to click something non-exists.
        //.isDisplayed()--> returns true, if element is visible. Applies to any kind of we element.
        //if element does not exist at all, we will get --> NoSuchElementException
        //This method will not work if element is not present in the HTML code
        //to verify if element is not in html code at all, use findElements().size() == 0;
        //driver.findElements
        if(blackButton.isDisplayed() && blackButton.isEnabled()){
            blackButton.click();
            BrowserUtils.wait(2);
            System.out.println("Clicked on black button");
        }else{
            System.out.println("Black button is either non-exist or disabled");
        }
           BrowserUtils.wait(2);
        //how do we verify if the black button was clicked or not?
        if(blackButton.isSelected()){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed:(");
        }
         BrowserUtils.wait(2);
        driver.quit();
    }
}
 //.isEnabled()
//.isSelected
//.isDisplayed ===> all these methods are applicable to all web elements, not only radio buttons.

/*
*PRIORITY:
* 1. Element must be present
* 2. Element must be visible
* 3. Element must be enabled
 */