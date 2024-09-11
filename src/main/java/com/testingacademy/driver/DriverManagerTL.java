package com.testingacademy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileNotFoundException;
import java.util.Objects;

public class DriverManagerTL {
    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static void unloadDriver() {
        dr.remove();
    }

    public static void down() {
        if (Objects.nonNull(DriverManagerTL.getDriver())) {
            getDriver().quit();
            unloadDriver();
        }
    }

    public static void init() {
        if (Objects.isNull(DriverManagerTL.getDriver())){
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--guest");
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new EdgeDriver(options);
            setDriver(driver);
        }
    }
}


