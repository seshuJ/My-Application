package com.flipkart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilesPage {

	
	@FindBy(xpath = "//a[text() = 'OPPO']")
	public WebElement home_Electronics_Oppo_Click;
	
}
