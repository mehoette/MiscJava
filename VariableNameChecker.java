
/* **********************************
 CSC150
 Assignment 8
 Mary Hoette
 
This program has the user input a
possible variable name and returns
if the variable name is illegal,
legal with bad syntax or a good
variable name
 
************************************/

import java.util.Scanner;

public class VariableNameChecker
{
	
	public static void main (String [] args)
	{
		String varName;
		boolean keepGoing = true;
		
		Scanner stdIn = new Scanner (System.in);
		do
		{
			System.out.println("Enter a variable name (Enter Q to quit)");
			varName = stdIn.nextLine(); //this is the input for the variable name they want to test
			if (varName.equalsIgnoreCase("q")) // if the user inputs Q to quit, this if statement will trigger and end the do while loop.
			{
				keepGoing = false;
				System.out.println("End");
				break;
			}
			//Next 2 methods will be called, Variable Checker and Syntax Checker with will respond with boolean variables.
			boolean valid = VariableChecker(varName); //this method checks to see if the input is valid and the code will still run
			boolean goodSyntax = SyntaxChecker(varName); //this method checks the syntax of the variable. I
			if (valid) // if the method Variable checker comes back true, then there are 2 different outcomes depending on the return of the Syntax Checker	
			{
				if (goodSyntax)
					System.out.println("Good");
				else
					System.out.println("Valid but poor syntax");
			}//end if
			else //if the method variable checker isn't true, the syntax doesn't matter because it won't run either way
			{
				System.out.println("invalid");
			}//end else
			System.out.println("");
		}while(keepGoing); //this will continue until it stops when the user inputs q to quit
	}// end main
	public static boolean VariableChecker(String varName) //This method checks to see if the variable name is Valid
	{
		int validDigits = 0; //this looks counts each valid digit to later compare the number of valid digits to the total number of digits to make sure they are equal	
		int varLength = varName.length();
		if (!Character.isLetter(varName.charAt(0)))
			return false;
		for (int i = 0; i < varLength; i++)
		{
			String digitStr = varName.substring(i,i+1); //This is the digit we're looking at in string form so I can use string methods
			//This increases the number of valid digits by one if the digit is either a number, a letter, a dollar sign or an underscore
			if (Character.isLetterOrDigit(varName.charAt(i)) || digitStr.equals("$") || digitStr.equals("_"))
				validDigits++;
			
		}//end for
		//if the length of the variable equals the number of valid digits (which just means if every digit is valid) the method returns true. If not, it returns false.
		if (varLength == validDigits)
			return true;
		else
			return false;
	}//end variableChecker
	
	public static boolean SyntaxChecker(String varName) //This method checks to see if the variable name uses proper syntax
	{
		int weirdDigits = 0; //so the dollar sign and underscore are valid characters, but they they don't look good, and they aren't proper syntax so we have to count those
		int varLength = varName.length();
		for (int i = 0; i < varLength; i++)
		{
			String digitStr = varName.substring(i,i+1); //This is the digit we're looking at in string form so I can use string methods
			//basically we're just going through every character and seeing if it is either $ or _ and if it is, weird digits goes up 1
			if (digitStr.equals("$") || digitStr.equals("_"))
			{
				weirdDigits++;
			}	
		}//end for
		//and then here if there are any weird digits or if the first character isn't a lower case letter (which is another syntax rule) the method returns false
		if (!Character.isLowerCase(varName.charAt(0)) || weirdDigits > 0)
			return false;
		else //if there are no syntax errors, the method returns true
			return true;
	}//end SyntaxChecker
} // end class