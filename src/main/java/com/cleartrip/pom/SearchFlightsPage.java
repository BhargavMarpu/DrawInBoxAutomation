package com.cleartrip.pom;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchFlightsPage {

	private WebDriver driver;
	private By roundTripRadioButton = By.xpath("//input[@id='RoundTrip']");
	private By fromCityTag = By.xpath("//input[@id='FromTag']");
	private By toCityTag = By.xpath(".//input[@id='ToTag']");
	private By datePicker = By.xpath(".//div[@id='ui-datepicker-div']");
	private By adultDropDown = By.xpath(".//select[@id='Adults']");
	private By childrenDropDown = By.xpath(".//select[@id='Childrens']");
	private By searchButton = By.xpath("//input[@id='SearchBtn']");
	private Logger logger = Logger.getLogger(SearchFlightsPage.class.getName());
	private int day;
	
	public SearchFlightsPage(WebDriver driver){
        this.driver = driver;
    }
	
	public void clickOnRoundTrip(){
		try{
			driver.findElement(roundTripRadioButton).click();
			logger.info("Clicked on round trip radio button");
		}catch(Exception e){
			logger.info("Error on retriving the round trip radio element :"+e);
		}
	}
	
	public void enterFromCity(String fromCity){
		try{
			driver.findElement(fromCityTag).clear();
			driver.findElement(fromCityTag).sendKeys(fromCity);
			logger.info("From City entered");
		}catch(Exception e){
			logger.info("Error on retriving the From city element :"+e);
		}
	}
	
	public void selectFromCity(String fromCity){
		try{
			if(driver.findElement(By.xpath(".//a[text()='"+fromCity+"']")).isDisplayed()){
				driver.findElement(By.xpath(".//a[text()='"+fromCity+"']")).click();
				logger.info("From City selected");
			}
		}catch(Exception e){
			logger.info("Error on selecting the From city element :"+e);
		}
	}
	
	public void enterToCity(String toCity){
		try{
			driver.findElement(toCityTag).clear();
			driver.findElement(toCityTag).sendKeys(toCity);
			logger.info("To City entered");
		}catch(Exception e){
			logger.info("Error on retriving the To city element :"+e);
		}
	}
	
	public void selectToCity(String toCity){
		try{
			if(driver.findElement(By.xpath(".//a[text()='"+toCity+"']")).isDisplayed()){
				driver.findElement(By.xpath(".//a[text()='"+toCity+"']")).click();
				logger.info("Destimation City entered");
			}
		}catch(Exception e){
			logger.info("Error on retriving the Destimation city element :"+e);
		}
	}
	
	public void toDatePickerDialog(String[] toDate){
		try{
			day = Integer.parseInt(toDate[1].replaceAll("0", ""))-1;
			if(driver.findElement(datePicker).isDisplayed()){
				logger.info("To Date picker dialog appeared");
				driver.findElement(By.xpath(".//td[@data-month='"+day+
						"' and @data-year ='"+toDate[0]+"']/a[text()='"+toDate[2].replaceAll("0", "")+"']")).click();
				System.out.println(".//td[@data-month='"+toDate[1].replaceAll("0", "")+
						"' and @data-year ='"+toDate[0]+"']/a[text()='"+toDate[2].replaceAll("0", "")+"']");
			}
		}catch(Exception e){
			logger.info("Exception occured while selecting the to date: "+e);
		}
	}
	
	public void fromDatePickerDialog(String[] fromDate){
		try{
			day = Integer.parseInt(fromDate[1].replaceAll("0", ""))-1;
			if(driver.findElement(datePicker).isDisplayed()){
				logger.info("To Date picker dialog appeared");
				driver.findElement(By.xpath(".//td[@data-month='"+day+
						"' and @data-year ='"+fromDate[0]+"']/a[text()='"+fromDate[2].replaceAll("0", "")+"']")).click();
				System.out.println(".//td[@data-month='"+fromDate[1].replaceAll("0", "")+
						"' and @data-year ='"+fromDate[0]+"']/a[text()='"+fromDate[2].replaceAll("0", "")+"']");
			}
		}catch(Exception e){
			logger.info("Exception occured while selecting the to date: "+e);
		}
	}
	
	public void selectAdultDropDown(String noOfAdults){
		Select numberOfAdults = new Select(driver.findElement(adultDropDown));
		numberOfAdults.selectByValue(noOfAdults);
		logger.info("Number of Adults selected");
	}
	
	public void selectChildrenDropDown(String noOfChildren){
		Select numberOfAdults = new Select(driver.findElement(childrenDropDown));
		numberOfAdults.selectByValue(noOfChildren);
		logger.info("Number of Children selected");
	}
	
	public void clickSearchFlights(){
		try{
			driver.findElement(searchButton).click();
			logger.info("Clicked on Search Flights Button");
		}catch(Exception e){
			logger.info("Expetion occured while clicking on Search Flights button: "+e);
		}
	}
}
