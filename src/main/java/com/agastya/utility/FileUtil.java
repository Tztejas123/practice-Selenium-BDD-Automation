package com.agastya.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {

    public String getProperty(String filePath, String key) {
        String baseDir = System.getProperty("user.dir");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(baseDir + "\\src\\main\\resources\\" + filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        String value = "";
        try {
            prop.load(fis);
            value = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    public String getConfiguration(String key) {
        return getProperty("config.properties", key);
    }

    public String getLocater(String locaterName) {
        return getProperty("Locators.properties", locaterName);
    }

    public void loadExcel() {
    }
}