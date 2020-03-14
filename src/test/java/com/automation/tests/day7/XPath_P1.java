package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPath_P1 {

    static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    static String passwordLocator ="//label[text()='Password']/following-sibling::input";
    static String loginBtnLocator ="//button[contains(text(), 'Login')]";
    //  //button[@type='submit' or @id='wooden_spoon'] --> another way to loacte login button
    //  //button[@type='submit' and @id='wooden_spoon']
    //instead of using locators down, we cretaed static variables of them
    //in this case, we are able to use them as much as we need, in case we need to use them more then one.
    //we will not keep on writing the full instead, we will use the variable name.
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();

        BrowserUtils.wait(3);
        driver.quit();

    }
}
