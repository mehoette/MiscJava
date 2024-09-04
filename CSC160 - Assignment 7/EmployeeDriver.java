/* **********************************
 CSC160
 Assignment 7 - EmployeeDriver.java
 Mary Hoette
 
 This is the driver for the Employee
 super class and the Hourly, Salaried
 and Salaried Plus Commission subclasses.
 
************************************/

import java.util.Scanner;
public class EmployeeDriver 
{
	public static void main(String args[])
	{
		//there's 2 instance variables, num of Employees and type of employee (1 for hourly, 2 for salaried, and 3 for salaried plus commission
		int numOfEmployees;
		int typeOfEmployee;
		
		
		Scanner stdIn = new Scanner(System.in);
	    
		//take input for the number of employees
		System.out.print("Number of Employees: ");
		numOfEmployees = stdIn.nextInt();
		
		//make an employees array with the number of employees specified before
		Employee[] employees = new Employee[numOfEmployees];
	    
		//for each employee ask for the type of employee, make the index that number, then load and get the earnings
	    for (int i=0; i<numOfEmployees; i++)
	    {
	    	System.out.println("\nPROFILE FOR EMPLOYEE #" + (i + 1) + ":");
	    	
	    	System.out.println("type Hourly(1), Salaried(2), Salaried plus Commission(3)");
			System.out.print("Enter 1, 2 or 3 ==> ");
			typeOfEmployee = stdIn.nextInt();
			
			//make an object in the index of the type specified
			if(typeOfEmployee == 1)
			{
				employees[i] = new Hourly();
			}//end if hourly
			else if (typeOfEmployee == 2)
			{
				employees[i] = new Salaried();
			}//end else if salaried
			else
			{
				employees[i] = new SalariedPlusCommission();
			}//end else (Salaried plus Commission)
				
			//load the employee's variables and then get their earnings.
	    	employees[i].load();
			employees[i].getEarnings();
			
	    }//end for
	    
	    //for each employee, print their data.
	    //the reason this is a seperate for loop from the one before is because this way you will input
	    //everything and then it will display the important stuff
	    System.out.println(); //this makes an extra empty line to break up the input section from the summary section.
	    for (int i=0; i<numOfEmployees; i++)
	    	System.out.println(employees[i].toString());
	}//end main
}//end EmployeeDriver