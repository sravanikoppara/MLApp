package com.app.moneylion.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.app.moneylion.Enum.Browser;
import com.app.moneylion.factory.BrowserProvider;
import com.app.moneylion.pages.MoneylionHomePage;

public class AccessingPagesTest {
	private WebDriver driver;
	@BeforeSuite
	public void initalize() {
		driver = BrowserProvider.createDriver(Browser.CHROME);
		driver.manage().window().maximize();
	}
	@Test
	public void accsessingAllPages()
	{
	MoneylionHomePage moneylionhomepage =new MoneylionHomePage(driver);
	driver.get("https://www.moneylion.com/");
	moneylionhomepage.hoverOnAbout();
	moneylionhomepage.navigateCarrierPage();
	
	}
	/**
	 * This method will be executed at the end of the test.
	 */
	@AfterSuite
	public void quitDriver() {
				if(driver != null) {
				driver.quit();
				}

	}
}
