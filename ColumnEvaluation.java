/* **********************************
 CSC150
 Assignment 5 - Column Evaluation
 Mary Hoette
 
 Given the column width, column height,
 and expected load, this program will
 calculate if a column is safe or not.
************************************/

import java.util.Scanner;

public class ColumnEvaluation 
{
	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		//now it's asking for the column width and making the corresponding variable
		System.out.println("What is the column width in inches?");
		double columnWidth = stdIn.nextDouble();
		//now it's asking for the column height in inches and making the corresponding variable
		System.out.println("What is the column height in feet?"); 
		double columnHeightFeet = stdIn.nextDouble();
		// we asked for the height in feet but we need the height in inches, so  I'll convert it right here
		double columnHeightInches = columnHeightFeet * 12;
		//now it's asking for the weight of the expected load and making the corresponding variable
		System.out.println("How much does the expected load weigh in pounds?");
		double expectedLoad = stdIn.nextDouble();
		
		// some of the equations use the column area, so I will define it here.
		double columnArea = columnWidth * columnWidth;
		
		//Now I'm going to make booleans that say if the column is safe for each test
		boolean safeSlender = false;
		boolean safeBuckling = false;
		boolean safeCompressing = false;
		
		//now we're setting up the named constants.
		final double SLENDERNESS_LIMIT = 50;
		final double MODULUS_OF_ELASTICITY = 1700000;
		final double MAXIMUM_STRESS = 1450;
		
		//here I'm testing if the column is too slender. if it passes this test, safeSlender is set to true.
		if ((columnHeightInches/columnWidth) <= SLENDERNESS_LIMIT)
		{
			safeSlender = true;
			System.out.println((columnHeightInches/columnWidth) + " <= 50");
			System.out.println("safeSlender");
		}
		
		//here I'm testing if the column is at risk of buckling. if it is not at risk, safeBuckling is set to true.
		if (expectedLoad <= (0.3*MODULUS_OF_ELASTICITY*columnArea) / ((columnHeightInches/columnWidth)*(columnHeightInches/columnWidth)))
		{
			safeBuckling = true;
			System.out.println(expectedLoad + " <= " + (0.3*MODULUS_OF_ELASTICITY*(columnHeightInches*columnWidth)) / ((columnHeightInches/columnWidth)*(columnHeightInches/columnWidth)));
			System.out.println("safeBuckling");
		}
		
		//here I'm testing if the column is at risk of compressing. if it is not at risk, safe Compressing is set to true
		if (expectedLoad <= (columnArea*MAXIMUM_STRESS))
		{
			safeCompressing = true;
			System.out.println(expectedLoad + " <= " + (columnArea*MAXIMUM_STRESS));
			System.out.println("safeCompressing");
		}

		//if the column has passed all 3 tests from before, the column is saf4.0e.
		//if the column failed any of the tests above, the column is unsafe.
		if (safeSlender && safeBuckling && safeCompressing)
		{
			System.out.println("\nColumn is safe");
		}
		else
		{
			System.out.println("\nColumn is unsafe");
		}
	}// end main
}//end class