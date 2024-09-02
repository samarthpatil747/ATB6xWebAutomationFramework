package com.testingacademy.tests;

import com.testingacademy.base.CommonToAllTest;
import com.testingacademy.pages.pageFactory.LoginPage_PF_Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testingacademy.driver.DriverManager.driver;

public class TestVWOLogin_PF_Base_Dm extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF_Base_Dm.class);

    @Test
    public void testLoginWithInValidCredentials01() {
        logger.info("Starting the test");
        LoginPage_PF_Base loginPagePfbase = new LoginPage_PF_Base(driver);
        logger.info("Opening the URL");
        loginPagePfbase.openLoginURL("staging");
        String errorMessage = loginPagePfbase.invalidloginToVWO();
        logger.info("Verifying the result");

        Assert.assertTrue(errorMessage.contains("Your email, password, IP address or location did not match"));
        //AssertJ
        String error_msg = "Your email, password, IP address or location did not match";
        Assertions.assertThat(error_msg)
                .isNotNull().isNotBlank();
        //.contains(PropertyReader.readkey("expectd_username"));
        driver.quit();
    }

    @Test
    public void testLoginWithValidCredentials02() {
        LoginPage_PF_Base loginPagePfbase = new LoginPage_PF_Base(driver);
        loginPagePfbase.openLoginURL("prod");
        String validloginToVWO = loginPagePfbase.validloginToVWO();
        Assert.assertTrue(validloginToVWO.contains("Dashboard"));
        driver.quit();
    }

}
