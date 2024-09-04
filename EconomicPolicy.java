
/* **********************************
 CSC150
 Assignment 4 - EconomicPolicy.java
 Mary Hoette
 
 This program give advice for changes
 in economic policy given the growth
 rate of a company and the inflation
 rate of currency.
************************************/

import java.util.Scanner;

public class EconomicPolicy 
{

	public static void main(String[] args)
	{
		// here I'm setting up the scanner and getting the percentage for both Growth and inflation rate
		Scanner stdIn = new Scanner(System.in);
		System.out.println("Enter Percent Growth Rate");
		Double growthRate = stdIn.nextDouble();
		System.out.println("Enter Percent Inflation Rate");
		Double inflation = stdIn.nextDouble();
		
		// Now I'm starting the nested if statement basically the first thing it looks at is if the growth
		// rate is less than 1, greater than 4 or neither
		if (growthRate < 1)
		{
			// if the growth rate is less than 1 percent, it tests to see if inflation is less than 3
			// depending on these results it will print out a different suggestion
			if (inflation < 3)
				System.out.println("Increase welfare spending, reduce personal taxes, and decrease discount rate");
			else
				System.out.println("Reduce business taxes.");
		}
		else if(growthRate > 4)
		{
			// if the growth rate is less than 4 percent, it tests to see if inflation is less than 1 or 
			//greater than 3 or neither. depending on these results it will print out a different suggestion
			if (inflation < 1)
				System.out.println("Increase personal and business taxes, and decrease discount rate.");
			else if (inflation > 3)
				System.out.println("Increase discount rate");
			else
				System.out.println("No change in economic policy.");
		}
		else
			//if if the growth rate is between 1 and 4, the system will print that no change is necessary
			System.out.println("No change in economic policy.");
	}
}
