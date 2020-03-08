package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Warm_Up {
    static WebDriver driver;

    public static void main(String[] args) {

        ebayTest();





        //Go to ebay
        //enter search term
        //click on search button
        //print number of results



        //go to amazon
        //Go to ebay
        //enter search term
        //click on search button
        //verify title contains search term
        //Go to wikipedia.org
        //enter search term `selenium webdriver`
        //click on search button
        //click on search result `Selenium (software)`
        //verify url ends with `Selenium_(software)`
    }


    public static void ebayTest(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);
        driver.quit();




    }
}

