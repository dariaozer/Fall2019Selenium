package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders_P4 {
    private WebDriver driver;
    private WebDriver wait;

    @BeforeMethod
    public void setUp(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

    }

    /**
     * 7 minutes until 5:21
     * Go to web orders page
     * Click on "Check All" button
     * Verify that all records are selected
     */
    @Test
    public void checkBoxTest(){
 driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
 BrowserUtils.wait(2);
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for(WebElement checkBox : checkBoxes){
            Assert.assertTrue(checkBox.isSelected());
        }

    }
    /**
     * :: TASK for 10 minutes ::
     * Go to web orders page
     * Verify that Steve Johns zip code is 21233
     * Then update his zip code to 20002
     * Then verify that Steve Johns zip code is 20002
     */
    @Test
    public void updateZipCode(){
  String actual = driver.findElement(By.xpath("//table/tbody/tr[4]/td[9]")).getText();
  String expected = "21233";
  Assert.assertEquals(actual, expected);

        //click on update image

        driver.findElement(By.xpath(" //td[text()='Steve Johns']//following-sibling::td/input")).click();

        WebElement zipcodeInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        zipcodeInput.clear();
        zipcodeInput.sendKeys("20002");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

       WebElement zipcode = driver.findElement(By.xpath("//table/tbody/tr[4]/td[9]"));
       // WebElement zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        Assert.assertEquals(zipcode.getText(), "20002");
    }




    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
