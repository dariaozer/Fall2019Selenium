package com.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OH_3_19_20_CollectionsFrameworkRecap_Akbar {



    public static void main(String[] args) {
      WebDriver  driver = DriverFactory.createDriver("chrome");
     // driver.get("https://www.amazon.com/");
        driver.navigate().to("https://www.amazon.com/");
      driver.manage().window().maximize();
        BrowserUtils.wait(3);
        driver.findElement(By.id("twotabsearchtextbox"));
        BrowserUtils.wait(2);
    }
}
