package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Alerts_P6 {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click(); // to click on the first button.
        BrowserUtils.wait(3);
        //to get the text from pop-up message
          String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);
        driver.switchTo().alert().accept(); // to click OK.
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();
        //because there is a typo on the web site it will fail.
        if(expected.equals(actual)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
            System.out.println("Expected " + expected);
            System.out.println("Actual "+ actual);
        }
        System.out.println("========TEST#2========================");
        BrowserUtils.wait(3);
        buttons.get(1).click();// to click on the second button
        BrowserUtils.wait(3);
        //to click cancel
        driver.switchTo().alert().dismiss();
        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();
        if(expected2.equals(actual2)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("expected2 = " + expected2);
            System.out.println("actual2 = " + actual2);
        }

        System.out.println("========TEST#3==================");
        //Task: click on button #3
        //Enter some text : Hello,World!
        //verify that result text ends with Hello, World!
        buttons.get(2).click();
        BrowserUtils.wait(1);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, World!");
        BrowserUtils.wait(5);
        alert.accept();
        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 ="Hello, World!";
        BrowserUtils.wait(1);
        if(expected3.equals(actual3)){
            System.out.println("Test Failed");
        }else{
            System.out.println("Test Failed");
            System.out.println("expected3 = " + expected3);
            System.out.println("actual3 = " + actual3);
        }



        BrowserUtils.wait(3);
        driver.quit();
    }
}
