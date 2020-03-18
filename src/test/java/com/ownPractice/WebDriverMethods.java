package com.ownPractice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {
//WebDriver is an interface that defines a set of methods.
// However, implementation is provided by the browser specific classes.
// Some of the implementation classes are ChromeDriver, FireFoxDriver, EdgeDriver etc.
// The WebDriver main functionality is to control the browser.
//    if we want to execute the test cases in the Chrome browser we have to use ChromeDriver
//SearchContext is the topmost interface in Selenium API which has two methods
// – findElement() and findElements().

    //Selenium WebDriver interface has many abstract methods
    // like get(String url), quit(), close(),
    // getWindowHandle(), getWindowHandles(), getTitle() etc.
//WebDriver has nested interfaces like Window, Navigation, Timeouts etc.
// These nested interfaces are used to perform operations like back(), forward() etc.

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        BrowserUtils.wait(3);
        driver.navigate().to("https://www.amazon.com/");
        BrowserUtils.wait(3);
        driver.quit();
    }
}
