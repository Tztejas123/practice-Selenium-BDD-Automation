package com.agastya.base;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import com.agastya.config.Configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestBase {
	public static RemoteWebDriver driver;
	public Configuration config;
	
	public static RemoteWebDriver getDriver() {
		return driver;
	}
	@Parameters("browser_name")
	@Before
	public void setUp()  {
		config=new Configuration();
		String browerName = config.getBrowserName();
		if(browerName==null) {
			browerName="FireFox";
		}
		if (browerName.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}else if(browerName.equalsIgnoreCase("FireFox")) {
			driver=new FirefoxDriver();
		}else {
			System.err.println("Invalid browser name: "+browerName);
		}
		String url=config.getAppUrl("beta");
		driver.get(url);
		System.out.println("Lounching App url "+url);
		return;
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
