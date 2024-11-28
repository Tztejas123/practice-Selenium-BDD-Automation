package com.agastya.config;

import com.agastya.utility.FileUtil;

public class Configuration {
    private FileUtil fileUtil = new FileUtil();

    public String getAppUrl(String env) {
        return fileUtil.getProperty("\\src\\main\\resources\\config.properties", "app." + env + ".url");
    }

    public String getBrowserName() {
        return fileUtil.getConfiguration("brower_name");
    }
}