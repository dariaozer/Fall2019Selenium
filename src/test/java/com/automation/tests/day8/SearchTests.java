package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    @Test
    public void googleSearchTest(){
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for(WebElement searchItem : searchItems){
            String var = searchItem.getText();
            //if there is a text print it
            if(!var.isEmpty()){
                System.out.println(var);
                //verify that every search result contains java
                //is some of search results doesn't contain java word, it will fail the test
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }

        }
    }

    /*
     * Given user is on amazon.com page
     * when user enters "java' as a search item
     * //then user clicks on the search button
     * clicks on the first search item
     * verifies that title of the search item contains "java"
     */
    @Test(description = "Search for java book on Amazon")
    public void amazonSearchTest(){
        driver.get("https://www.amazon.com");
        //there is a chance that item is not visible
        //so we need to maximize window before clicking it
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(3);

        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));

        //click on first item
        for(WebElement searchItem : searchItems){
            System.out.println("Title : "+ searchItem.getText());
        }
        searchItems.get(0).click();
        BrowserUtils.wait(2);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString  = productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));
    }






    private WebDriver driver;
    @BeforeMethod
    //set up web driver
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    //close up and destroy web-driver object
    public void tearDown(){
        driver.quit();
    }
}
