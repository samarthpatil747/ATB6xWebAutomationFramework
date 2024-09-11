package com.testingacademy.pages.pageObjectModel;
import com.testingacademy.driver.DriverManagerTL;
import com.testingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import com.testingacademy.base.CommonToAllPage;

public class LoginPage_Super extends CommonToAllPage {
    public LoginPage_Super(){
        super();
    }

    // Page Locators
    By username = By.id("login-username");
    By password = By.id("login-password");
    By signButton = By.id("js-login-btn");
    By error_message = By.id("js-notification-box-msg");

    // Page Actions

    public LoginPage_Super loginToVWOPositive() throws Exception {
        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password,PropertyReader.readKey("password"));
        clickElement(signButton);
        //DriverManager.getDriver().findElement(password).click();
        // Pass the control the DashboardPage
        return this;
    }

    public LoginPage_Super openURL(String url){
        DriverManagerTL.getDriver().get(url);
        return this;
    }

    public String loginToVWONegative() throws Exception {
        enterInput(username, "admin");
        enterInput(password,PropertyReader.readKey("password"));
        clickElement(signButton);
        // error String
        visibilityOfElement(error_message);
        return getElement(error_message).getText();

    }

    public Dashboard_POM afterLogin(){
        return  new Dashboard_POM();
    }
}
