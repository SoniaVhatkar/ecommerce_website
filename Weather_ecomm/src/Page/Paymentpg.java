package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Basic;

public class Paymentpg extends Basic{

	public Paymentpg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* Webelemnt for email address */
	@FindBy(xpath="//input[@type='email']") private WebElement EmailID;
	
	/* Webelemnt for cardnumber */
	@FindBy(xpath="//input[@placeholder='Card number']") private WebElement Cardnumber;
	
	/* Webelemnt for expiry date of card */
	@FindBy(xpath="//input[@placeholder='MM / YY']") private WebElement Monthyear;
	
	/* Webelemnt for cvc number of card */
	@FindBy(xpath="//input[@placeholder='CVC']") private WebElement CVCno;
	
	/*Webelemnt for payment*/
	@FindBy(xpath="//div[@class='Section-button']/button") private WebElement Paymentbutton;
	
	/* Webelement for zipcode */
	@FindBy(xpath="//input[@placeholder='ZIP Code']") private WebElement zipcode;
	
	
	public void EnterEmailadd(String email) {
		EmailID.sendKeys(email);
	}
	
	public void Entercardno(String cardno) {
		Cardnumber.sendKeys(cardno);
	}
	
	public void EnterMMYY(String mmyy) {
		Monthyear.sendKeys(mmyy);
	}
	
	public void EnterCVC(String cvc) {
		CVCno.sendKeys(cvc);
	}
			
	public void Enterzipcode(String zip) {
		zipcode.sendKeys(zip);		
	}
	
	public void Clickpaymentbutton() {
		Paymentbutton.click();
	}
	
}
