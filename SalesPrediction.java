
/* **********************************
 CSC150
 Assignment 2
 Mary Hoette
 
 This program calculates the profits 
 from the east coast division of a 
 company while knowing how much the 
 east coast division provides to the 
 company as a whole.
************************************/

public class SalesPrediction
{
 public static void main(String[] args)
 {
	 double eastCoastPercentSales = .62;	//Percent of sales from the east coast division
	 
	 double totalCompanyProfit = 4600000;	//Profit of the company as a whole
	 
	 double eastCoastProfit = eastCoastPercentSales * totalCompanyProfit; //equation to find out how much profit the east coast makes
	 
	 System.out.println("The Profits made by the east cost division is $" + eastCoastProfit); //print the profit
 }
} // end of class SalesPrediction
