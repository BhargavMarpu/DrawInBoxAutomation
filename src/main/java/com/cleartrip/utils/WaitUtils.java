package com.cleartrip.utils;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private WebDriver driver;
	private Logger logger = Logger.getLogger(WaitUtils.class.getName());
	private int count=0;

	public WaitUtils(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitForPageTitle(String expectedTitle, int timeOut){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.titleContains(expectedTitle));
			logger.info("Web title Displayed as Expected: "+driver.getTitle());
		}catch(Exception e){
			logger.info("Error occured. Title Not Displayed");
		}
	}
	
	public void waitForDomChanges(){
		String oldPage = driver.getPageSource();
		String newPage = driver.getPageSource();
		while(oldPage!=newPage && count<10){
			newPage = driver.getPageSource();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			count++;
		}
	}
}
