package com.testingacademy.pages.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {
    private WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
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
    public void enterUsername(String uid) {
        username.sendKeys(uid);
    }
    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public String getErrorMessage() {
        return err_msg.getText();
    }
    public String getDashboardText() {
        return dashboard.getText();
    }
    public void loginToVWO(String uid, String pwd) {
        enterUsername(uid);
        enterPassword(pwd);
        clickLoginButton();
    }

    }
