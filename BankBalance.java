/* **********************************
 CSC150
 Assignment 6 - Bank Balance
 Mary Hoette
 
 Given the beginning balance of a bank
 account, this program outputs after 
 how many years, the balance reaches 
 $100,000 and $1,000,000 if the balance 
 is doubled every year
 
************************************/

import java.util.Scanner;

public class BankBalance 
{

	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		
		//Here I'm setting up all my variables. I have the balance of the bank account,
		//the total years since the money was put in the account, and 2 boolean variables
		//for when you pass $100,000 and $1,000,000, so that it only prints that you have
		//passed those checkpoints once.
		System.out.println("What is the starting balance?");
		double balance = stdIn.nextDouble();
		int yearsTotal = 0;
		boolean passedHundredThousand = false;
		boolean passedMillion = false;
		
		//here is just my first attempt at writing this code and then I left it in
		/* **********************************
		for(double i = startingBalance; i <= 1000000; i = i*2)
		{
			yearsTotal ++;
			System.out.println(i + " after " + yearsTotal + " years");
			if (i == 100000)
				System.out.println("It takes " + yearsTotal + " years to reach $100,000");
			if (i >= 1000000)
				System.out.println("It takes " + yearsTotal + " years to reach $1,000,000");
		}//end for loop
		************************************/
		
		//this loop only needs to continue while the balance is under $1,000,000
		while (!passedMillion)
		{
			//this if statement prints how long it takes for the balance to be over $100,000
			//then it turns passedHundredThousand to false so it only prints that message once
			if (balance >= 100000 && !passedHundredThousand)
			{
				System.out.println("It takes " + yearsTotal + " years to reach $100,000.");
				passedHundredThousand = true;
			}//end first if
			
			//So this if statement prints once the balance is at least $1,000,000
			//then it turns passed Million to true which ends the while loop because now the customer can take out the money
			if (balance >= 1000000)
			{
				System.out.println("It takes " + yearsTotal + " years to reach $1,000,000.");
				passedMillion = true;
			}//end second if
			yearsTotal ++;
			balance = balance * 2;
			
		}//end while	
	}//end main
}//end class
