package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //PageFactory is the enhancement for Page Object
    @FindBy(id ="prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css="div[class='alert alert-error']")
    private WebElement warningMessage;



//constructor
    public LoginPage(){
        //to connect our WerbDriver, Page class, and PageFactory
        //PageFactory --used to use @FindBy annotations
        //PageFactory-- helps to find elements easier
        PageFactory.initElements(Driver.getDriver(), this);

        // We can also write above statement one as below---> this keyword refers to page that we are on.
        //We are on LoginPage.class so we can use either way: this keyword to refer the page we are on
        //or the class itself, which is LoginPage.class
       // PageFactory.initElements(Driver.getDriver(), LoginPage.class);

    }

    public String getWarningMessageText(){
        return warningMessage.getText();
    }

    /**
     * Method to login, version#1
     * @param usernameValue
     * @param passwordValue
     */

    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.wait(3);
    }

    /**
     * Method login, version#2
     * login as a default user---which is store manager
     * Credentials will be retrieved from configuration.properties
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }
}
