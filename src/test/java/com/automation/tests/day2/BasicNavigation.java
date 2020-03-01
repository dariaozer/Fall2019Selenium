package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args)  throws Exception{
        // to start selenium script we need :
        //set-up web driver(browser driver) and create web-driver object.

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
       // RemoteWebDriver driver = new ChromeDriver();

        //In selenium everything starts from WebDriver Interface
        //ChromeDriver is a class. We have to import WebDriverManager and ChromeDriver
        //Since, selenium developers does not know logic and logic will not be same for all browsers,
        // they created WebDriver as an interface.
        // Interface is a type in Java which has only abstract method i.e methods without body/logic.
        // RemoteWebDriver class implements WebDriver interface which is extended by Browser drivers”
        //ChromeDriver extends RemoteWebDriver

        driver.get("http://google.com"); //to open the website. We always start with get method.
        Thread.sleep(3000); //  we did this for demo, wait 3 seconds
        //method that returns page title
        //you can also see it as tab name in browser
        String title = driver.getTitle(); // returns <title> some title </title> text
        String expectedTitle ="Google";
        System.out.println("Title is ..... "+ title);
        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED ! ");
        }else{
            System.out.println("TEST FAILED !");
        }

        driver.close(); //to close the browser
        //browser cannot close itself--> we need to call .close(); method.
    }
}
