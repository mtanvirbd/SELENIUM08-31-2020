package kdf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Method {
	WebDriver driver;
	public void openBrowser() {
		System.setProperty("driver.chromedriver.x /exe", "chromedriver.exe");
		driver =  new ChromeDriver();
	}

	public void maxBrowser() {
		driver.manage().window().maximize();
	}
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void navigateToApplication(String url) {
		driver.get(url);
	}
	
	public void invalidUserId(String localvalue, String usName) {
		driver.findElement(By.id(localvalue)).sendKeys(usName);
	}
	
	public void enterPasswd(String locValue, String usPasswd) {
		driver.findElement(By.id(locValue)).sendKeys(usPasswd);
	}
	

	
	public void clickBtn(String loc, String locValue) {
		if (loc.equals("id")) {
			driver.findElement(By.id(locValue)).click();
		}
		else if (loc.equals("name")) {
			driver.findElement(By.name(locValue)).click();	
		} 
	}
	
	public String verifyErrMsg(String loc,String locValue) {
	
		String errMsg = null;
		if (loc.equals("cssSelector")) {
			errMsg = driver.findElement(By.cssSelector(locValue)).getText();
		}
		
		else if (loc.equals("id")) {
			errMsg = driver.findElement(By.id(locValue)).getText();

		}
		return errMsg;
		
		

	}
	
	public void closebrowser() {
		driver.close();
	}
}
