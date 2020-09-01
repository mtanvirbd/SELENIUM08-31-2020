package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(id="user_login")
	private WebElement userId;

	@FindBy(id="user_password")
	private WebElement uPassword;

	@FindBy(name="submit")
	private WebElement submitBtn;

	@FindBy(css="#login_form > div.alert.alert-error")
	private WebElement errorMsg;

	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void applicationLogin(String userName,String userPassword) {
		userId.sendKeys(userName);
		uPassword.sendKeys(userPassword);
		submitBtn.click();
	}
	
	public String errormsgVerify() {
		String errorMessage = errorMsg.getText();
		return errorMessage;
	}
}
