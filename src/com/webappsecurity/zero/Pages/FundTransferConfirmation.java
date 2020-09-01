package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferConfirmation {
	@FindBy (css="#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement fundconfirmation;
	
	@FindBy (css= "#settingsBox > ul > li:nth-child(3) > a")
	private WebElement userName;
	
	@FindBy (css="#logout_link")
	private WebElement logOut;
	
	public FundTransferConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyFundConfirmation() {
		String confirmationMsg = fundconfirmation.getText();
		return confirmationMsg;
	}
	
	public void logOutApp() {
		userName.click();
		logOut.click();
	}
	

}
