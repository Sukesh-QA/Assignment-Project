package configuration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import browser.Browser;
import pages.TransLinkPage;
import utility.Utilities;


public class Helper {
	
	public static Browser browser = new Browser();
	public static WebDriver driver = browser.launchBrowser();
	public static TransLinkPage transLinkPage = new TransLinkPage(driver);
	public static Utilities util = new Utilities();
	public static Configuration config = new Configuration();
	
	@BeforeSuite
	public void beforeSuite() throws IOException{
		String path=System.getProperty("user.dir")+"/Screenshot/";
		FileUtils.deleteDirectory(new File(path));
	}
	
	@BeforeMethod
	public void getUrl() {
		String url = config.getURL();
		driver.get(url);
	}
	
	@AfterMethod
	public void scrnShot(ITestResult result,Method method) {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			util.getScreenshot(driver,method.getName());
		}
	}
	
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() throws IOException{
		
		
		driver.quit();
	}
	
	
	

}
