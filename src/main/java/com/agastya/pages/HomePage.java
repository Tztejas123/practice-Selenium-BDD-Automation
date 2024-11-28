package com.agastya.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.agastya.utility.WaitFor;
public class HomePage {

	@FindBy(css = "input#woocommerce-product-search-field-0")
	WebElement searchComponent;
	@FindBy(css = "div.storefront-sorting+ul>li:nth-child(1)>a.add_to_cart_button")
	WebElement addToCartBtn;
	@FindBy(css = "h2[class=\"woocommerce-loop-product__title\"]")
	// isko 1 se jyada ke upar use karna hay
	List<WebElement> productTitles;

	public void searchProduct(String productName) {
		searchComponent.sendKeys(productName);
		searchComponent.sendKeys(Keys.RETURN);
		System.out.println("Entered the Product name " + productName + "to search");
	}

	public void clickToAddToCartBtn() {
		addToCartBtn.click();
	}

	public List<String> getProductTitles() {
		List<String> titles = new ArrayList<String>();
		// list ke under product title add karne hay
		for (WebElement productTitle : productTitles) {
			String text = null;
			try {
				text = productTitle.getText();
			} catch (StaleElementReferenceException e) {
				WaitFor.StaleElement(productTitle);
				text = productTitle.getText();
			}
		}
		return titles;
	}
}
