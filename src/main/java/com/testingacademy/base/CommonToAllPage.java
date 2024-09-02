package com.testingacademy.base;

import com.testingacademy.driver.DriverManager;
import com.testingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;

import static com.testingacademy.driver.DriverManager.getDriver;

public class CommonToAllPage {
    public CommonToAllPage() {
    }

    public void openLoginURL(String URL) {
    // driver.get
    //    getDriver().get("https://app.vwo.com/#/login");
        try {
            switch (URL) {
                case "prod":
                    getDriver().get(PropertyReader.readKey("prod_url"));
                    break;
                case "staging":
                    getDriver().get(PropertyReader.readKey("staging_url"));
                    break;
                case "dev":
                    getDriver().get(PropertyReader.readKey("dev_url"));
                    break;
                default:
                    System.out.println("Invalid URL");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickElement(WebElement by) {
        by.click();
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }
    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement element, String key) {
        element.sendKeys(key);
    }

    // Waits

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));

    }
    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }

    public WebElement getElement(WebElement element) {
        return element;
    }


}
