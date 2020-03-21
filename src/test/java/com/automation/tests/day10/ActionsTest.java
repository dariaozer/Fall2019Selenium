package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
    private WebDriver driver;
    private Actions actions; // declaring actions so that we can use anywhere on this page

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        actions = new Actions(driver); //creating actions obj by passing driver to Actions constructor



    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        //hovering over
        //build is needed when you have more than one actions to take
        //always end with perform.
        //below is called builder pattern--> we take 3 actions. We could also do them separately.
        //method after comes build returns instance--NOT void.
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();
        //hover on the first image
        //verify that"name: user1" is displayed.

        //(//h5)[1]
        //hover over img to make the text visible
        actions.moveToElement(img1).perform();
        WebElement img1Text = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that WebElement that contains the text is visble
        Assert.assertTrue(img1Text.isDisplayed());
        BrowserUtils.wait(3);

        WebElement img2Text = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        actions.moveToElement(img2).perform();
        Assert.assertTrue(img2Text.isDisplayed());
        BrowserUtils.wait(3);

        WebElement img3Text = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        actions.moveToElement(img3).perform();
        Assert.assertTrue(img3Text.isDisplayed());

    }

    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        //hover on "enabled
        //hover on downloads
        //click on pdf
        WebElement enabled = driver.findElement(By.linkText("Enabled"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));
        BrowserUtils.wait(2);
        actions.moveToElement(enabled).pause(1000).
                moveToElement(downloads).pause(1000).
                moveToElement(pdf).click().build().perform();
    }

    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);
        //click on accept cookies
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
        BrowserUtils.wait(5);
       WebElement bigCircle = driver.findElement(By.cssSelector("div[id='droptarget']"));
       WebElement smallCirlce =driver.findElement(By.cssSelector("div[id='draggable']"));
//        WebElement bigCircle = driver.findElement(By.id("droptarget"));
//        WebElement smallCirlce =driver.findElement(By.id("draggable"));
        actions.dragAndDrop(smallCirlce,bigCircle).perform();
        BrowserUtils.wait(6);
        String expected="You did great!";
        String actual =bigCircle.getText();

        BrowserUtils.wait(5);
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
//builder pattern => you put one method then you can take action
//builder pattern == chaining methods
//what is build?
//if you have multiple actions you have to put build
//to combine a couple of actions.
//build() is needed when you have couple of actions
//build combines the action; perform; starts the action
//in this example; first we move to one image then second so we used build
//always end with perform
//perform does not click, it starts the action, execute the event
//you can perform click, drag and drop etc
//actions class has different implementations
//moveToElement returns instance of action class that's why we can chain them