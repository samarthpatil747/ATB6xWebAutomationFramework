package com.testingacademy.pages.pageFactory;

import com.testingacademy.base.CommonToAllPage;
import com.testingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class LoginPage_PF_Base extends CommonToAllPage {
    private WebDriver driver;

    public LoginPage_PF_Base(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    // Page Locators
    @FindBy(id = "login-username")
    private WebElement username;
    @FindBy(id = "login-password")
    private WebElement password;
    @FindBy(id = "js-login-btn")
    private WebElement loginButton;
    @FindBy(id = "js-notification-box-msg")
    private WebElement err_msg;
    @FindBy(xpath = "//h1[@class='page-heading'][contains(text(),'Dashboard')]")
    private WebElement dashboard;

    // Page Actions
    public String invalidloginToVWO() {
        try {
            enterInput(username, PropertyReader.readKey("invalid_username"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            enterInput(password,PropertyReader.readKey("invalid_password"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        clickElement(loginButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return err_msg.getText();
    }
    public String validloginToVWO() {
        try {
            enterInput(username,PropertyReader.readKey("username"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            enterInput(password,PropertyReader.readKey("password"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        clickElement(loginButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return dashboard.getText();
    }

    }
