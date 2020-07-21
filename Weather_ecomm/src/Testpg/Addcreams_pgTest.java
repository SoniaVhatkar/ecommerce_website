package Testpg;

import Page.Checkoutpg;
import Page.Confirmationpg;
import Page.MoisturizerPg;
import Page.Paymentpg;
import Page.SunscreenPg;
import Page.WeatherHomepg;
import Base.Basic;
import Base.Exceldata;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Addcreams_pgTest extends Basic {
	
	
	public static String LowerpriceItem1; /* static varibles to compare with cart list */ 
	public static String LowerpriceItem2;
	MoisturizerPg moisturizer;
	WeatherHomepg objHomepg;
	SunscreenPg sunscreen;
	Checkoutpg checkitems;
	Paymentpg paymentdetails;
	Confirmationpg confirm;
	int systemtemp ;
	
	@Test(priority = 1)
	
	/* Method selects products based upon temperature */
	
	public void selectcream() throws InterruptedException {
		
		moisturizer = new MoisturizerPg(driver);
		
		objHomepg = new WeatherHomepg(driver);
		systemtemp = objHomepg.gettemperature();	
		System.out.println(systemtemp + units);
		
		if(systemtemp<Mintemp) { /* compares with systemtemp generated */
			
			objHomepg.Clickmoisture(); 
			Assert.assertEquals(driver.getTitle(), Page_title_moisturizer);
			Reporter.log("You have successfully directed to moisturizer page");
			Thread.sleep(1000);
			LowerpriceItem1 = moisturizer.getAloe();
			LowerpriceItem2 = moisturizer.getAlmond();
			moisturizer.clickcartbutton();	
			Thread.sleep(3000);
			System.out.println(LowerpriceItem1);
			System.out.println(LowerpriceItem2);
		}
		
		else if (systemtemp > Maxtemp) {

			objHomepg.Clicksunscreen();
			sunscreen= new SunscreenPg(driver);
			Assert.assertEquals(driver.getTitle(), Page_title_sunscreen);
			Reporter.log("You have successfully directed to suncreen page");
			LowerpriceItem1= sunscreen.getspf50();
			LowerpriceItem2= sunscreen.getspf30();
			sunscreen.clickcartbutton();
			Thread.sleep(3000);
			System.out.println(LowerpriceItem1);
			System.out.println(LowerpriceItem2);
		}
		
		Assert.assertEquals(driver.getTitle(), CART_PAGE_TITLE);
	}	
		@Test(priority = 3)
		/* Method verifies the added items in cart  */
		
		public void checklist() throws InterruptedException {
			checkitems= new Checkoutpg(driver);
			checkitems.verifycart(LowerpriceItem1, LowerpriceItem2);
			checkitems.paycard();
			Thread.sleep(1000);
			checkitems.iframe();
			
		}

	/*Method to get multipe data from excel */
	@DataProvider
	public Object[][] getExceldata(){
		Object data[][]= Exceldata.getdata(Sheet_name);
		return data;
	}
	
	/*Adding card details using data provider method */
	@Test(priority = 4, dataProvider = "getExceldata")
	public void addPaymentdetails(String email,String cardno,String mmyy, String cvc, String zip) {
		checkitems.switchtoframe(driver);
		paymentdetails= new Paymentpg(driver);
		paymentdetails.EnterEmailadd(email);
		paymentdetails.Entercardno(cardno);
		paymentdetails.EnterMMYY(mmyy);
		paymentdetails.EnterCVC(cvc);
		paymentdetails.Enterzipcode(zip);
		paymentdetails.Clickpaymentbutton();
		driver.switchTo().defaultContent();	
		
	}
	@Test( priority = 5)
	
	public void Successpg() {
		confirm= new Confirmationpg(driver);
		Assert.assertEquals(confirm.Confirmation(),"PAYMENT SUCCESS",ERROR_MSG_CONFIRMATION);
		Reporter.log(SUCCESS_MSG_CONFIRMATION);
		
	}
	
	
	
}
	

