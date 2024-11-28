package com.agastya.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.agastya.base.TestBase;

public class WaitFor {
	//aagee ke jo code write karege uss may uss perticular
	//webelement ko maang lena hay jiske liye aap ko wait 
	// chahiye 
	private static  FluentWait<WebDriver>wait;
	static {
		wait=new FluentWait<WebDriver>(TestBase.getDriver());
		wait.withTimeout(Duration.ofSeconds(60));
	}
	public static void StaleElement(WebElement element) {
		//and ye wait element 60sec wait karta hay 
		wait.until(ExpectedConditions.stalenessOf(element));
		
		
	}

}
