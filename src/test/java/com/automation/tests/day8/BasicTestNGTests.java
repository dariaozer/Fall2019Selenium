package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTestNGTests {
    //runs before every test automatically
    //works as a pre-condition or set-up
    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
    }

   //runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
    }

    @Test
    public void test1(){
        System.out.println("TEST 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void  test2(){
        System.out.println("TEST 2");
        int num1= 15;
        int num2= 10;
        //it calls hard assertion
        //if assertion fails-- it sstops the execution (due to exception)
        Assert.assertTrue(num1>num2);
    }
}
