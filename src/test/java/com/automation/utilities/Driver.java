package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    //same for everyone.
    private static WebDriver driver;

    //constructor is private so no one can create an object of Driver class
    //everyone should call static getter method instead
    private Driver(){

    }
    //static because we want to be able to call it
    public static WebDriver getDriver(){
       //if webdriver object does not exist create it
        if(driver==null){
            //specify browser type in Configuration.properties
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case"chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");

            }
        }


        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
