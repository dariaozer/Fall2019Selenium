package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTests_P4 {
    private WebDriver driver;

    @BeforeMethod
    public void setWebDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM
        //create ChromeOptions then use setAcceptInsecureCerts(true); method
        //then provide chromeOptions arg inside the constructor  driver = new ChromeDriver(chromeOptions);
        //ChromeOptions--> use custimze browser for test
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
    driver.get("http://practice.cybertekschool.com/");
    driver.manage().window().maximize();
    BrowserUtils.wait(2);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(2);
        driver.quit();
    }

    /**
     * We put @Test annotations to make methods executable tests
     */
    @Test
    public void logInTest(){
        //first I need to go Autontication page
        //I'll go there by lnk txt
        driver.findElement(By.linkText("Form Authentication")).click(); //need to find then click on it
        BrowserUtils.wait(2);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement((By.className("subheader"))).getText();
        //if assertion fails it will throw exception and message will be printed
// 3 params--> expected, actual, mesage in case error--> we put message to make debugging easier.
        //the message only will be shown if the test fails.
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");
    }

    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Forgot password" page
     * Then user enters his email
     * And clicks "Retrieve password" button
     * Then user verifies that message "Your e-mail's been sent!" is displayed
     */
    @Test
    public void forgotPassword(){
        driver.findElement(By.linkText("Forgot Password")).click();
         driver.findElement(By.name("email")).sendKeys("emaynell8f@google.es", Keys.ENTER);
        BrowserUtils.wait(3);
         String expected = "Your e-mail's been sent!";
         String actual = driver.findElement(By.name("confirmation_message")).getText();
         BrowserUtils.wait(3);
         Assert.assertEquals(actual,expected);
    }

    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Checkboxes" page
     * And clicks on checkbox #1
     * Then user verifies that checkbox #1 is selected
     */

    @Test
    public void checkBoxTest1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(4);
        //how to get first checkbox
        //we can get list of them and get the first one.
//        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
//        BrowserUtils.wait(3);
//        checkBoxes.get(0).click(); // to click on the first check box
//
//        Assert.assertTrue(checkBoxes.get(0).isSelected(), "Check box 1 is not selected");

        //2nd way-- using xpath

        //locator for specific check box -- xpath: //input[1]
        //when we put //input in the find bo-- it shows two results
        //then we write //input[1]--> we get the first checkbox. then we click on it.

        driver.findElement(By.xpath("//input[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[1]")).isSelected(), "check box 1 is selected");
    }
}

//####TASK for 10 minutes: until 4:17
//Create a class called PracticeTests
//- setup before/after methods
//	- in before method. instantiate webdriver and navigate to: http://practice.cybertekschool.com/
//	- in after method - just close webdriver.
//- create a test called lofinTest
//	- go to “Form Authentication” page
//	- enter valid credentials
//	- verify that following sub-header message is displayed: “Welcome to the Secure Area. When you are done click logout below.”

