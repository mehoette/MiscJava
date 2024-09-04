import java.util.Scanner;

/****************************************
* Circle.java
* Assignment 1
* Mary Hoette
* CSC160
*
*This program has 
*
****************************************/
import java.util.Scanner;

public class Circle 
{
	private double radius; //this is setting up the instance radius which would be used in all of the following methods
	
	public void setRadius(double radiusValue)
	{
		//this method just sets radius to the parameter value
		this.radius = radiusValue;
	}//end setRadius
	 
	public void initialize()
	{
		//this method initializes the scanner, prompts the user for input and then sets radius to that input
		Scanner stdIn = new Scanner(System.in);
		System.out.println("Enter a radius Value: ");
		double radiusInput = stdIn.nextDouble();
		this.radius = radiusInput;
	}//end initialize
	public void printCircleData() 
	{
		//this method calculates and prints the radius, diameter, circumference and area using the radius
		System.out.println("Radius = " + (radius));
		System.out.println("Diameter = " + (2*radius));
		System.out.println("Circumference = " + (2 * Math.PI * radius));
		System.out.println("Area = " + (Math.PI * radius * radius));
	}//end printCircleData
}//end class
