package com.agastya.base;
import static com.agastya.constants.Browser.CHROME;
import static com.agastya.constants.Browser.FIREFOX;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Keyword {
	public void openBrowser(String browserName) {
		switch (browserName) {
		case CHROME:
			TestBase.driver = new ChromeDriver();
			break;
		case FIREFOX:
			TestBase.driver = new FirefoxDriver();
			break;
		default:
			TestBase.driver = new ChromeDriver();
			break;
		}
	}
	public void launchUrl(String url) {
		var x=10;
		System.out.println(x);
		TestBase.driver.get(url);
	}
	public void enterText(WebElement e, String textToEnter) {
		e.sendKeys(textToEnter);
	}
	public WebElement getwebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return TestBase.driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return TestBase.driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return TestBase.driver.findElement(By.cssSelector(locatorValue));
		}
		return null;
	}
	public List<WebElement> getwebElements(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return TestBase.driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return TestBase.driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return TestBase.driver.findElements(By.cssSelector(locatorValue));
		}
		return null;
	}
//here we use method overloading
	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		getwebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}
	public void click(String locatorType,String locatorValue) {
		getwebElement(locatorType, locatorValue).click();
	}
	//this is for get only one text
	public String getText(String locatorType, String locatorValue) {
		return getwebElement(locatorType, locatorValue).getText();
	}
	public List<String> getTexts(String locatorType, String locatorValue) {
		List<WebElement>data= getwebElements(locatorType, locatorValue);
		List<String>stringData=new LinkedList<String>();
		for (WebElement element : data) {
			stringData.add(element.getText());
		}
		return stringData;
	}
	//this method use in Locater interface class yaha value sida locate se aayega
	//and jo value aayega usko sirf split karna hay
	public void enterText(String loctor,String textToEnter) {
		//split karne ke liye ## use kiya 
		String parts[]=loctor.split("##");
//[0 position locater type 1position locater value and 1 position we use enter text]
		enterText(parts[0],parts[1],textToEnter);
	}
	public void click(String loctor) {
		String parts[]=loctor.split("##");
		click(parts[0],parts[1]);
	}
	/*aagr jyada kaam may nahi aa raha hay tab isko use karo
	 * Thsis methos retuurns the text of specific web element 
	 * this method is no longer in use insted you can use {@codeget text(String locaterType)}
	 @Deprecated*/
	public List<String> getTexts(String loctor) {
		String parts[]=loctor.split("##");
		return getTexts(parts[0],parts[1]);
	}
	public void quitBrowser() {
		TestBase.getDriver();
	}
}