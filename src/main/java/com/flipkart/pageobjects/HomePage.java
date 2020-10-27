package com.flipkart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(name = "q")
	public WebElement home_Search;


	@FindBy(xpath = "//*[@id='container']/div/div[2]/div/div/span[1]")
	public WebElement home_Electronic_MouseHover;
	
	
	@FindBy(xpath = "//table[@class = 'table table-hover']//tbody//tr[*]//td/text()")
	public WebElement tableData;
	
	//table[@class = 'table table-hover']//tbody//tr[1]/td[4]/text()
	
	//

	@FindBy(xpath = "//iframe[@class = 'demo-frame']")
	public WebElement seleniumIFrame;
	

	@FindBy(xpath = "//p[text() = 'Drag me to my target']")
	public WebElement seleniumIFrameGetText;
}
