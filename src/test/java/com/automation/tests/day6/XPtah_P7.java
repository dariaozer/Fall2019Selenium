package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPtah_P7 {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);

        //value can be inside " or '
        //if you don't know the tag name, or want to skip tag name, use *
        //for example: //*[@onclick='button1()']      -->* means any tag name
        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();
        //we clicked on btn 1 -- now we will get the text

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

        System.out.println("=======BUTTON 2=============");
        //click on button 2
        WebElement btn2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
       // WebElement btn2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        btn2.click();
        System.out.println(result.getText());
        System.out.println("=======BUTTON 3=======");
        WebElement btn3 = driver.findElement(By.xpath("button[starts-with(@id,'button_')]"));
        btn3.click();
        System.out.println(result.getText());
        System.out.println("==========BUTTON 4===========");
        WebElement btn4 = driver.findElement(By.xpath("//button[contains(@id,_button)][1]"));
        btn4.click();
        System.out.println(result.getText());
        System.out.println("=========BUTTON 5================");
        WebElement btn5 = driver.findElement(By.xpath("button[contains]"));
        btn5.click();
        System.out.println(result.getText());



        BrowserUtils.wait(3);
        driver.quit();
    }
}
