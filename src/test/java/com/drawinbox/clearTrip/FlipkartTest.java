package com.drawinbox.clearTrip;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartTest {
	
	static String closeButton = "//button[@class='_2AkmmA _29YdH8']";
	static String searchBox = "//input[@title='Search for Products, Brands and More']";
	static String submitButton = "//button[@type='submit']";
	static String book = "//img[@alt='One Indian Girl']";
	static String buy = "//button[text()='Buy']";
	static String myCart = "//span[contains(text(),'My Cart ')]";
	static String removeButton = "//span[text()='Remove']";
	
	public static void main(String args[]){
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmarpu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		try{
			driver.findElement(By.xpath(closeButton)).click();
		}catch(Exception e){
			System.out.println("Close button not displayed!!");
		}
		driver.findElement(By.xpath(searchBox)).sendKeys("Book");
		driver.findElement(By.xpath(submitButton)).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(book)));
		driver.findElement(By.xpath(book)).click();
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(buy)).click();
		String cartCount = driver.findElement(By.xpath(myCart)).getText();
		System.out.println(cartCount);
		driver.findElement(By.xpath(removeButton)).click();
	}

}
