package com.flipkart.script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.pageobjects.LoginPage;

public class LoginScript {

	LoginPage loginPage = null;
	
	public LoginScript(WebDriver driver) {
		
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	
	public void login() {
		
		
		loginPage.login_CloseLoginPopup.click();
		
		
	}
	
	
	public void uploadFile() {
		
		loginPage.fileUpload.sendKeys("C:\\Users\\Sahithi Tella\\Pictures\\Capture.PNG");
		
	}
}
