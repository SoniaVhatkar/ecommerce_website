package Page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Base.Basic;

public class Checkoutpg extends Basic {
	
	public Checkoutpg(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	/* List of added products in cart */
	@FindBy(xpath="//tr/td[1]") private List<WebElement> CartItems;
	
	/*Button to pay with card */
	@FindBy(xpath="//button[@class='stripe-button-el']") private WebElement paywithcard;
	
	
	@FindBy(css="iframe.stripe_checkout_app") private WebElement Stripeframe;
	
	/*Verify if payment page displayed or not */
	public boolean iframe() {
		return Stripeframe.isDisplayed();
	}
	
	public void switchtoframe(WebDriver driver) {
		driver.switchTo().frame(Stripeframe);
	}
	
	public void verifycart(String lp1, String lp2) {
		List<String> LowpriceitemList = new ArrayList<String>(); /* list of added items */
		LowpriceitemList.add(lp1);
		LowpriceitemList.add(lp2);
		Collections.sort(LowpriceitemList);
		List<String> cartitemList= new ArrayList<String>(); /*items displayed in table */
		for (int i = 0; i < CartItems.size(); i++) {
			cartitemList.add(CartItems.get(i).getText());
		}
		Collections.sort(cartitemList);
		Assert.assertEquals(cartitemList.size(), LowpriceitemList.size(), ERROR_MSG_CART);
		Assert.assertTrue(cartitemList.equals(LowpriceitemList), ERROR_MSG_CART);
		Reporter.log(Success_MSG_CART);
		
	}
	
	public void paycard() {
		paywithcard.click();
	}
	

}
