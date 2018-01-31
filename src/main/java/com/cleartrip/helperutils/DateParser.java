package com.cleartrip.helperutils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.LocalDate;

public class DateParser {

	private Date date = new Date();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public String[] parseToDate(){
		String currentDate = dateFormat.format(date);
		LocalDate dateLocal = LocalDate.parse(currentDate);
		return dateLocal.plusDays(2).toString().split("-");
	}
	
	public String[] parseFromDate(){
		String currentDate = dateFormat.format(date);
		LocalDate dateLocal = LocalDate.parse(currentDate);
		return dateLocal.plusDays(4).toString().split("-");
	}
}
