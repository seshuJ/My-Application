package com.flipkart;

import org.testng.annotations.Test;

import com.flipkart.browser.Base;
import com.flipkart.pageobjects.HomePage;
import com.flipkart.script.ElectronicsScript;
import com.flipkart.script.HomePageScript;
import com.flipkart.script.LoginScript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Login2 extends Base{

	LoginScript loginscript = null;

	HomePageScript homeScript = null;

	ElectronicsScript electronics = null;

	public 	WebDriver driver = null;

	@BeforeMethod
	public void launchReuirements(){

		driver = launchBrowser();

		loginscript = new LoginScript(driver);

		homeScript = new HomePageScript(driver);

		electronics = new ElectronicsScript(driver);


	}


	@Test
	public void loginFlipkart() throws InterruptedException {

		/*
		 * loginscript.login();
		 * 
		 * homeScript.homePageGloblSearch("Mobiles");
		 */

		loginscript.uploadFile();

	}
	

	@Test(enabled = false)
	public void electronics() throws InterruptedException {

		loginscript.login();

		Thread.sleep(3000);

		homeScript.homePageMouseHoverElectronics();

		electronics.electronics_Mobiles();


	}

	@Test(enabled = false)
	public void electronics_ContextClick() throws InterruptedException, AWTException {

		loginscript.login();

		Thread.sleep(3000);

		homeScript.homePageMouseHoverElectronics();

		electronics.electronics_MobilesOpenInNewTab();


	}

	@Test(enabled = false)
	public void iFrameExample() throws InterruptedException, AWTException {


		//loginscript.login();

		Thread.sleep(3000);

		homeScript.switchToFramePractice();

	}




	@AfterMethod
	public void tearDown() {

			closeBrowser();

	}




}
