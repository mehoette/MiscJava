/* **********************************
 CSC160
 Assignment 7 - Salaried.java
 Mary Hoette
 
 This is the Salaried subclass 
 
************************************/

import java.util.Scanner;
public class Salaried extends Employee
{
	protected double weeklySalary;
	Scanner stdIn = new Scanner(System.in);
	
	//this prompts the load method from the superclass and prompts and fill the instance variables from this subclass
	public void load()
	{
		super.load();
		System.out.print("Salary ==> ");
		this.weeklySalary = stdIn.nextDouble();
	}//end load

	//the getEarnings method calculates the amount the worker made this week.
	public void getEarnings() 
	{
		//because the Salary worker gets their salary regardless of hours worked, just set paycheck to weeklySalary
		super.paycheck += this.weeklySalary;
	}//end get Earnings
}//end Salaried