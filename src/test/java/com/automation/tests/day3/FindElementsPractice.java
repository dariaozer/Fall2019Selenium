package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws Exception{
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        //instead of writing above code each time to set my driver, I created a class
        //and wrote createDriver method. Below, I am calling createDriver ()
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(("sdeat@cybertek.com"));
        Thread.sleep(2000);

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        //when you see type ="submit", you can use submit() instead of click()
        //it makes sense to use when click method doesn't work.
        //signUp.click();
        signUp.submit();
        Thread.sleep(2000);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement message = driver.findElement(By.className("subheader"));
        String actual = message.getText(); // getText returns anything between opening and closing tags is a visible text.
        if(expected.equals(actual)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        driver.quit(); //to close everything.
    }
}
