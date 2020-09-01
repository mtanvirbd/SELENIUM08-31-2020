package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFunds {
	
	@FindBy (id="tf_fromAccountId")
	private WebElement tfFromAcc;
	
	@FindBy (id="tf_toAccountId")
	private WebElement tfToAcc;
	
	@FindBy (id="tf_amount")
	private WebElement tfAmmount;
	
	@FindBy (id="tf_description")
	private WebElement tfDesc;
	
	@FindBy (id="btn_submit")
	private WebElement btnSubmit;
	
	public TransferFunds(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fundTransferApplication(String amount, String description) {
		Select tfFAc = new Select(tfFromAcc);
		tfFAc.selectByIndex(2);
		
		Select tftAcc = new Select(tfToAcc);
		tftAcc.selectByValue("3");
		
		tfAmmount.sendKeys(amount);
		tfDesc.sendKeys(description);
		btnSubmit.click();
	}

}
