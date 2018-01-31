package com.cleartrip.pom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PriceAndAvailabilityPage {
	
	private WebDriver driver;
	private HashMap<WebElement, String> priceList = new HashMap<WebElement, String>();
	private List<String> priceListAll = new ArrayList<String>();
	private By bookButton = By.xpath("//button[text()='Book']");
	private By bookingAmount = By.xpath("/h2[@class='totalAmount']");
	private By bookingPageText = By.xpath("//p[text()='Getting prices and availability...']");
	private Logger logger = Logger.getLogger(PriceAndAvailabilityPage.class.getName());
	
	public PriceAndAvailabilityPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitForBookingPage(int timeOut){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(bookingPageText));
		}catch(Exception e){
			logger.info("Error occured while redirecting to iternary page");
		}
	}
	
	public String selectToFlightsList(String fromCity, String toCity){
		try{
			List<WebElement> listOfToFlights = driver.findElements(By.xpath("//div[@data-fromto='"+fromCity+"_"+toCity+"']//th[6]"));
			for(WebElement element: listOfToFlights){
				priceList.put(element, element.getText());
				System.out.println(element.getText());
				priceListAll.add(element.getText());
			}
			Collections.sort(priceListAll);
			for(Map.Entry entry: priceList.entrySet()){
	            if(priceListAll.get(priceListAll.size()-2).equals(entry.getValue())){
	                WebElement flightSelect=(WebElement) entry.getKey();
	                System.out.println(flightSelect);
	                flightSelect.click();
	                break; //breaking because its one to one map
	            }
	        }
			logger.info("second"+priceListAll.get(priceListAll.size()-2));
		}catch(Exception e){
			System.out.println(e);
		}
		return priceListAll.get(priceListAll.size()-2);
	}
	
	public String selectFromFlightsList(String fromCity, String toCity){
		try{
			List<WebElement> listOfToFlights = driver.findElements(By.xpath("//div[@data-fromto='"+toCity+"_"+fromCity+"']//th[6]"));
			for(WebElement element: listOfToFlights){
				priceList.put(element, element.getText());
				System.out.println(element.getText());
				priceListAll.add(element.getText());
			}
			Collections.sort(priceListAll);
			for(String a : priceListAll){
				System.out.println("After sorting"+a);
			}
			for(Map.Entry entry: priceList.entrySet()){
	            if(priceListAll.get(priceListAll.size()-2).equals(entry.getValue())){
	                WebElement flightSelect=(WebElement) entry.getKey();
	                System.out.println(flightSelect);
	                flightSelect.click();
	                break; //breaking because its one to one map
	            }
	        }
			logger.info("second"+priceListAll.get(priceListAll.size()-2));
		}catch(Exception e){
			System.out.println(e);
		}
		return priceListAll.get(priceListAll.size()-2);
	}
	
	public String getBookingAmount(){
			return driver.findElement(bookingAmount).getText();
	}

	public void clickOnBook(){
		try{
			driver.findElement(bookButton).click();
		}catch(Exception e){
			logger.info("Error occured while clicking on the Book button");
		}
	}
}
