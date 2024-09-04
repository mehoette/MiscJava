/* **********************************
 CSC160
 Lab 10 - Car.java
 Mary Hoette
 
This program has the subclass NewCar
of the superclass Car
 
************************************/

public class NewCar extends Car
{
	private String color;
	
	public NewCar(double cost, String color) 
	{
		super(cost);
		this.color = color;
	}//end NewCar
	
	public boolean equals(NewCar other)
	{
		if (other == null)
		{
			return false;
		}//end if
		else
		{
			return (this.getPrice() == other.getPrice() && this.color.equals(other.color));
		}//end else
	}//end equals
	
	public void display()
	{
		System.out.println("price = $" + this.getPrice() + ", color = $" + this.color);
	}//end display
}//end NewCar
