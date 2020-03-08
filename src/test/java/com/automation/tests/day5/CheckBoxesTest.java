package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(3);
        //TASK:
        //verify that 1st checkbox is not selected and the 2nd one is selected.
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("Test passed");

        }else{
            System.out.println("Test failed");
        }
        BrowserUtils.wait(2);
        driver.quit();
    }
}
