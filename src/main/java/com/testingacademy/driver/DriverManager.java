package com.testingacademy.driver;

import com.testingacademy.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.FileNotFoundException;
import java.lang.reflect.Parameter;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

  //  @Test(Parameter="browser")
    public static void init() {
        if (driver == null) {
            String browser = null;
            try {
                browser = PropertyReader.readKey("browser");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            switch (browser) {
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "safari":
                    SafariOptions safariOptions = new SafariOptions();
                    driver = new SafariDriver(safariOptions);
                    break;
                case "ie":
                    InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                    driver = new InternetExplorerDriver(internetExplorerOptions);
                    break;
                case "headless":
                    break;
                case "edge-headless":
                    break;
                case "firefox-headless":
                    break;
                case "safari-headless":
                    break;
                case "ie-headless":
                    break;
                case "edge-grid":
                    break;
                case "chrome-grid":
                    break;
                case "firefox-grid":
                    break;
                case "safari-grid":
                    break;
                case "ie-grid":
                    break;
                case "remote-chrome":
                    break;
                case "remote-firefox":
                    break;
                case "remote-safari":
                    break;
                case "remote-ie":
                    break;
                case "remote-edge":
                    break;
                case "remote-chrome-grid":
                    break;
                case "remote-firefox-grid":
                    break;
                case "remote-safari-grid":
                    break;
                case "remote-ie-grid":
                    break;
                case "remote-edge-grid":
                    break;
                case "remote-chrome-headless":
                    break;
                case "remote-firefox-headless":
                    break;
                case "remote-safari-headless":
                    break;
                case "remote-ie-headless":
                    break;
                case "remote-edge-headless":
                    break;
                case "remote-chrome-grid-headless":
                    break;
                case "remote-firefox-grid-headless":
                    break;
                case "remote-safari-grid-headless":
                    break;
                case "remote-ie-grid-headless":
                    break;
                case "remote-edge-grid-headless":
                    break;

                default:
                    throw new IllegalStateException("Invalid browser");
            }

        }
    }

    public static void down() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
