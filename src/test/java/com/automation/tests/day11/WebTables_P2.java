package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables_P2 {
    private WebDriver driver;
////table[@id="table1"]//tbody//td[3]
    //when we put two // means--> go to any tab named tbody that is under table
    //*[@id="table1"]//tbody//td  ==>> gives all cells
   // but if you specify row   ==>> //*[@id="table1"]//tbody//tr[3]//td  : it goes that exact data
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @Test
    public  void getColumnNames(){
        //th represents table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for(WebElement columnName : columnNames){
            System.out.println(columnName.getText());
        }
    }


    @AfterMethod
    public void teardown () {
        BrowserUtils.wait(2);
        driver.quit();
    }

}
