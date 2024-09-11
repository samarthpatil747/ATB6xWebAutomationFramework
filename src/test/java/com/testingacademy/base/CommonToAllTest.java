package com.testingacademy.base;

import com.testingacademy.driver.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {
    // To call the start the WebDriver
    @BeforeMethod
    public void setUp() {
        DriverManagerTL.init();
    }
    @AfterMethod
    public void tearDown() {
        DriverManagerTL.down();
    }
}
