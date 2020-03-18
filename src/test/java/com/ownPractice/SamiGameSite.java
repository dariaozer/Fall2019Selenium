package com.ownPractice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SamiGameSite {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.twitch.tv/boxelder");
        BrowserUtils.wait(10);
        //driver.findElement(By.className("tw-flex-grow-0")).click();
      driver.findElement(By.xpath("//div[text()='Log In']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@aria-label='Enter your username']")).sendKeys("JaneAusten");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("littlewomen123");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[@data-a-target='passport-login-button']")).click();
    }
}
