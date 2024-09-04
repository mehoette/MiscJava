/* **********************************
CSC300
Assignment 6
Mary Hoette
 
This is the driver class for Stack.java
It tests the display, reverseDisplay,
flip and itemAt methods. :)
************************************/

public class StackDriver 
{
	public static void main(String[] args)
	{
		//make a new stack called myStack
		Stack myStack = new Stack();
		
		System.out.println("Testing the flip method....");
		System.out.println("let's push some items onto the stack:");
		
		//push the 4 values given
		myStack.push(20);
		myStack.push(40);
		myStack.push(60);
		myStack.push(80);

		System.out.println();
		System.out.println("Let's flip the stack now ...");
		myStack.flip(); //flip the stack
		System.out.println("and print the stack from bottom to top ...");
		myStack.display(); //display the stack
		
		System.out.println("Let's flip it one more time ...");
		myStack.flip(); //flip the stack
		System.out.println("and print it from top to bottom ...");
		myStack.reverseDisplay(); //display the stack in reverse (top to bottom instead of bottom to top)
		
		System.out.println("Now let's print the element at n equals 2:" + myStack.itemAt(2)); //find the item at index 2
		System.out.println("What about at n equals 100?");
		System.out.println(myStack.itemAt(100)); //find the item at index 2 (this will generate an error but we've planned for it)
		System.out.println("Done!");//bam bam we done
	}//end main
}//end StackDriver
