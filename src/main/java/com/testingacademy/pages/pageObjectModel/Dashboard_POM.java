package com.testingacademy.pages.pageObjectModel;

import com.testingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;

public class Dashboard_POM extends CommonToAllPage {
    public Dashboard_POM() {
    }

    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    // Page Actions
    public String loggedInUserName() {
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();

    }

}
