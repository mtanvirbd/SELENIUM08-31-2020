package com.webappsecurity.zero.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.FundTransferConfirmation;
import com.webappsecurity.zero.Pages.FundTransferVerify;
import com.webappsecurity.zero.Pages.Homepage;
import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.TransferFunds;

import utils.GenericMsg;

public class VerifyFundTransferfundTest {
	WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		System.setProperty("driver.chromedriver.x /exe", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void fundTransferVerify() throws IOException {
		Homepage hpg =  new Homepage(driver);
		Login lin = new Login(driver);
		AccountSummary acSum = new AccountSummary(driver);
		TransferFunds trFund = new TransferFunds(driver);
		FundTransferVerify ftv =  new FundTransferVerify(driver);
		FundTransferConfirmation ftc = new FundTransferConfirmation (driver);
		
		String[][] data = GenericMsg.getData("C:\\Users\\mmmta\\Desktop\\Qa Selenium\\Lab\\Selenium.xlsx", "Sheet1");
		for (int i = 1; i < data.length; i++) {
			hpg.clickSignin();
			lin.applicationLogin(data[i][0], data[i][1]);
			acSum.openTransferFunds();
			trFund.fundTransferApplication(data[i][2], data[i][3]);
			ftv.clickFundConfirmation();
			String actualMsg = ftc.verifyFundConfirmation();
			String expectedMsg = data[i][4];
			Assert.assertEquals(actualMsg, expectedMsg);
			ftc.logOutApp();
			
	}
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
