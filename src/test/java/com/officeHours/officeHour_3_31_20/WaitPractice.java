package com.officeHours.officeHour_3_31_20;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class WaitPractice extends AbstractTestBase {
    /*
    http://qa3.vytrack.com
     */
    /*
    Implicit wait-- set it one time and it will work for every findElement method.
                -NoSuchElementException

    Thread.sleep -- not selenium wait. Thread --> java class, sleep() method of Thread class
                 -stops the execution of java program
                 -we never want to use this methods for our tests because it stops the execution of our program.

     Explicit wait- we have to declare every time before the iteration with element
    */

    @Test
    public  void testWait(){
LoginPage loginPage = new LoginPage();
loginPage.login("salesmanager110", "UserUser123");

    }
}
