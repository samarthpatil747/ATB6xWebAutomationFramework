package com.testingacademy.base;

import com.testingacademy.driver.DriverManagerTL;
import com.testingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;

import static com.testingacademy.driver.DriverManagerTL.getDriver;


public class CommonToAllPage {
    public CommonToAllPage() {
        // If you want to use PageFactory, you need to initialize the elements in the constructor
        // If you want to call something every page object class call, Put code here.
        // If you want to open any file or establish data connection then write code here.
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

    // Find Element

    public void clickElement(WebElement by) {
        by.click();
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }



    // Waits

    public void implicitWait(int seconds) {
        DriverManagerTL.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    // Visiblity
    public WebElement presenceOfElement(final By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(final By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
    public void waitForElementToBeVisible(By elementLocation) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
    public void waitForElementToBeVisible(WebElement elementLocation) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(elementLocation));
    }

    public void waitForElementToBeClickable(By elementLocation) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elementLocation));
    }

    public WebElement presenceOfElement(WebElement elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated((By) elementLocation));

    }
    public void waitForAllElementToBeVisible(WebElement loc, String url){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(),Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfAllElements(loc));
            wait.until(ExpectedConditions.urlContains(url));
        }
        catch (Exception e){
            System.out.println("Failed to wait:"+ e.toString());
        }
    }
    //Invisiblity
    public void waitForElementToBeInVisible(By elementLocation) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOfElementLocated(elementLocation));
    }
    public void waitForElementToBeInVisible(WebElement elementLocation) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(elementLocation));
    }
    public void waitForElementToBeStale(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.stalenessOf(element));
    }
    public void waitForElementToBeStale(By by) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.stalenessOf(getDriver().findElement(by)));
    }

    // Get and Find Element
    protected WebElement getElement(By key) {
        return DriverManagerTL.getDriver().findElement(key);
    }

    protected WebElement getElement(By key, int index) {
        return getDriver().findElements(key).get(index);
    }
    protected WebElement getElement(String key) {
        return getDriver().findElement(By.cssSelector(key));
    }
    protected WebElement getElement(WebElement element) {
        return element;
    }

    protected WebElement enterInput(WebElement element, String key) {
        element.sendKeys(key);
        return element;
    }
   /* protected  void enterInput(WebElement element, String key) {
        element.sendKeys(key);
    }
*/
   protected void enterInput(By by, String key) {
       DriverManagerTL.getDriver().findElement(by).sendKeys(key);
       return;
   }

    public void enterInput(WebElement element, String key, boolean clearField) {
        if (clearField) {
            element.clear();
        }
        element.sendKeys(key);
    }

    // Get Text

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }
    public String getText(WebElement element) {
        return element.getText();
    }
    // Get Attribute
    public String getAttribute(By by, String attribute) {
        return getDriver().findElement(by).getAttribute(attribute);
    }
    public String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
    // Get CSS Value
    public String getCssValue(By by, String propertyName) {
        return getDriver().findElement(by).getCssValue(propertyName);
    }
    public String getCssValue(WebElement element, String propertyName) {
        return element.getCssValue(propertyName);
    }
    // Is Displayed
    public boolean isDisplayed(By by) {
        return getDriver().findElement(by).isDisplayed();
    }
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }
    // Is Enabled
    public boolean isEnabled(By by) {
        return getDriver().findElement(by).isEnabled();
    }
    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }
    // Is Selected
    public boolean isSelected(By by) {
        return getDriver().findElement(by).isSelected();
    }
    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }
    // Get Title
    public String getTitle() {
        return getDriver().getTitle();
    }
    // Get Current URL
    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }
    // Get Page Source
    public String getPageSource() {
        return getDriver().getPageSource();
    }
    // Get Window Handle
    public String getWindowHandle() {
        return getDriver().getWindowHandle();
    }
    // Get Window Handles
    public void getWindowHandles() {
        getDriver().getWindowHandles();
    }
    // Switch To Window
    public void switchToWindow(String windowHandle) {
        getDriver().switchTo().window(windowHandle);
    }
    // Switch To Frame
    public void switchToFrame(int index) {
        getDriver().switchTo().frame(index);
    }
    public void switchToFrame(String id) {
        getDriver().switchTo().frame(id);
    }
    public void switchToFrame(WebElement element) {
        getDriver().switchTo().frame(element);
    }
    // Switch To Parent Frame
    public void switchToParentFrame() {
        getDriver().switchTo().parentFrame();
    }
    // Switch To Default Content
    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }
    // Navigate To
    public void navigateTo(String url) {
        getDriver().navigate().to(url);
    }
    // Navigate Back
    public void navigateBack() {
        getDriver().navigate().back();
    }
    // Navigate Forward
    public void navigateForward() {
        getDriver().navigate().forward();
    }
    // Navigate Refresh
    public void navigateRefresh() {
        getDriver().navigate().refresh();
    }
    // Close
    public void close() {
        getDriver().close();
    }
    // Quit
    public void quit() {
        getDriver().quit();
    }
    // Alert Methods
    public void alertAccept() {
        getDriver().switchTo().alert().accept();
    }
    public void alertDismiss() {
        getDriver().switchTo().alert().dismiss();
    }
    public String alertGetText() {
        return getDriver().switchTo().alert().getText();
    }
    public void alertSendKeys(String keys) {
        getDriver().switchTo().alert().sendKeys(keys);
    }
    // Actions
    public void actionsClick(WebElement element) {
        new org.openqa.selenium.interactions.Actions(getDriver()).click(element).perform();
    }
    public void actionsDoubleClick(WebElement element) {
        new org.openqa.selenium.interactions.Actions(getDriver()).doubleClick(element).perform();
    }
    public void actionsContextClick(WebElement element) {
        new org.openqa.selenium.interactions.Actions(getDriver()).contextClick(element).perform();
    }
    public void actionsMoveToElement(WebElement element) {
        new org.openqa.selenium.interactions.Actions(getDriver()).moveToElement(element).perform();
    }
    public void actionsDragAndDrop(WebElement source, WebElement target) {
        new org.openqa.selenium.interactions.Actions(getDriver()).dragAndDrop(source, target).perform();
    }
    public void actionsDragAndDropBy(WebElement source, int xOffset, int yOffset) {
        new org.openqa.selenium.interactions.Actions(getDriver()).dragAndDropBy(source, xOffset, yOffset).perform();
    }
    public void actionsBuild() {
        new org.openqa.selenium.interactions.Actions(getDriver()).build();
    }
    public void actionsPerform() {
        new org.openqa.selenium.interactions.Actions(getDriver()).perform();
    }
    // JavaScript Executor Methods
    public void jsExecuteScript(String script) {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript(script);
    }
    public void jsExecuteScript(WebElement element, String script) {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript(script, element);
    }
    public void jsExecuteAsyncScript(String script) {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeAsyncScript(script);
    }
    public void jsExecuteAsyncScript(WebElement element, String script) {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeAsyncScript(script, element);
    }
    public void jsGetInnerText() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return document.documentElement.innerText;");
    }
    public void jsGetInnerHTML() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return document.documentElement.innerHTML;");
    }
    public void jsGetOuterHTML() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return document.documentElement.outerHTML;");
    }
    public void jsGetDocumentTitle() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return document.title;");
    }
    public void jsGetLocation() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.location;");
    }
    public void jsGetWindowInnerWidth() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.innerWidth;");
    }
    public void jsGetWindowInnerHeight() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.innerHeight;");
    }
    public void jsGetWindowOuterWidth() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.outerWidth;");
    }
    public void jsGetWindowOuterHeight() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.outerHeight;");
    }
    public void jsGetWindowScreenX() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.screenX;");
    }
    public void jsGetWindowScreenY() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.screenY;");
    }
    public void jsGetWindowScrollX() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.scrollX;");
    }
    public void jsGetWindowScrollY() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.scrollY;");
    }
    public void jsGetWindowScrollBars() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.scrollBars;");
    }
    public void jsGetWindowStatus() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.status;");
    }
    public void jsGetWindowNavigator() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.navigator;");
    }
    public void jsGetWindowHistory() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.history;");
    }
    public void jsGetWindowLocation() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.location;");
    }
    public void jsGetWindowFrames() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.frames;");
    }
    public void jsGetWindowOpacity() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.opacity;");
    }
    public void jsGetWindowDevicePixelRatio() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.devicePixelRatio;");
    }
    public void jsGetWindowScreen() {
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("return window.screen;");
    }


}
