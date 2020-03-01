package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args)  throws Exception{
        // to start selenium script we need :
        //set-up web driver(browser driver) and create web-driver object.

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

       // RemoteWebDriver driver = new ChromeDriver();
       // RemoteWebDriver driver2 = new SafariDriver();
       // RemoteWebDriver driver3 = new InternetExplorerDriver();

        //In selenium everything starts from WebDriver Interface
        //ChromeDriver is a class. We have to import WebDriverManager and ChromeDriver
        //Since, selenium developers does not know logic and logic will not be same for all browsers,
        // they created WebDriver as an interface.
        // Interface is a type in Java which has only abstract method i.e methods without body/logic.
        // RemoteWebDriver class implements WebDriver interface which is extended by Browser drivers”
        //ChromeDriver extends RemoteWebDriver

        driver.get("http://google.com"); //to open the website. We always start with get method.
        //driver.manage().window().maximize(); // to maximize the browser
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
        driver.navigate().to("https://amazon.com/"); // to navigate to another website
        Thread.sleep(3000);
        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test Passed---> Connecting to Amazon");
        }else {
            System.out.println("Test failed--> No Amazon Connection");
        }

        driver.navigate().back(); //To navigate back
        Thread.sleep(3000);
        verifyEquals(driver.getTitle(), "Google");

        //move forward in the browser history
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //to get tittle we use getTitle(); --> it returns A String

        //to get URL
        System.out.println("URL : "+ driver.getCurrentUrl()); // getCurrentUrl returns string

        driver.navigate().refresh(); // to reload page
        Thread.sleep(3000); //for demo wait 3 secs.


        driver.close(); //to close the browser
        //browser cannot close itself--> we need to call .close(); method.


    }

    public static void verifyEquals (String arg1, String arg2){
          if(arg1.equals(arg2)){
              System.out.println("Test passed");
          }else{
              System.out.println("test failed");
          }
    }
}
