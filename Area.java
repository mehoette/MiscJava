
/* **********************************
 CSC150
 Assignment 9
 Mary Hoette
 
This program has 3 methods that are
overloaded. One has one double parameter.
One has two int parameters. And the last
one had two double parameters. The code
will
 
************************************/

public class Area {

	public static void main(String[] args)
	{
		// Get the area of a circle with a radius of 20.0.
		System.out.println("The area of a circle with a radius of 20.0 is " + getArea(20.0));
		// Get the area of a rectangle with a length of 10
		// and a width of 20.
		System.out.println("The area of a rectangle with a length of 10 and a width of 20 is " + getArea(10, 20));
		// Get the area of a cylinder with a radius of 10.0
		// and a height of 15.0.
		System.out.println("The area of a cylinder with a radius of 10.0 and a height of 15.0 is " + getArea(10.0, 15.0));
	 }

	
	public static double getArea (double radius) //area circle
	{
		double area = Math.PI * radius * radius;
		return area;
	}
	
	public static int getArea (int length, int width) //area rectangle
	{
		int area = length * width;
		return area;
		
	}
	
	public static double getArea (double radius, double height) //area cylinder
	{
		double area = height * Math.PI * radius * radius;
		return area;
	}
	
}//end class
