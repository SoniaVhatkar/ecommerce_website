package Base;

public interface Constant {

		String GC_KEY= "webdriver.chrome.driver";
		String GC_PATH= "./driver/chromedriver.exe";
		String FF_KEY= "webdriver.gecko.driver";
		String FF_PATH= "./driver/geckodriver.exe";
		String url= "http://weathershopper.pythonanywhere.com/";
		String SS_PATH= "./Shots/";
		String XL_PATH= "./data/credentials.xlsx";
		String Sheet_name="Sheet1";
		String units= " °C";
		
		String CART_PAGE_TITLE="Cart Items";
		String Page_title_moisturizer= "The Best Moisturizers in the World!";
		String Page_title_sunscreen= "The Best Sunscreens in the World!";
		String Product_category_aloe= "Aloe";
		String Product_category_almond= "Almond";
		String Product_category_spf30= "SPF-30";
		String Product_category_spf50= "SPF-50";
		
		String ERROR_MSG_CART= "Wrong products added to the cart";
		String ERROR_MSG_CONFIRMATION="Payment is not successfull";
		String ERROR_MSG_BROWSER="Browser not valid";
		String SUCCESS_MSG_CONFIRMATION="Payment is successfull";
		String Success_MSG_CART= " Products added to the cart are matched";
		
		int Mintemp= 19;
		int Maxtemp=34;
		long IMPLICIT_TIMEOUT=10;
		long EXPLICIT_TIMEOUT=8;
		
	}


