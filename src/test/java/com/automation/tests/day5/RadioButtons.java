package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for(WebElement radioButton : radioButtons) {
// <input type="radio" id="blue" name="color" checked="">  got this from the page. It shows attributes inside.
            String id = radioButton.getAttribute("id");
            //sometimes some radiobuttons are already clicked. In that case
            //we don't want to click again-it is unneccassry.
            //return true if button already clicked --> .isSelected();
            boolean isSelected = radioButton.isSelected();
            System.out.println(id+" is selected ? " + isSelected);
            //to check if radioButton is click able.
            //returns true if you can click the button
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("clicked on :: "+ id);
                BrowserUtils.wait(1);
            }else{
                System.out.println("Is not enabled did not click "+ id);
            }
            System.out.println();
        }
        driver.quit();
    }
}
