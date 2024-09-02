package com.testingacademy.tests;

import com.testingacademy.pages.pageFactory.LoginPage_PF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin_PF_Base {

    @Test
    public void testLoginWithInValidCredentials01() {

        // Validation
        WebDriver wait = new ChromeDriver();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       // String errorMessage = loginPage_pf.getErrorMessage();
       // Assert.assertTrue(errorMessage.contains("Your email, password, IP address or location did not match"));
       // driver.quit();
    }
    @Test
    public void testLoginWithValidCredentials02() {
        WebDriver driver = new ChromeDriver();
        LoginPage_PF loginPage_pf = new LoginPage_PF(driver);
        driver.get("https://app.vwo.com/#/login");
        loginPage_pf.loginToVWO("jafayo9989@furnato.com","Jafayo9989");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String dashboardTitle = loginPage_pf.getDashboardText();
        Assert.assertTrue(dashboardTitle.contains("Dashboard"));
        driver.quit();
    }

}
