package com.automation.tests.vytrack.activities;

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

public class CalendarEventsPageTest_P2 {
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
   // private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]'");
    private  By titleBy = By.name("oro_calendar_event_form[title]"); //check if this works, too
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");

    private By endDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_end-uid-5e716c4def28e']");
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
    public void verifyCalendarEventButton(){
        WebElement createCalenderEventElmnt = driver.findElement(createCalendarEventBtnBy);
        Assert.assertTrue(createCalenderEventElmnt.isDisplayed());
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
 //default title should be blank
    WebElement titleElement = driver.findElement(titleBy);
    Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
    //time syntax : https://www.journaldev.com/17899/java-simpledateformat-java-date-format
    //default start date should be current date
    String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, YYYY")); //2 MM for number 3MMM for letters month
    String actualDate = driver.findElement(startDateBy).getAttribute("value"); //input text does not have text it has value
    //thats why we used getAttribute("value);
    Assert.assertEquals(actualDate, expectedDate);

    String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:mm a"));
    String actualTime= driver.findElement(startTimeBy).getAttribute("value");
    Assert.assertEquals(expectedTime, actualTime);
}


    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
