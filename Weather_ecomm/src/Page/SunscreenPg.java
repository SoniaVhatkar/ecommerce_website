package Page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Basic;
import Base.Lowpriceproduct;

public class SunscreenPg extends Basic {
	
		public SunscreenPg(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
		
		
		/*/* List of webelements stores all sunscreen name */ 
		@FindBy(xpath="//p[@class='font-weight-bold top-space-10']  ") private List<WebElement> SunscreenList;
		
		/*List of webelements stores all sunscreen prices */
		@FindBy(xpath="//p[@class='font-weight-bold top-space-10'] /following-sibling::p ") private List<WebElement> SuncreenpriceList;
		
		/* List of webelements stores all sunscreen addcart button */
		@FindBy(xpath="//p[@class='font-weight-bold top-space-10'] /following-sibling::button") private List<WebElement> addcart;
		
		/*Webelement for cart icon*/
		@FindBy(xpath="//button[@onclick='goToCart()']") private WebElement Cartbutton;
		
		
		/*method returns sunscreen product with low price and spf50*/
		
		public String getspf50() {
		return Lowpriceproduct.getlowpriceproduct(SunscreenList, SuncreenpriceList, addcart,Product_category_spf50);
		}
		
		/* method returns sunscreen with low price and spf30 */
		public String getspf30() {
			return Lowpriceproduct.getlowpriceproduct(SunscreenList, SuncreenpriceList, addcart, Product_category_spf30);
		}
		
		/* clicks cart button */
		public void clickcartbutton() {
			Cartbutton.click();
		}
	}



