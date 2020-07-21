package Base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
public static void take(WebDriver driver, String path) {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File(path);
		try {
			FileUtils.copyFile(src, dest);
		}
		catch(Exception e) {
			e.getStackTrace();
			
		}
	
		
	}

}
