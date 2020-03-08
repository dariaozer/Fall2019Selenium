package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        //every window has some id, this id calls window handle.
        //based on window handle, we can switch in between windows.

        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);  // output --CDwindow-FB4C5E21AC8528D5122DCABDD8DBB24B
        //this is like id. belongs to the particular window that was originally open

        Set<String> windowHandles = driver.getWindowHandles(); //will get ALL window handles.

        System.out.println(windowHandles); // returns ids of All currently open windows.
        System.out.println("BEFORE SWITCH : "+ driver.getCurrentUrl());
        //Since we have all windows
        //and we know the id of original window
        //we can say switch to something that is not equals to old window id.
        for(String windowId : windowHandles){
            if(!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("AFTER SWITCH : "+driver.getCurrentUrl());
        driver.close();
    }

    /**
     * This method helps to switch  between windows based on page title
     * @param pageTitle
     * @param driver
     */
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for(String window: windows){
            driver.switchTo().window(window);
            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}
               //Set checks hashcodes, if hashcodes are the same they are equal.
//Set does not allow duplicates :) remember