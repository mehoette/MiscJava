/* *********************************
 CSC160
 Assignment 2
 Mary Hoette
 
This is includes the constructor and 
 
************************************/
public class Fraction
{
	//here I'm initializing variables the most important of which are numerator and denominator
	private int numerator;
	private int denominator;
	private int temp;
	private double doubleNumerator;
	private double doubleDenominator;
	
	//this first method is just a constructor
	public Fraction() 
	{
		this.numerator = 0;
		this.denominator = 1;
	}//end Fraction constructor 0
	
	public Fraction(int numerator, int denominator) 
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}//end Fraction constructor
	
	//the add method make the fractions have a common denominator and then adds the 2 fractions together
	public Fraction add(Fraction num)
	{
		//first we have to make the fractions have a common denominator and adjust all the fractions
		temp = this.denominator;
		//multiply this (both numerator & denominator) by the other denominator
		this.denominator = this.denominator * num.denominator;
		this.numerator = this.numerator * num.denominator;
		//and now multiply the other (both numerator & denominator by the old this denominator (which is stored in temp)
		num.denominator = num.denominator * temp;
		num.numerator = num.numerator * temp;
		
		//and now that we've done that we can finally add the 2 numerators together
		this.numerator += num.numerator;
		
		return this;
	}//end add
	
	//the multiply method returns infinity if either of the denominators are 0 and multiplies both the numerators and denominators together
	public Fraction multiply(Fraction num)
	{
		if (this.denominator == 0 || num.denominator == 0)
		{
			System.out.println("Infinity");
		}
		else
		{
			this.numerator = this.numerator * num.numerator;
			this.denominator = this.denominator * num.denominator;
		}
		return this;
		
	}//end multiply

	//the print function just print the numerator, a fraction bar, and then the denominator
	public Fraction print()
	{
		System.out.println(numerator + "/" + denominator);
		return this;
	}//end print
	
	//the printAsDouble function prints infinity if the denominator is 0
	//otherwise it converts the numerator and denominator into doubles in the variables doubleNumerator and doubleDenominator respectively
	//then it divides the numerator by the denominator to get a decimal
	public Fraction printAsDouble()
	{
		if (this.denominator == 0)
		{
			System.out.println("Infinity");
		}
		else
		{
			doubleNumerator = this.numerator;
			doubleDenominator = this.denominator;
			System.out.println(doubleNumerator/doubleDenominator);
		}
		return this;
	}//end print
	
}//end class
