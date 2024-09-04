
/* *********************************
 CSC160
 Assignment 2
 Mary Hoette
 
This is the driver for the FractionDemo
class.
 
************************************/
import java.util.Scanner;

public class FractionDemoDriver
{

	
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		Fraction c, d, x; // Fraction objects
		
		System.out.println("Enter numerator; then denominator.");
		c = new Fraction(stdIn.nextInt(), stdIn.nextInt());
		c.print();
		
		System.out.println("Enter numerator; then denominator.");
		d = new Fraction(stdIn.nextInt(), stdIn.nextInt());
		d.print();
		
		x = new Fraction(0,1); // create a fraction for number 0
		
		System.out.println("Sum:");
		
		x.add(c).add(d);
		x.print();
		x.printAsDouble();
		
		x = new Fraction(); // create a fraction for number 1
		System.out.println("Product:");
		x.multiply(c).multiply(d);
		x.print();
		x.printAsDouble();
		
		System.out.println("Enter numerator; then denominator.");
		x = new Fraction(stdIn.nextInt(), stdIn.nextInt());
		x.printAsDouble();
	} // end main
}//end class
