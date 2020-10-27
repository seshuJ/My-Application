package com.flipkart.browser;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {


	/* Maven is a Buld which is used to manage the project infrastructer. */


	//public static WebDriver driver;
	
	public static WebDriver driver = null;
	
	private WebDriverWait wait;

	public String parentWindow = null;

	public WebDriver launchBrowser() {
		
		/*
		 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("start-maximized");
		 * options.addArguments("--disable-popup-blocking");
		 * options.addArguments("--disable-default-apps");
		 * options.addArguments("--disable-inforbars");
		 * 
		 * capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 */
		ChromeDriver driver = new ChromeDriver();

		//setup the chromedriver using WebDriverManager
		WebDriverManager.chromedriver().setup();


		driver = new ChromeDriver();

		windowMaximize();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);


		windowResize();
		

		/* driver.get("https://www.flipkart.com/"); */

		/* driver.get("https://jqueryui.com/droppable/"); */

		driver.get("http://demo.guru99.com/test/upload/"); 
		
		windowMaximize();

		return driver;
	}

	public void closeBrowser() {

		driver.close();

	}

	public void waitForElementToBeClickable(By element) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofMillis(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}

	public void mouseHoverOnWebElement(WebElement element) {

		Actions	action = new Actions(driver);

		action.moveToElement(element).build().perform();

	}

	public void doubleClickOnWebElement(WebElement element) {

		Actions	action = new Actions(driver);

		action.doubleClick(element).build().perform();

	}

	public void contextClickOnWebElement(WebElement element) throws AWTException {

		Actions	action = new Actions(driver);

		action.contextClick(element).build().perform();
		/*.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ENTER).build().perform();*/


		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);



	}

	public void switchToWindow() {


		parentWindow	= driver.getWindowHandle();

		System.out.println("************" + parentWindow);

		Set<String>	Window	= driver.getWindowHandles();

		for (String eachWindowID : Window) {

			if (!eachWindowID.equalsIgnoreCase(parentWindow)) {

				driver.switchTo().window(eachWindowID);


				System.out.println(eachWindowID.toString());

			}

		}

	}

	public void switchToFrame(WebElement  frameElement) {


		driver.switchTo().frame(frameElement);


	}

	public void windowResize() {

		Dimension dm = new Dimension(40, 69);

		driver.manage().window().setSize(dm);
	}

	public void windowMaximize() {

		driver.manage().window().maximize();

	}
}
