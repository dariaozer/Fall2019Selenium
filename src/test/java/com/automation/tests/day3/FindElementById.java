package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        //let's click on log out button. It looks like a button, but actually
        //it's a link
        //every element with<a> is a link

        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        String href = logout.getAttribute("href");
        System.out.println(href);
        String className = logout.getAttribute("class");
        System.out.println(className);
        logout.click();
        Thread.sleep(2000);
        //if you have couple spaces in the text, just use partialLinkText instead of LinkText
        //LinkedText--equals()
        //partialLinkText -- is like contains() method. // complete match is not required
        //partialLinkText is good for long links , or sometimes, links are continusly changing
        //in each update --so we use partialLink to find the element, by using a part that is not changing.


//let's enter invalid creadentials
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        System.out.println(errorMessage.getText());



       Thread.sleep(2000);
        driver.quit();

    }
}
