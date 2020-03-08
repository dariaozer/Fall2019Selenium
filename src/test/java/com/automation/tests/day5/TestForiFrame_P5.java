package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame_P5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);
        //before looking for that element,
        //we need to jump to that frame.
        //you can specify : name, id, index , or WebElement of that frame
        //it's like we are jumping to another layer
        driver.switchTo().frame("mce_0_ifr");
//now, this content will be visible
        WebElement textInput = driver.findElement(By.id("tinymce"));
        System.out.println(textInput.getText());
        BrowserUtils.wait(4);
        textInput.clear(); // we delete the original text -- so that we can add our own
        textInput.sendKeys("Hello World :) "); //adding our own text
        BrowserUtils.wait(4);
   driver.switchTo().defaultContent(); // exit from the frame and go back to default
         WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println("Heading : "+heading.getText());
        BrowserUtils.wait(3);
        driver.quit();
    }
}
