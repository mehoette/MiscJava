/****************************************
* RainFall.java
* Assignment 10
* Mary Hoette
* CSC150
*
*This takers an array of the year's rainfall
*data  and passes it onto several methods to
*calculate the total rainfall for the year,
*the average rain fall for the year, the
*month with the highest rainfall for the year
*and the month with the lowest rainfall for this year
*
****************************************/

public class RainFall 
{

	public static void main(String[] args)
	{
		// Array with this year's rainfall data
		double[] thisYear = {1.6, 2.1, 1.7, 3.5, 2.6, 3.7, 3.9, 2.6, 2.9, 4.3, 2.4, 3.7 };
		int high; // To hold the month with the highest amount
		int low; // To hold the month with the lowest amount


		// Display the total rainfall.
		System.out.println("The total rainfall for this year is " + getTotalRainFall(thisYear));

		// Display the average rainfall.
		System.out.println("The average rainfall for this year is " + getAverageRainFall(thisYear));

		// Get and display the month with the highest rainfall.
		high = getHighestMonth(thisYear);
		System.out.println("The month with the highest amount of rain is " + (high+1) + " with " + thisYear[high] + " inches.");

		// Get and display the month with the lowest rainfall.
		low = getLowestMonth(thisYear);
		System.out.println("The month with the highest amount of rain is " + (low+1) + " with " + thisYear[low] + " inches.");
	}//end main

	public static double getTotalRainFall(double[] arr1)
	{
		//it goes through each number in the array and adds them together before returning the total
		int arrayLength = arr1.length;
		double totalRainFall = 0;
		for(int i = 0; i < arrayLength; i++)
		{
			totalRainFall += arr1[i];
		}
		return totalRainFall;
	}//end getTotalRainFall

	public static double getAverageRainFall(double[] arr1)
	{
		//this method does the same thing as the last but at the end it divides the total number by 12 to get the average rain fall per month
		int arrayLength = arr1.length;
		double totalRainFall = 0;
		for(int i = 0; i < arrayLength; i++)
		{
			totalRainFall += arr1[i];
		}
		totalRainFall = totalRainFall/12;
		return totalRainFall;
	}//end getAverageRainFall

	public static int getHighestMonth (double[] arr1)
	{
		//this method goes through each month and compares it to the month with the highest rainfall.
		//if that month's rain fall is higher, it replaces the previous highest amount of rain
		int arrayLength = arr1.length;
		int highestMonth = 0;
		for(int i = 0; i < arrayLength; i++)
		{
			if (arr1[i] > arr1[highestMonth])
			{
				highestMonth = i;
			}
		}
		return highestMonth;
	}//end getHighestMonth

	public static int getLowestMonth (double[] arr1)
	{
		//this method goes through each month and compares it to the month with the lowest rainfall.
		//if that month's rain fall is lower, it replaces the previous lowest amount of rain
		int arrayLength = arr1.length;
		int lowestMonth = 0;
		for(int i = 0; i < arrayLength; i++)
		{
			if (arr1[i] < arr1[lowestMonth])
			{
				lowestMonth = i;
			}
		}
		return lowestMonth;
	}//end getLowestMonth
}//end class