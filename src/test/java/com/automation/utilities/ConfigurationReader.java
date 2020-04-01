package com.automation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    //ConfigurationReader Class responsible for loading properties file and
    // providing access to values based on passed key names.
    //static block will be executed once, whenever ConfigurationReader class is called.
    //static block has the highest execution order 1. static block, 2. instance block 3. constructor
     //we use the below Properties class to load our custom .properties file.
    private static Properties configFile;
    static {
        try {
            //location of properties file
            String path = System.getProperty("user.dir")+"/configuration.properties";
            //get that file as a stream.//FileInputStream class obj. provides access to
            // the file that we pass the path of it.
            FileInputStream input = new FileInputStream(path);
            //create object of Properties class
            configFile = new Properties();
            //load properties file into Properties object
            configFile.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }
    /**
     * This method returns property value from configuration
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }


}
