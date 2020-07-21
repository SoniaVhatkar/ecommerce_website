package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class Basic implements Constant {
	
public static WebDriver driver;

/* @Method name   : Initialize
 * @Description   : This is a common method which initializes values(browser and url)
 * @Param         : browser
 * @Return		  : void
 * @Author 		  : Sonia Vhatkar
 */
	
	@BeforeTest
	@Parameters("browser")
	
	public void Initialize (@Optional("chrome") String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(GC_KEY, GC_PATH);
			ChromeOptions opt = new ChromeOptions();
			driver=  new ChromeDriver(opt);
			opt.addArguments("--disable-notifications");
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(FF_KEY, FF_PATH);
			FirefoxOptions opt= new FirefoxOptions();
			driver= new FirefoxDriver(opt);
		}
		else {
			/*Throws error if browser not valid*/
			throw new Exception(ERROR_MSG_BROWSER);
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		
		
	}
	
	/* @Method name   : validateEachMethod
	 * @Description   : This is the common method which checks method status after each method execution and takes screenshot if method is failed
	 * @Param         : result
	 * @Return		  : void
	 * @Author 		  : Sonia Vhatkar
	 */
	@AfterMethod
	
	public void validateEachmethod(ITestResult result) {
		int status= result.getStatus();
		String name= result.getName();
		
		if(status==1) {
			Reporter.log(name+ "passed" , true);
			
		}
		else {
			
			Reporter.log(name+ "failed/skipped", true);
			Screenshots.take(driver, SS_PATH+name+".png");
		}
	}
	
	
	/* @Method name   : closure
	 * @Description   : This is the common method which which is used to close the browser at the end of execution
	 * @Param         :  
	 * @Return		  : void
	 * @Author 		  : Sonia Vhatkar
	 */
	@AfterTest
	public void closure() {
		driver.close();
	}
	
	

}
