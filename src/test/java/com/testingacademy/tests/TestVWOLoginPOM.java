package com.testingacademy.tests;

import com.testingacademy.pages.pageObjectModel.LoginPage_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLoginPOM {

    @Test
    public void testLoginWithInValidCredentials01() {
        WebDriver driver = new ChromeDriver();
        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);

        String error_msg_text = loginPage_pom.logintoinvalidCreds("jafayo9989@furnato.com","test123");

        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        driver.quit();
    }
    @Test
    public void testLoginWithInValidCredentials02() {
        WebDriver driver = new ChromeDriver();
        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);

        String error_msg_text = loginPage_pom.logintoinvalidCreds("jafayo9989@furnato.comm","Jafayo9989");

        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        driver.quit();
    }
    @Test
    public void testLoginWithValidCredentials03() {
        WebDriver driver = new ChromeDriver();
        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);

        String dashboard_text = loginPage_pom.logintovalidCreds("jafayo9989@furnato.com","Jafayo9989");

        Assert.assertEquals(dashboard_text, "Dashboard");
        driver.quit();
    }
}
