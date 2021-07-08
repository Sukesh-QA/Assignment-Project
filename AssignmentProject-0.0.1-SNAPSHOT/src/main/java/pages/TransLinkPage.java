package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TransLinkPage {
	
	
	static WebDriver driver;
	static WebDriverWait wait;
	public TransLinkPage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(this.driver,10);
	}
	
	String nextBus = "//button[@id='next-bus']";
	String busroute = "//input[@form='NextBusSearch']";
	String findmyNextBus = "//*[@id=\"next-bus_tab\"]/section/div/div/button";
	String addfav = "//*[@id=\"content\"]/div[3]/section[3]/div[2]/div/button";
	String editname = "//*[@id='add-to-favourites_dialog']/form/section/label/textarea";
	String addfavBtn = "//*[@id='add-to-favourites_dialog']/form/section/div/button";
	String myFavBtn = "//*[@id='content']/div[3]/section[3]/div[2]/div/a[3]";
	String favurl="//li[@class=' useButton']/a";
	String favUrlTXt ="/html/body/form/div[3]/div[3]/div[1]/div/div[3]/div[1]";
	String commLink= "//*[@id='MainContent_PanelStops']/div[3]/section[3]/article/div/a";
	String linkTxt = "//*[@id=\"MainContent_PanelStops\"]/div[3]/section[3]/article[1]/div/a";
	String busstpNo = "//*[@class='stopNo']";
	
	public void nextBusClick() {
		driver.findElement(By.xpath(nextBus)).click();
	}
	public void busRouteText(String num) {
		driver.findElement(By.xpath(busroute)).sendKeys(num);
	}
	public void findNextBusClick() {
		driver.findElement(By.xpath(findmyNextBus)).click();
	}
	public void addFavClick() {
		driver.findElement(By.xpath(addfav)).click();
	}
	public void editNameText(String name) {
		driver.findElement(By.xpath(editname)).sendKeys(name);
	}
	public void addFavBtnClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addfavBtn)));
		driver.findElement(By.xpath(addfavBtn)).click();
	}
	public String myFavBtnClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myFavBtn)));
		driver.findElement(By.xpath(myFavBtn)).click();
		String link = (driver.findElement(By.xpath(favurl)).getAttribute("href"));
		return link;
	}
	public void favUrlClick() {
		driver.findElement(By.xpath(favurl)).click(); 
	}
	
	public String favUrlText() {
		driver.switchTo().frame(0);
	
		String text = driver.findElement(By.xpath(favUrlTXt)).getText();
		return text;
	}
	public void commLinkClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(commLink)));
		driver.findElement(By.xpath(commLink)).click();
	}
	public void linkTextClick() {
		driver.findElement(By.xpath(linkTxt)).click();
	}

	public String busStpNoText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(busstpNo)));
		WebElement busStpNo = driver.findElement(By.xpath(busstpNo));
		String busStpNoText = busStpNo.getText();
		return busStpNoText;
	}

}
