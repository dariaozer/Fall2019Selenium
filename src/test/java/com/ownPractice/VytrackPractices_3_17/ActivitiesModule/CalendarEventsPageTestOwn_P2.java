package com.ownPractice.VytrackPractices_3_17.ActivitiesModule;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalendarEventsPageTestOwn_P2 {
    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */

    private By usernameBy =By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private String storeManagerUserName="storemanager55";
    private String storeManagerPassword="UserUser123";
    private Actions actions;
    private By activitiesBy = By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]");
    private By createCalendarEventBtnBy =By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu>a");
    private By ownerNameBy = By.cssSelector("#s2id_oro_calendar_event_form_calendar");
    private By titleBy = By.cssSelector("[id*='oro_calendar_event_form_title-uid']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");


    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(5);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);
    }


    @Test
    public void verifyCalendarEventsBtn (){
WebElement createCalendarEventBtn = driver.findElement(createCalendarEventBtnBy);
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());
        BrowserUtils.wait(2);
    }
    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */
    @Test(description = "Default Options")
    public void verifyDefaultValues(){
        //click on Create Calender Event
        driver.findElement(createCalendarEventBtnBy).click();
        BrowserUtils.wait(3);

        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName = driver.findElement(ownerNameBy).getText().trim();
        Assert.assertEquals(currentUserName,defaultOwnerName);

        BrowserUtils.wait(3);
       // driver.findElement(titleBy).getAttribute("value").isEmpty();
        Assert.assertTrue(driver.findElement(titleBy).getAttribute("value").isEmpty());

        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate =driver.findElement(startDateBy).getAttribute("value");
        Assert.assertEquals(actualDate, expectedDate);
        BrowserUtils.wait(3);

        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:mm a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");
        Assert.assertEquals(actualTime, expectedTime);


    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
