package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(5);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
       // checkBoxes.get(0).click(); //click on the first box.
      //  BrowserUtils.wait(2);

        for(int i = 0; i<checkBoxes.size(); i++){

            if(checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() &&
                    (!checkBoxes.get(i).isSelected())){
                //if checkBox is not selected, don't click
                checkBoxes.get(i).click(); //click on second checkbox
                BrowserUtils.wait(2);
            } else{
                System.out.println(i+1+" check box was not clicked");
            }
        }


        BrowserUtils.wait(3);
        driver.quit();

    }
}
