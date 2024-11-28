package com.agastya.utility;

import org.openqa.selenium.chrome.ChromeDriver;

import com.agastya.base.Keyword;
import com.agastya.base.TestBase;
import com.agastya.config.Configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private Keyword keyword;

    //@Before
    public void setUp() throws Exception {
        Configuration config = new Configuration();
        keyword = new Keyword();
        TestBase.driver = new ChromeDriver(); // Initialize the driver
        keyword.openBrowser(config.getBrowserName());
    }

    //@After
    public void tearDown() throws Exception {
        TestBase.getDriver().quit();
    }
}