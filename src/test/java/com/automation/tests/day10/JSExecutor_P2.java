package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor_P2 {
   // private WebDriver driver;
    private RemoteWebDriver driver;
    //we changed the reference type from we bdriver to RemoteWebDriver

    @BeforeMethod
    public void setup(){
      //  driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();


    }

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
       // JavascriptExecutor js = (JavascriptExecutor) driver;
        // we need to cast JavascriptExecuter if our driver object reference type is WebDriver
        //Above we changed the reference type to RemoteWebDriver. Therefore, we don't have to cast.
        //RemoteWebDriver is class --> it implements WebDriver---->
        //if we use WebDriver
        //RemoteWebDriver is the parent of all types of driver classes.
        //RemoteWebDriver implements both, JavaScriptExecuter Interface and WebDriverInterface.
        //so when we use it as reference type we don't need to cast, as we can acsess all methods that it inherits from
        //JavaScriptExecuter and WebDriver.
        //scroll down 250 pixels
       // x,y
        for(int i=0; i<10;i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(3);
    }

    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(3);
        //scrollIntoview --javascript method
        //arguments[0] -- means 1st WebElement  after comma
        driver.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }


}
//how to use javaScriptExecutor?
//javaScriptExecutor; it is an interface we can not create object out of it.
//But javascript executor and webDriver are like siblings
//So we will cast driver to JavascriptExecutor
//we convert webDriver object into JavaScriptExecutor
//JavascriptExecutor js = (JavascriptExecutor) driver;
//interface => they don't have implementation
//if you have interface as reference type you can see methods only coming from that interface
//you can not see other methods that are in other interfaces
//so we will use remoteWebDriver class as reference type :
//if you use remoteWebDriver class as reference type you do not need to cast anymore, it has everything
//like this => private RemoteWebDriver driver;
//driver.executeScript("window.scrollBy(0, 250)");
//you need to cast if your reference type is webDriver; like this =>  private WebDriver driver;
//JavascriptExecutor js = (JavascriptExecutor) driver;
//JavaScriptExeuter---> Example of abstraction in selenium. It has methods, for example--> executeScript with no body
//implementation is provided in RemoteWebDriver class. If we use WebDriver as reference type than we need to cast.