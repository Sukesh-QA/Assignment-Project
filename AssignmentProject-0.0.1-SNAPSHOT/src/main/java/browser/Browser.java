package browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

	
	static WebDriver driver;
		public WebDriver launchBrowser() {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("test-type");
		    options.addArguments("start-maximized");
		    options.addArguments("--js-flags=--expose-gc");
		    options.addArguments("--enable-precise-memory-info");
		    options.addArguments("--disable-popup-blocking");
		    options.addArguments("--disable-default-apps");
		    options.addArguments("test-type=browser");
		    options.addArguments("disable-infobars");
		    driver = new ChromeDriver(options);
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    return driver;
		}
}
