package com.drawinbox.clearTrip;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cleartrip.helperutils.DateParser;
import com.cleartrip.helperutils.GetPriceList;
import com.cleartrip.pom.IternanryPage;
import com.cleartrip.pom.PriceAndAvailabilityPage;
import com.cleartrip.pom.SearchFlightsPage;
import com.cleartrip.utils.WaitUtils;


public class ClearTripTest {
	
	private WebDriver driver;
	private String clearTripUrl = "www.cleartrip.com";
	private String expectedTitle = "Cleartrip - Flights, Hotels, Local, Trains, Packages";
	private String fromCityText = "MAA";
	private String toCityText = "HYD";
	private String fromCity = "Chennai, IN - Chennai Airport (MAA)";
	private String toCity = "Hyderabad, IN - Rajiv Gandhi International (HYD)";
	private String noOfAdults = "2";
	private String noOfChildren = "2";
	private Logger logger = Logger.getLogger(ClearTripTest.class.getName());
	private SearchFlightsPage searchFlightsPage;
	private WaitUtils waitUtils;
	private DateParser dateParser;
	private PriceAndAvailabilityPage priceAndAvailabilityPage;
	private GetPriceList getPriceList = new GetPriceList();
	private String toPrice;
	private String fromPrice;
	private Object bookingAmount;
	private IternanryPage iternanryPage;
	
	@BeforeClass
	public void setUp(){
		dateParser = new DateParser();
		System.setProperty("webdriver.ie.driver", "C:\\Users\\bmarpu\\Downloads\\IEDriverServer_x64_2.53.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		waitUtils = new WaitUtils(driver);
		searchFlightsPage = new SearchFlightsPage(driver);
		priceAndAvailabilityPage = new PriceAndAvailabilityPage(driver);
		iternanryPage = new IternanryPage(driver);
		driver.get(clearTripUrl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void sample(){
		waitUtils.waitForPageTitle(expectedTitle, 20);
		searchFlightsPage.clickOnRoundTrip();
		searchFlightsPage.enterFromCity(fromCityText);
		searchFlightsPage.selectFromCity(fromCity);
		searchFlightsPage.enterToCity(toCityText);
		searchFlightsPage.selectToCity(toCity);
		searchFlightsPage.toDatePickerDialog(dateParser.parseToDate());
		searchFlightsPage.fromDatePickerDialog(dateParser.parseFromDate());
		searchFlightsPage.selectAdultDropDown(noOfAdults);
		searchFlightsPage.selectChildrenDropDown(noOfChildren);
		searchFlightsPage.clickSearchFlights();
		waitUtils.waitForDomChanges();
		priceAndAvailabilityPage.waitForBookingPage(20000);
		toPrice=priceAndAvailabilityPage.selectToFlightsList(fromCityText, toCityText);
		fromPrice=priceAndAvailabilityPage.selectFromFlightsList(toCityText, fromCityText);
		bookingAmount=priceAndAvailabilityPage.getBookingAmount();
		priceAndAvailabilityPage.clickOnBook();
		iternanryPage.waitforIternaryPage(10000);
		Assert.assertEquals(iternanryPage.getBookingAmount(), bookingAmount);
	}
}
