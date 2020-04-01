package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
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
//        WebDriverManager.chromedriver().version("79").setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        //headless mode makes execution twice faster
//        //it does everything except file uploading
//        //set it to tru to make it work
//        chromeOptions.setHeadless(true);//to run browser without GUI. Makes browser invisible.
//        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void getColumnNames() {
        //th represents table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
        }

        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
    }

    @Test
    public void verifyRowCount() {
        //    //tbody//tr-->to find all row from table body, excluding header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get a size of this collection, it automatically equals to number of elements
        Assert.assertEquals(rows.size(), 4);
    }

    /**
     * To get specific column, skip row index, just provide td index
     */
    @Test
    public void getSspecificColumn() {
        //td[5] -- column with links
        //if we want td table data for all columns with the same info
        //we don't provide index for tbody, we provide index only for td.
        //then it will give all td in tbody
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }

    /**
     * //table[1]//td[text()='jdoe@hotmail.com']/..//td[6]//a[1]
     * /** TASK until 4:45
     * * Go to tables example page
     * * Delete record with jsmith@gmail.com email
     * * verify that number of rows is equals to 3
     * * verify that jsmith@gmail.com doesn't exists any more in the table
     */


    @Test
    public void deleteRowBasedOnEmail() {
        //below locator was not correct--couldn't find
        WebElement deletebtn = driver.findElement(By.xpath("//table[1]//td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']"));
        deletebtn.click();
        // driver.findElement(By.xpath("table[1]//td[text()='jdoe@hotmail.com']/..//td[6]//a[1]")).click();
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
        Assert.assertEquals(rowCount, 3);

        // Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());
        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));

        Assert.assertTrue(emails.isEmpty());

        //what is “/a” when we use following-sibling? --> the one which has tag a.


    }

    @Test
    public void deleteAction() {
        WebElement delete = driver.findElement(By.xpath("//table[1]//td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']"));
        delete.click();
        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//tbody//tr//td[3]"));
        for (WebElement email : emails) {
            Assert.assertNotEquals(email, "jdoe@hotmail.com");
        }
//        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
//        Assert.assertEquals(rows.size(),3);
    }

    @Test
    public void getColumnIndexByName() {
        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        int index =0;
        for (int i = 0; i < columnNames.size(); i++) {
            String actualColumnName = columnNames.get(i).getText();
            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i));
            if (actualColumnName.equals(columnName)) {
                index = i + 1;
                break;
            }
        }
        Assert.assertEquals(index, 3);

    }

    @Test
    public void getSpecificCell(){
        String expected = "http://www.jdoe.com";
        int row =1;
        int column=1;
        String xpath = "//table[1]//tbody//tr["+row+ "]//td["+column+"]";
        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(), expected);

    }


    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(5);
        driver.quit();
    }

}
//first way :
//once you find email cell in the first table that has this email (jdoe@hotmail.com) then go to following sibling has linkText delete :
//td element with email and td element that contains delete => are siblings
////td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']
//to make it easier :
//go back to parent and find link that has text delete
//td is child of tr
////td[text()='fbach@yahoo.com']/..//a[text()='delete']
//even more simple way :
//it is more hardcoded! but easiest => you provide index so it s not flexible, if index is change ilocator will never find it
//go to find email in the first table go to parent go to second link inside this element
////table[1]//td[text()='jsmith@gmail.com']/..//a[2]