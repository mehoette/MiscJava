/* **********************************
 CSC160
 Lab 10 - OldCar.java
 Mary Hoette
 
This program is the subclass OldCar
of superclass Car
 
************************************/
public class UsedCar extends Car
{
private int milage;
	
	public UsedCar(double cost, int milage) 
	{
		super(cost);
		this.milage = milage;
	}//end NewCar
	
	public boolean equals (UsedCar other)
	{
		if (other == null)
		{
			return false;
		}//end if
		else
		{
			return (this.getPrice() == other.getPrice() && this.milage == other.milage);
		}//end else
	}//end equals
	
	public void display()
	{
		System.out.println("price = " + this.getPrice() + ", milage = " + this.milage);
	}//end display
}//end NewCar
