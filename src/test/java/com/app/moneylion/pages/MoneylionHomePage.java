package com.app.moneylion.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.moneylion.utils.SeleniumUtils;

public class MoneylionHomePage extends PagBase {
	private WebDriver driver;
	private String aboutUs = "//a[normalize-space()='About us']";
	private String careerContainer= "//div[contains(@class,'position_--position-relative__rCDIW View_--flex__b6XCB View_--direction-column__jGJFN View_--direction-row--m__lldAx View_item--grow__gzJvu')]";
	private String career = "//a[normalize-space()='Careers']";////span[normalize-space()='Careers']
	private String whereToWork= "(//div[@class='wp-block-group__inner-container'])[16]";

	/**
	 * Constructor of the page. Initialize the Page Factory objects.
	 * 
	 * @param driver
	 */
	public MoneylionHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;// Call the superclass constructor with WebDriver
	}
	public WebElement getElementAtPoint(WebDriver driver, int x, int y) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    return (WebElement) js.executeScript("return document.elementFromPoint(arguments[0], arguments[1]);", x, y);
	}
	public void navigateCarrierPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
		WebElement basefloatingContainer = SeleniumUtils.findElement(driver, careerContainer);
		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", basefloatingContainer);
		basefloatingContainer.findElement(By.xpath(career)).click();

		
		    //element.click();
		// SeleniumUtils.waitForElementToBeClickable(driver, career).click();	 
		 WebElement whrToWork =SeleniumUtils.waitForElementToBeVisible(driver, whereToWork);
				 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",whrToWork);
		
		try {
			
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", whrToWork);
		}
	}

	public void hoverOnAbout() {
		try {
			WebElement aboutUsLink = SeleniumUtils.waitForElementToBeClickable(driver, aboutUs);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutUsLink);
			Actions actions = new Actions(driver);
			// Perform hover action on the "About us" link
			actions.moveToElement(aboutUsLink).perform();
			// Optionally, wait or verify the hover effect
			Thread.sleep(2000); // Wait 2 seconds to observe the hover effect
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
