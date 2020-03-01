package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        //set up chrome driver
        WebDriverManager.chromedriver().setup();
        //create chrome driver object
        ChromeDriver driver = new ChromeDriver();
        //open website
        driver.get("http://google.com");
    }
}
