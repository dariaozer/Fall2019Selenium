package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception {
        /*
1. Get google.com
2. When text box visible,
save as web element.
2.Send text into text box.
3.When button clickable,
save as web element
4.Click on button object
5. Find element for
search box and get text
from it

 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        //By.name("q") --> name="q"
        //name-- it's one of the selenium locators
        //There are 8 selenium locators
        WebElement search = driver.findElement(By.name("q"));
        //once we found an element, how to enter text?
        //to enter text, use sendKeys() method
        //how to press Enter after entering the text?
        //use Keys.ENTER --> perform keyboard click
        //keysTosend--> name of the parameter, we don't specify it.

        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);
        //2000 -- 2 secs
        //12000-- 12 secs

        WebElement news = driver.findElement(By.linkText("News"));
         news.click();
         Thread.sleep(4000);
        driver.quit();
    }
}
