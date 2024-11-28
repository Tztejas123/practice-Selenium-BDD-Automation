package agastya;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.agastya.base.Keyword;
import com.agastya.locaters.LocatorOn;
public class GetTextFromTheProductInMyntra extends com.agastya.base.TestBase {
	@Test
	public void verifySearchResultsForSneakers() throws InterruptedException {
		getDriver().get("https://www.myntra.com");
		getDriver().findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]"))
				.sendKeys("sneakers" + Keys.RETURN);
		Thread.sleep(2000);
		List<WebElement> productList = getDriver()
				.findElements(By.xpath("//div[@class=\"product-productMetaInfo\"]/h4[@class=\"product-product\"]"));
		Iterator<WebElement> itr = productList.iterator();
		while (itr.hasNext()) {
			String productTitle = itr.next().getText();
			Assert.assertTrue(productTitle.contains("Sneakers"),
					"Product Title dosen't contatnt sneaker" + productTitle);
		}
	}
	// this is the test case with use of framework
	@Test
	public void VerifySearchResultsForSneakersUsingFramework() {
		Keyword keyword = new Keyword();
		keyword.launchUrl("https://www.myntra.com");
		keyword.enterText(LocatorOn.SEARCHCOMPONANAT, "sneakers");
		keyword.click(LocatorOn.MAGNIFIRECLICK);
		List<String> productList = keyword.getTexts(LocatorOn.PRODUCTTITLES);
		Iterator<String> itr = productList.iterator();
		while (itr.hasNext()) {
			String productTitle = itr.next();
			Assert.assertTrue(productTitle.contains("Sneakers"),
					"Product Title dosen't contatnt sneaker" + productTitle);
		}
	}
}