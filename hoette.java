/* *********************************
 CSC160
 Assignment 5
 Mary Hoette
 
This program uses bitwise operators
to generate a list of all power of 2
numbers from +128 to -128 and displays
the binary for a user inputed integer
 
************************************/
import java.util.Scanner;//import the scanner

public class hoette 
{

	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		int number = 128;
		
		while (number >= -128)
		{
			display(number); //send the number to the display method to print the number and the binary equivalent. 
			if (number > 0) // if the number is greater than zero, shift it one place to the right
			{
				number >>= 1;
			}//end if
			else if (number == 0) // if it is 0, find it's complement (-1)
			{
				number = ~number;
			}//end else if
			else //if number is negative, shift it one place to the left
			{
				number <<= 1;
			}//end else
			
			
		}//end while
		
		//now the user is prompted to input a number and it will be printed along with its binary equivalent
		System.out.println("input a number: ");
		number = stdIn.nextInt();
		display(number);
		
	}//end main
	
	public static void display (int num)
	{
		System.out.print(num + "\t");//print the plain number and a tab
		
		//make a mask with the value 1 and shift it 31 bits to the left making it 32 bits long
		long mask = 1L;
		mask <<= 31;
		int bitCounter = 0;//every time the bit counter gets to 4, it prints a space and then is reset.
		
		//this for loop goes 32 times for each bit in mask
		for(int i = 1; i <= 32; i++)
		{
			//if the num bit is 1 print 1
			if ((mask & num) !=0)
			{
				System.out.print("1");
			}//end if
			else // if it is 0 print 0
			{
				System.out.print("0");
			}//end else
			
			mask >>= 1; //then shift one digit to the right after printing a bit to get a new bit to print.
			
			
			bitCounter++; //after every bit add 1 to bit counter
			if (bitCounter == 4)//if the bit counter gets to 4, it prints a space and then resets.
			{
				System.out.print(" ");
				bitCounter = 0;
			}//end if
		}//end for loop
		System.out.println(""); //just making a new line at after after display has been run.
	}//end display
	
}//end class
