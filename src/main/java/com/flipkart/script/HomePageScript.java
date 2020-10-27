package com.flipkart.script;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.browser.Base;
import com.flipkart.pageobjects.HomePage;

public class HomePageScript {


	HomePage homePage = null;

	Base base = new Base();

	public HomePageScript(WebDriver driver) {

		homePage = PageFactory.initElements(driver, HomePage.class);

	}

	public void homePageGloblSearch(String enterSearchableValue) {


		homePage.home_Search.sendKeys(enterSearchableValue + Keys.ENTER);


	}

	public void homePageMouseHoverElectronics() {

		base.mouseHoverOnWebElement(homePage.home_Electronic_MouseHover);

	}

	public void switchToFramePractice() {



		base.switchToFrame(homePage.seleniumIFrame);


		String	frameText = homePage.seleniumIFrameGetText.getText();
		
		System.out.println(frameText);



	}

}
