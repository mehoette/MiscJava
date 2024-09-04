/* **********************************
 CSC160
 Lab 10 - CarDriver.java
 Mary Hoette
 
This is the driver for the superclass
Car and the Subclasses NewCar and OldCar
 
************************************/

public class CarDriver 
{
	public static void main(String[] args)
	{
		NewCar new1 = new NewCar(8000.33, "silver");
	 	NewCar new2 = new NewCar(8000.33, "silver");
	 	
	 	if (new1.equals(new2))
	 	{
		 	new1.display();
	 	}//end if
	 	
	 	UsedCar used1 = new UsedCar(2500, 100000);
	 	UsedCar used2 = new UsedCar(2500, 100000);
	 	
	 	if (used1.equals(used2))
	 	{
		 	used1.display();
	 	}//end if
	} // end main
}//end CarDriver
