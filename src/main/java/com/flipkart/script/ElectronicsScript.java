package com.flipkart.script;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.browser.Base;
import com.flipkart.pageobjects.LoginPage;
import com.flipkart.pageobjects.MobilesPage;

public class ElectronicsScript {

	MobilesPage mobiles = null;
	
	Base base = new Base();

	public ElectronicsScript(WebDriver driver) {

		mobiles = PageFactory.initElements(driver, MobilesPage.class);

	}


	public void electronics_Mobiles() {

		mobiles.home_Electronics_Oppo_Click.click();
	}

	public void electronics_MobilesOpenInNewTab() throws AWTException {

		
		base.contextClickOnWebElement(mobiles.home_Electronics_Oppo_Click);
		
		base.switchToWindow();
	}

}
