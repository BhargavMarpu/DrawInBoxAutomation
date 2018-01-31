package com.cleartrip.pom;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IternanryPage {

	private WebDriver driver;
	private By iternaryText = By.xpath("//h2[text()=' Itinerary']");
	private By bookingAmount = By.xpath(" .//span[@id='counter']");
	private Logger logger = Logger.getLogger(IternanryPage.class.getName());
	
	public IternanryPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitforIternaryPage(int timeOut){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(iternaryText));
		}catch(Exception e){
			logger.info("Error occured while redirecting to iternary page");
		}
		
	}
	
	public String getBookingAmount(){
		return driver.findElement(bookingAmount).getText();
	}
	
}
