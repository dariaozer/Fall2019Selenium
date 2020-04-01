package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//Static import of all assertions --. this way we don't need to call class only method enough
import java.util.List;

import static org.testng.Assert.*;
//import org.testng.Assert;


public class LoginTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    //https is a secured version of http protocol
    //http - it's hypertext transfer protocol that every single website is using now days
    //https - data encrypted, no chance for hackers to retrieve info
    //http - data as a plain text, very easy to hack it

    private By usernameBy =By.id("prependedInput"); //By is a class--> when we find an element by using By.... methods
    //it returns By data type and we stored it in to By as above statement.
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.cssSelector("[class='alert alert-error']>div");
    //CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    @Test(description = "verify that warning message displayed when user enters invalid username")
    public void invalidUserName(){
      driver.findElement(usernameBy).sendKeys("invalidusername");
      driver.findElement(passwordBy).sendKeys("useruser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());
        BrowserUtils.wait(2);
        String expected="invalid username or password.";
        String actual = warningElement.getText();
        assertEquals(actual, expected);
        BrowserUtils.wait(3);

    }

    @Test(description = "login as store manager and verify that title equals to dashboard")
        public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);

        String expected = "Dashboard";
        String actual = driver.getTitle();
        assertEquals(actual, expected);
        }


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown(){
        //if webdriver obj alive
        if(driver!=null){
            //close browser, close session
            driver.quit();
            //destroy driver obj for sure by assigning to null
            driver = null;
        }
    }
}

