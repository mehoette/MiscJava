/* **********************************
CSC300
Assignment 6
Mary Hoette
 
This class has the display, reverseDisplay,
flip and itemAt methods. :)
************************************/

public class Stack 
{
	int [] stack; //make an array for the stack
	int maxIndex = -1;//keep a counter on the max index (this initializes at -1 because there's nothing in the stack yet)
	
	public Stack()
	{
		stack = new int[10]; //initialize the stack with a size of 10. the number 10 is arbitrary you could update this to grow as you add items to the stack
	}//end constructor method
	
	public void push (int input)
	{
		maxIndex++;//increase the max index
		System.out.println("pushing " + input);//print the value you are pushing
		stack[maxIndex] = input;//set the stack at the new max index to the input given
	}//end push method
	
	public int pop()
	{
		System.out.println("pop " + stack[maxIndex]);//print the value you are popping (this will always be at the max value because Stacks are LIFO
		return stack[maxIndex--]; //return the value at the maxIndex and then decrement the max index by one.
	}//end pop method
	 
	public int peek()
	{
		System.out.println("peek " + stack[maxIndex]);//print the value at maxIndex
		return stack[maxIndex]; //just return the value at maxIndex do not decrement the maxIndex
	}//end peek method
	
	public void display() //print from bottom to top
	{
		for(int i = 0; i <= maxIndex; i++) //use a for loop to go through the whole filled array starting at the first index added (index 0)
		{
			System.out.println(stack[i]); //print the item at index i
		}//end for
		System.out.println(); //after you print all values in the array, print an empty line
	}//end display method
	
	public void reverseDisplay () //print from top to bottom
	{
		for(int i = maxIndex; i >= 0; i--)//use a for loop to go through the whole filled array starting at the last index added (maxIndex)
		{
			System.out.println(stack[i]);//print the item at index i
		}//end for
		System.out.println();//after you print all values in the array, print an empty line
	}//end reverseDisplay method
	
	public void flip()
	{
		for(int i = 0; i <= maxIndex/2; i++)//only do this for half the stack (maxIndex/2) if you do it for the full stack it will just flip and then unflip it
		{
			int temp = stack[i]; //put the value at index i in the stack
			stack[i] = stack[maxIndex - i]; //set index i to the index that's the same distance from the end on the other side of the stack (if you folded the stack in half these 2 indexes should be touching)
			stack[maxIndex - i] = temp;//set the symmetrical index to what we saved in temp from index i
		}//end for
	}//end flip method
	
	public String itemAt(int n)
	{
		if (maxIndex < n) //if it is trying to get to an index, return an error statement
		{
			return ("Error: " + n + " out of range.");
		}//end if
		else //if it is a filled index, then return the number at that index
		{
			return ("" + stack[maxIndex - n]);
		}//end else
	}//end itemAt method
}//end Stack