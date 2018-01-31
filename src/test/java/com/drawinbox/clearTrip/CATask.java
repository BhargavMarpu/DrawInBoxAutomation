package com.drawinbox.clearTrip;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CATask {

	private WebDriver driver;
	private List<WebElement> rows;
	private String subject1;
	private String subject2;
	private String total;
	private int actual;
	private String student;
	
	public void getStudentDetails(){
		driver = new FirefoxDriver();
		driver.get("Application url");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		rows = driver.findElements(By.xpath("//table[@id='']//tr"));
//		driver.findElements(By.xpath("//table//tr//td[1]"));
		for(WebElement row: rows){
			student = row.findElement(By.xpath("//td[1]")).getText();
			subject1 = row.findElement(By.xpath("//td[2]")).getText();
			subject2 = row.findElement(By.xpath("//td[3]")).getText();
			actual = checkDifference(subject1, subject2);
			total = row.findElement(By.xpath("//td[4]")).getText();
			if(Integer.toString(actual).equals(total))
				System.out.println("Total count matches for the stuudent :: "+student);
			else
				System.out.println("Total count does not matches for the stuudent :: "+student);
		}
	}
	
	int checkDifference(String sub1, String sub2){
		return Integer.parseInt(sub1)+Integer.parseInt(sub2);
	}
	
	public static void main(String args[]){
		CATask caTask = new CATask();
		caTask.getStudentDetails();
	}
}
