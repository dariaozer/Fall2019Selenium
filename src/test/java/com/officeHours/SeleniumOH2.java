package com.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    public static void main(String[] args) {
        /*
        1.Go to http:// automationpractice.com
        2.search for"tshirt" in a searchbox + click enter or click search button.
        3.valiadte you got no results message on UI
        4.search for "t-shirt"
        5.validate there was 1 result found.
         */

        //in oderder to navigate any web we need to set up webdrive

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        //now, create a wenb element
        WebElement search_box = driver.findElement(By.id("search_query_top"));
        //WebElement -- class
        //.sendKeys("value that we want to send -input tag")
        search_box.sendKeys("tshirt" + Keys.ENTER); // KEYS --enum
        //above statement we can also use comma instead of + both works.

        /*
        <p class="alert alert-warning">
					No results were found for your search&nbsp;"tshirt"
			</p>
         */

       // WebElement error = driver.findElement(By.className("alert alert-warning")); //we just created our element
        WebElement error = driver.findElement(By.className("xpath = //p[@class=‘alert alert-warning’]"));
        //but we did not take any action with it. Belwo taking actions
        String errorText = error.getText();
        //.getText() --> returns String (text) from the element
        System.out.println("Error message : "+ errorText);
// NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":".alert\ alert\-warning"}
      //  WebElement error = driver.findElement(By.className("alert alert-warning")); this first one threw NoSuchElementException,
        //so we used xpath instead. and it worked.
        search_box = driver.findElement(By.id("search_query_top"));
        search_box.clear(); // to clear what is typed in the search box on the web-site
        search_box.sendKeys("t-shirt" + Keys.ENTER);
        //StaleElementException --> means element is old/stale --- we want to find
        //this element again OR sometimes refresh page works too.

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
