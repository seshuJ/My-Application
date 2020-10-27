package com.flipkart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
	/* How to identify the elements
	 * 
	 *  Using locators:- How many locators are there in selenium
	 *  1  Id
	 *  2. name
	 *  3. Tagname
	 *  4. css selector
	 *  5. xpath
	 *  6. link text
	 *  7. partial link text
	 *  8. class name
	 *  9. Relativelocators*/
	
	
	@FindBy(xpath = "//a[text() = 'New to Flipkart? Create an account']")
	public WebElement login_CreateAnAccount;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	public WebElement login_MobileNumbert;
	
	
	@FindBy(xpath = "//button[text() = '✕']")
	public WebElement login_CloseLoginPopup;
	
	@FindBy(id = "uploadfile_0")
	public WebElement fileUpload;
	
	

}
