package com.testingacademy.tests;

import com.testingacademy.base.CommonToAllTest;
import com.testingacademy.pages.pageObjectModel.Dashboard_POM;
import com.testingacademy.pages.pageObjectModel.LoginPage_Super;
import com.testingacademy.utils.PropertyReader;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.FileNotFoundException;

public class LoginTest_BaseTest extends CommonToAllTest {
    @Test(priority = 2)
    public void testLoginPositive01() throws Exception {
    //Who will start the webdriver
    //Who will close the webdriver
    //What will be the test data
    //What will be the test steps
    //What will be the expected result
    //Actual result
    //Assertion
        LoginPage_Super loginPage_super = new LoginPage_Super();
        Dashboard_POM dashboard_pom = loginPage_super.openURL(PropertyReader.readKey("qa_URL"))
                .loginToVWOPositive()
                .afterLogin();
        String expectedUserName = dashboard_pom.loggedInUserName();
        Assertions.assertThat(expectedUserName)
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readKey("expected_username"))
                .isEqualToIgnoringCase(PropertyReader.readKey("expected_username"));


    }


}
