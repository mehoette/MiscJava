/* *********************************
 CSC160
 Assignment 2
 Mary Hoette
 
This is is the driver class for HwScore 
 
************************************/

import java.util.Scanner;
public class HwScoreDriver 
{
	public static void main (String args[])
	{
		Scanner stdIn = new Scanner(System.in);
		
		//here I'm making objects hw 1-4 and giving them the earned and possible points outlined in the assignment
		HwScore hw1 = new HwScore (26.5, 30.0);
		HwScore hw2 = new HwScore (29.0, 27.5);
		HwScore hw3 = new HwScore (0.0, 20);
		HwScore hw4 = new HwScore (16.0, 20.0);
		
		hw1.printGrade();
		hw2.printGrade();
		hw3.printGrade();
	
		HwScore.printTotalGrade();
	}//end main
	
	
}//end class
	

