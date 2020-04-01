package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties_P1 {


    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir")); //for path
        System.out.println(System.getProperty("os.name"));
        //flexiable path to download folder
        //System.out.println(System.getProperty("user.home"))+"/Downloads" --> helps to download from the computer
        System.out.println(System.getProperty("user.home"));
        //for windows use // instead of /
        String pathToDownloads = System.getProperty("user.home")+"/Downloads";
        System.out.println(pathToDownloads);
        System.out.println(System.getProperty("os.arch"));
        
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
    }
}
