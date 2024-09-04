/* **********************************
 CSC160
 Assignment 7 - Hourly.java
 Mary Hoette
 
 This is the Hourly subclass 
 
************************************/

import java.util.Scanner;
public class Hourly extends Employee
{
	//instance variables include hourly pay and hours work that week
	private double hourlyPay;
	private double hoursWorked;
	Scanner stdIn = new Scanner(System.in);
	
	//this prompts the load method from the superclass and prompts and fill the instance variables from this subclass
	public void load()
	{
		super.load();
		System.out.print("Hourly pay ==> ");
		this.hourlyPay = stdIn.nextDouble();
		System.out.print("Hours worked this past week ==> ");
		this.hoursWorked = stdIn.nextDouble();
	}//end load
	
	//the getEarnings method calculates the amount the worker made this week.
	public void getEarnings()
	{
		//if the employee worked overtime (over 40 hours that week)
		if (hoursWorked > 40)
		{
			//make a variable for the number of overtime hours worked
			double overtimeHours = hoursWorked - 40;
			//multiply the number of overtime hours by 1.5, add them to the 40 (the number of non overtime hours) and multiply them by hourly pay
			super.paycheck += (((overtimeHours * 1.5) + 40) * hourlyPay);
		}//end if
		else
			//if they didn't work overtime, just multiply the number of hours by the hourly pay
			super.paycheck += hoursWorked*hourlyPay;
	}//end get Earnings
}//end Hourly class