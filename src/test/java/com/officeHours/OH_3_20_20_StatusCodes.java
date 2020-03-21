package com.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class OH_3_20_20_StatusCodes {
/**
 * //Test Case #12
 *         /*
 *         Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
 *         Step 2. And click on “Status Codes”.
 *         Step 3. Then click on “500”.
 *         Step 4. Verify that following message is displayed: “This page returned a 500 status code”
 *          */
public static void main(String[] args) {
    WebDriver driver = DriverFactory.createDriver("chrome");
    driver.get("https://practice-cybertekschool.herokuapp.com");
    BrowserUtils.wait(3);

}


}
