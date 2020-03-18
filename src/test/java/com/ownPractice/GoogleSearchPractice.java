package com.ownPractice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Java Books", Keys.ENTER);
        BrowserUtils.wait(3);
        driver.navigate().back();

        //used basic xpath syntax --> //tagName[@attribute='value']
        driver.findElement(By.xpath("//input[@maxlength='2048']")).sendKeys("Selenium Books", Keys.ENTER);
        //text() syntax of xpath--> //tagName[text()='visble text'] it doesn;t have text. so, didn't use.
        BrowserUtils.wait(3);
        driver.navigate().back();
        //contains xpath--> //tagName[contains(@attributeName, 'attrbValue')]
        driver.findElement(By.xpath("//input[contains(@spellcheck,'false')]")).sendKeys("JavaScript Books", Keys.ENTER);

        BrowserUtils.wait(3);
        driver.get("https://www.twitch.tv/boxelder");
    }
}
