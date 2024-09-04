/* **********************************
 CSC160
 Assignment 7 - SalariedPlusCommission.java
 Mary Hoette
 
 This is the SalariedPlusCommission
 subclass
 
************************************/

import java.util.Scanner;
public class SalariedPlusCommission extends Salaried
{
	private double weeklySales;
	private double commissionRate;
	Scanner stdIn = new Scanner(System.in);
	
	//this prompts the load method from the superclass and prompts and fill the instance variables from this subclass
	public void load()
	{
		super.load();
		System.out.print("Sales for this past week ==> ");
		this.weeklySales = stdIn.nextDouble();
		System.out.println("Sales commission rate (fraction paid to employee) ==>");
		this.commissionRate = stdIn.nextDouble();
	}//end load
	
	//the getEarnings method calculates the amount the worker made this week.
	public void getEarnings()
	{
		//the salaryPlusCommissions gets their weeklySalary plus weeklySales time commissionRate
		super.paycheck += (super.weeklySalary + (weeklySales * commissionRate));
	}//end getEarnings
}//end SlariedPlusCommission