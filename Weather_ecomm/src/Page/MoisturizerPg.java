package Page;

import Base.Basic;
import Base.Lowpriceproduct;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoisturizerPg extends Basic{
	
	public MoisturizerPg(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	/* List of webelements stores all Moisturizer name */ 
	@FindBy(xpath= "//p[@class='font-weight-bold top-space-10']") private List<WebElement> MoisturizerList;

	/*List of webelements stores all Moisturize price */
	@FindBy(xpath="//p[@class='font-weight-bold top-space-10']/following-sibling::p") private List<WebElement> Moisturizerprice;
	

	/* List of webelements stores all moisturizer addcart button */
	@FindBy(xpath="//p[@class='font-weight-bold top-space-10']/following-sibling::button") private List<WebElement> addcart;
	
	/*Webelement for cart icon*/
	@FindBy(xpath="//button[@onclick='goToCart()']") private WebElement Cartbutton;
	
	/*method returns aloe product with low price*/
	public String getAloe() {
	return Lowpriceproduct.getlowpriceproduct(MoisturizerList, Moisturizerprice, addcart,Product_category_aloe);
	}
	
	/* method returns almond with low price */
	public String getAlmond() {
		return Lowpriceproduct.getlowpriceproduct(MoisturizerList, Moisturizerprice, addcart, Product_category_almond);
	}
	
	/* clicks cart button */
	public void clickcartbutton() {
		Cartbutton.click();
	}
	}
