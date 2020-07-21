package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherHomepg {
	
	public WeatherHomepg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* Webelement for temperature */
	@FindBy(id="temperature") private WebElement Temperature;
	
	/* Webelement for mositurizer */
	@FindBy(xpath="//a[@href='/moisturizer']") private WebElement Moisturizer;
	
	/* Webelement for sunscreen */
	@FindBy(xpath="//a[@href='/sunscreen']") private WebElement Suncreen;
	
	
	/* This method returns Temp value*/
	public int gettemperature() {
		String[] t= Temperature.getText().split(" ");
		int temp= Integer.parseInt(t[0]);
		return temp;
	}
	
	/* This method is used to click moisturier button/link */
	
	public void Clickmoisture() {
		Moisturizer.click();
	}
	
	/* This method is used to click Sunscreen button/link */
	
	public void Clicksunscreen() {
		Suncreen.click();
	}
	
	

}
