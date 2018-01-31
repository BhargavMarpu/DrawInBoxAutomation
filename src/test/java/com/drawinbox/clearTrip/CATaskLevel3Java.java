package com.drawinbox.clearTrip;

public class CATaskLevel3Java {
	
	int first = 0;
	int second = 1;
	int third;
	int count = 0;
	
	public void fiboanciSeries(int num1, int num2){
		first = num1;
		second = num2;
		third = first+second;
		System.out.print(third+",");
		count++;
		if(count<8)
			fiboanciSeries(second, third);
		
		
	}
	
	public static void main(String args[]){
		System.out.print("0,1,");
		CATaskLevel3Java caObj = new CATaskLevel3Java();
		caObj.fiboanciSeries(0,1);
	}

}
