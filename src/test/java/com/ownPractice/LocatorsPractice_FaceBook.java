package com.ownPractice;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorsPractice_FaceBook {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.facebook.com/"); //Opened url in the browser
        //I want to enter email id in the edit box.
        driver.findElement(By.id("email")).sendKeys("Hellojava@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("password");
       // driver.findElement(By.id("u_0_2")).click(); submit button had id but it was alpha numeric
        //alpha numeric ids might vary each time the page is refreshed.
        //in this case alpha numeric ids are not reliable.
        //ex: the first time submit button id was u_0_2, after refresh it became u_0_4, then became u_0_b"

        driver.findElement(By.linkText("Forgot account?")).click();



        //Task2:

        driver.get("https://login.salesforce.com/");
//        /**
//         * when we have a class value with spaces, Selenium does not accept it.
//         * for ex: the className for user name box on salesforce was as below
//         * When I find it by classname which had spaces,
//         * it threw NoSuchElementException:
//         * Compund classes cannot be excepted
//         * class values should NOT have spaces--> if there are spaces cannot be used to find element.
//         * class with spaces can be used as helper in xpath.
//         */
      //  driver.findElement(By.className("input r4 wide mb16 mt8 username cc_cursor")).sendKeys("javaJava");

        //belwo is the html for the username box on salesforce website.
        // classname did not work bec. it had spaces.
        // <input class="input r4 wide mb16 mt8 username cc_cursor" type="email" value=""
        // name="username" id="username" aria-describedby="error" style="display: block;">

        //find by name worked.
       // driver.findElement(By.name("username")).sendKeys("JavaJava"); //worked
        //id also worked.
        driver.findElement(By.id("username")).sendKeys("Hello");
        driver.findElement(By.name("pw")).sendKeys("12345"); //entering password in password box
        //driver.findElement(By.id("Login")).click(); ---> By.id
        driver.findElement(By.xpath("//*[@id='Login']")).click();
        //I did not have valid credentials so I should get:
        String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
       String actual = driver.findElement(By.id("error")).getText();
       if(actual.equals(expected)){
           System.out.println("Test Passed");
       }else{
           System.out.println("test failed!");
       }

        System.out.println("*****************************************************************************************");
        //if there are more than one element with the same attribute such as  classname, tagname, name  etc..
        //selenium finds the first one. because, it scans from top left to bottom
        //once it finds it, it enters there doesn't bother to scan the rest.

       //FaceBook page:
        //email box html
        //<input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="royal_email">
        //password box html
       //<input type="password" class="inputtext login_form_input_box" name="pass" id="pass" data-testid="royal_pass">

        //both have the same class name.-->inputtext


    }
}
