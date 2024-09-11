package com.testingacademy.pages.pageObjectModel;

import com.testingacademy.base.CommonToAllPage;
import com.testingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class LoginPage_POM extends CommonToAllPage {

    private WebDriver driver;

      public LoginPage_POM(WebDriver driver) {
         this.driver = driver;
     }


   /* public LoginPage_POM() {
        super();
    }*/

    //Page Locators
    private By Username = By.id("login-username");
    private By Password = By.id("login-password");
    private By LoginButton = By.id("js-login-btn");
    private By err_msg = By.id("js-notification-box-msg");
    private By Dashboard =  By.xpath("//h1[contains(text(),'Dashboard')]");

    public void openURL() {
        try {
            driver.get(PropertyReader.readKey("qa_URL"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // Page Actions
    public String logintovalidCreds(String uid, String pwd) throws FileNotFoundException {
        openURL();
        driver.findElement(Username).sendKeys(uid);

        driver.findElement(Password).sendKeys(pwd);

        driver.findElement(LoginButton).click();
        //waitForElementToBeVisible(driver.findElement(Dashboard));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String msg = driver.findElement(Dashboard).getText();
        System.out.println(msg);
        return driver.findElement(Dashboard).getText();

    }

    public String logintoinvalidCreds() throws FileNotFoundException {
        openURL();
        enterInput(Username, PropertyReader.readKey("username"));
        enterInput(Password, PropertyReader.readKey("password"));
        clickElement(LoginButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String msg = driver.findElement(err_msg).getText();
        System.out.println(msg);
        return driver.findElement(err_msg).getText();

    }

}
