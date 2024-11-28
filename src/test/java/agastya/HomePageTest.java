package agastya;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.agastya.base.TestBase;
import com.agastya.pages.HomePage;
//
public class HomePageTest extends TestBase {
	@Test
	public void verifySerachResultOnSearchingFalcon() {
//iss object ko iss tarah banane se null pointer exception aayega 
		HomePage homePage=PageFactory.initElements(getDriver(), HomePage.class);
		homePage.searchProduct("Falcon");
		//yaha par check karuga producttitle may falcon hay ki nahi
		getDriver().navigate().refresh();
		List<String>productTitles=homePage.getProductTitles();
		for (String productTitle : productTitles) {
			//now check the title
			Assert.assertTrue(productTitle.contains("Falcon"));
			
		}
	}
}
