/* *********************************
 CSC160
 Assignment 2
 Mary Hoette
 
This is includes the constructor and 
 
************************************/
public class HwScore 
{
	//here I have constants for grade cut offs
	public final static double ACUTOFF = 0.9;
	public final static double BCUTOFF = 0.8;
	public final static double CCUTOFF = 0.7;
	public final static double DCUTOFF = 0.6;
	
	//here are are 2 static public
	public static double totalEarnedPoints;
	public static double totalPossiblePoints;
	
	private double earnedPoints;
	private double possiblePoints;
	private double temp;
		
	public HwScore (double earned, double possible)
	{
		this.earnedPoints = earned;
		this.possiblePoints = possible;
		totalEarnedPoints += this.earnedPoints;
		totalPossiblePoints += this.possiblePoints;
	}//end constructor
	
	public HwScore printGrade()
	{
		temp = this.earnedPoints/this.possiblePoints;
		System.out.print("On this homework, you earned " + this.earnedPoints + " out of " + this.possiblePoints + " possible points: ");
		if (temp>= ACUTOFF)
		{
			System.out.print("A\n");
		}//end if A
		else if (temp >= BCUTOFF)
		{
			System.out.print("B\n");
		}//end elseif B
		else if (temp >= CCUTOFF)
		{
			System.out.print("C\n");
		}//end elseif C
		else if (temp >= DCUTOFF)
		{
			System.out.print("D\n");
		}//end elseif D
		else
		{
			System.out.print("F\n");
		}//end else F
		
		return this;
	}//end printGrade
	
	public static void printTotalGrade()
	{
		double temp = totalEarnedPoints/totalPossiblePoints;
		System.out.print("On all homework, you earned " + totalEarnedPoints + " out of " + totalPossiblePoints + " possible points: ");
		if (temp>= ACUTOFF)
		{
			System.out.print("A\n");
		}//end if A
		else if (temp >= BCUTOFF)
		{
			System.out.print("B\n");
		}//end elseif B
		else if (temp >= CCUTOFF)
		{
			System.out.print("C\n");
		}//end elseif C
		else if (temp >= DCUTOFF)
		{
			System.out.print("D\n");
		}//end elseif D
		else
		{
			System.out.print("F\n");
		}//end else F
	}//end printTotalGrade
	
}//end class
