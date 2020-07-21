package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Basic;

public class Confirmationpg extends Basic {
	
	public Confirmationpg(WebDriver driver) {
		PageFactory.initElements(driver, this );
	}
	
	/*Webelement for payment success message */
	@FindBy(tagName = "h2") private WebElement Paymentmessage;
	
	
	/* Webelement for paragraph */
	@FindBy(xpath="//p[@class='text-justify']") private WebElement paymentconfirmparagraph;
	
	public String Confirmation() {
		
		WebDriverWait wd= new WebDriverWait(driver, EXPLICIT_TIMEOUT);
		wd.until(ExpectedConditions.visibilityOf(paymentconfirmparagraph));
		return Paymentmessage.getText();
	}
	
	
}
 