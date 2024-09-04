/* **********************************
 CSC160
 Lab 10 - Car.java
 Mary Hoette
 
This program has the superclass Car
 
************************************/

public class Car 
{
	private double price;
	
	public Car(double cost)
	{
		this.price = cost * 2;
	}//end constructor

	public double getPrice()
	{
		return price;
	}

}//end class Car
