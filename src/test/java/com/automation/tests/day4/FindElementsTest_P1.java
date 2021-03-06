package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest_P1 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
        //how to collect all links from the page?
        //in html all links are tags a.
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();

        }
        for (int i = 1; i < links.size(); i++) {//here we are skipping HOME link. because it is useless, each time it takes us there
            //and we loose the list. To prevent this we opened fori and started with 1 to skip 0.
            links.get(i).click();
            // Thread.sleep(2000);
            driver.navigate().back();
            //refresh page
            links = driver.findElements(By.tagName("a")); // to refreah we assigned it to links otherwise it doesn't work.

        }
        driver.quit();
    }
}
