/* **********************************
 CSC160
 Assignment 7 - Employee.java
 Mary Hoette
 
 This is the Employee
 super class which includes 
 
************************************/

//import LocalDate and Scanner for later use
import java.time.LocalDate;
import java.util.Scanner;

public abstract class Employee 
{
	//Instance variables include name, social security number, birthday month, birthday week, and paycheck
	protected String name;
	protected String socialSecurityNumber; //SSN is a String not an int so you can use dashes
	protected int birthdayMonth;
	protected int birthdayWeek;
	protected double paycheck; //this one wasn't specified in the assignment, but it made it easier to keep the total pay in one spot.
	
	//I also used the LocalDate API get the current week and month to compare for the birthday bonus later
	static LocalDate myDateObj = LocalDate.now();
	private static int week = (myDateObj.getDayOfMonth()/7 +1);
	private static int month = myDateObj.getMonthValue();
	
	Scanner stdIn = new Scanner(System.in);
	
	//this is a abstract method so it can be used in the subclasses.
	public abstract void getEarnings();
	
	public void load()
	{
		//prompt the users for input and then fill the variables
		System.out.print("Name ==> ");
		this.name = stdIn.next();
		System.out.print("Social security number ==> ");
		this.socialSecurityNumber = stdIn.next();
		System.out.print("Birthday month (1-12) ==> ");
		this.birthdayMonth = stdIn.nextInt();
		System.out.print("Birthday bonus week (1-4) ==> ");
		this.birthdayWeek = stdIn.nextInt();
		
		//if the birthday week and month match the current week and month add $100 to the paycheck
		if(week == this.birthdayWeek && month == this.birthdayMonth)
		{
			paycheck += 100;
		}
	}//end load
	
	//return the employee name, social security number and paycheck amount. do not print
	public String toString()
	{
		return ("employee: " + this.name + "\nsocial security number: " + this.socialSecurityNumber 
				+ "\npaycheck: $" + paycheck);
	}//end toString
	
	//add get bonus method
}//end Employee class
