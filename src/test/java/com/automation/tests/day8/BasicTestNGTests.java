package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
    //runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }

    //runs only once after @After
    @AfterTest
    public void afterTest(){
        System.out.println("AFTER TEST");
    }
   //RUNS ONLY ONCE BEFORE @BeforeMethod AND BEFORE ANY TEST
    //REGARDLESS OF NUMBER OF TEST, IT RUNS ONLY ONCE
    @BeforeClass
    public void beforeClass(){
        //Something that should be done in the class before all tests
        System.out.println("BEFORE CLASS--ONLY ONCE PER CLASS");
    }

    @AfterClass
    public void afterClass(){
        //Something that should be done in the class after all tests
        System.out.println("AFTER CLASS --ONLY ONCE PER CLASS");
    }

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
