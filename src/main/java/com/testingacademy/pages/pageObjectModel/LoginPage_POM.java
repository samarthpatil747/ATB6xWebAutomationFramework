package com.testingacademy.pages.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM {

    private WebDriver driver;


    public LoginPage_POM(WebDriver driver) {
        this.driver = driver;
    }
    //Page Locators
    private By Username = By.id("login-username");
    private By Password = By.id("login-password");
    private By LoginButton = By.id("js-login-btn");
    private By err_msg = By.id("js-notification-box-msg");
    private By Dashboard =  By.xpath("//h1[@class='page-heading'][contains(text(),'Dashboard')]");

    // Page Actions
    public String logintoinvalidCreds(String uid, String pwd) {
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(Username).sendKeys(uid);
        driver.findElement(Password).sendKeys(pwd);

        driver.findElement(LoginButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String msg = driver.findElement(err_msg).getText();
        System.out.println(msg);
        return driver.findElement(err_msg).getText();
    }

    public String logintovalidCreds(String uid, String pwd) {
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(Username).sendKeys(uid);
        driver.findElement(Password).sendKeys(pwd);

        driver.findElement(LoginButton).click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String msg = driver.findElement(Dashboard).getText();
        System.out.println(msg);
        return driver.findElement(Dashboard).getText();
    }

}
