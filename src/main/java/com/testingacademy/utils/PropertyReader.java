package com.testingacademy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReader {
    public PropertyReader() {
    }

    public static String readKey(String key) throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        Properties p = null;
        fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            p = new Properties();
            p.load(fileInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return p.getProperty(key);

    }
}

