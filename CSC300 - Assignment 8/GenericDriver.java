/* **********************************
CSC300
Assignment 8
Mary Hoette
 
Worked with Rajé Alleyne on this project
This is the driver class for Generic.java
It tests the push, pop, peek, isEmpty, 
size and clone methods
************************************/

public class GenericDriver 
{
	public static void main(String[] args) 
	{
		Generic<Integer> intStack = new Generic<Integer>(); //so we need 2 stacks, one for the integers and one for strings
		Generic<String> stringStack = new Generic<String>();
		Generic<Integer> copyInt; //we also need places for the 2 copies to go
		Generic<String> stringCopy;
		Generic tempStack;//we also need one that can be either variable type that is used as a temp stack
		int intSize, stringSize, cloneSize; //we also have a size variable for both the int and string and clone stacks
		
	//		a- Print the stack (the stack is empty)
			tempStack = new Generic(); //so make the tempStack a new empty stack
			intSize = intStack.Size();//we have to make this an outside variable because as we iterate, intStack.Size changes when we Pop items
			for(int i = 0; i < intSize; i++)//Iterate through each item in the stack
			{
				int temp = (int) intStack.Pop(); //pop each element
				System.out.print(temp + ", ");//print it
				tempStack.Push(temp);//and put it onto the temporary stack
			}//end for
			System.out.println();//then make a new line so it looks all nice
			for(int i = 0; i < intSize; i++)//but oh no we can't make the temp stack our main stack because it is upside down
			{
				int temp = (int)
	(); //so to flip the stack back rightways up, we pop each item
				intStack.Push(temp); //and add them back to the original stack
			}//end for
			
	//		b- Pushing items onto the stack.
			//just put some stuff in there
			intStack.Push(1);
			intStack.Push(2);
			intStack.Push(3);
			intStack.Push(4);
			intStack.Push(5);
			
			
	//		c- Print the stack (You need to use the size () to iterate over the stack).
			//this printing is just the same as before
			tempStack = new Generic(); //make a new empty stack
			intSize = intStack.Size();//we've changed the stack, so update that size before you use it
			for(int i = 0; i < intSize; i++) //iterate through each element
			{
				int temp = (int) intStack.Pop();//pop it
				System.out.print(temp + ", ");//print it
				tempStack.Push(temp);//push it
			}//end for
			System.out.println();//new line to look nice
			for(int i = 0; i < intSize; i++)//reverse it and send it back to the original stack
			{
				int temp = (int) tempStack.Pop();
				intStack.Push(temp);
			}//end for
			
			
			
	//		d- Generate a copy of this stack.
			copyInt = intStack.Clone(); //we are setting that copy stack we made earlier by using the clone method
			cloneSize = copyInt.Size();//let's make a size variable for this one too
			
	//		e- Remove several items from the stack (using pop () method).
			//make the original and the copy different
			intStack.Pop();
			intStack.Pop();
			intStack.Pop();
			
	//		f- Print the original stack and the clone of the original.
			//print just like we've done twice before but this time do it with the cloned stack too
		
			tempStack = new Generic<Integer>();
			System.out.print("Original Integer Stack: ");
			intSize = intStack.Size();//we've changed the stack, so update that size before you use it
			for(int i = 0; i < intSize; i++)
			{
				int temp = (int) intStack.Pop();
				System.out.print(temp + ", ");
				tempStack.Push(temp);
			}//end for
			System.out.println();
			for(int i = 0; i < intSize; i++)
			{
				int temp = (int) tempStack.Pop();
				intStack.Push(temp);
			}//end for
			
			System.out.print("Clone Stack: ");
			tempStack = new Generic<Integer>();
			for(int i = 0; i < cloneSize; i++)
			{
				int temp = (int)copyInt.Pop();
				System.out.print(temp + ", ");
				tempStack.Push(temp);
			}//end for
			System.out.println();
			for(int i = 0; i < cloneSize; i++)
			{
				int temp = (int) tempStack.Pop();
				copyInt.Push(temp);
			}//end for
		
		
//now repeat it all but in strings this time to show it can take any variable type
		
//		a- Print the stack (the stack is empty)
		tempStack = new Generic();
		stringSize = stringStack.Size();
		for(int i = 0; i < stringSize; i++)
		{
			String temp = (String) stringStack.Pop();
			System.out.print(temp + ", ");
			tempStack.Push(temp);
		}//end for
		System.out.println();
		for(int i = 0; i < stringSize; i++)
		{
			String temp = (String) tempStack.Pop();
			stringStack.Push(temp);
		}//end for
		
//		b- Pushing items onto the stack.
		stringStack.Push("hello");
		stringStack.Push("yes");
		stringStack.Push("dog");
		stringStack.Push("cat");
		stringStack.Push("hat");
		
//		c- Print the stack (You need to use the size () to iterate over the stack).
		tempStack = new Generic();
		stringSize = stringStack.Size();
		for(int i = 0; i < stringSize; i++)
		{
			String temp = (String) stringStack.Pop();
			System.out.print(temp + ", ");
			tempStack.Push(temp);
		}//end for
		System.out.println();
		
		for(int i = 0; i < stringSize; i++)
		{
			String temp = (String) tempStack.Pop();
			stringStack.Push(temp);
		}//end for
		
		
		
//		d- Generate a copy of this stack.
		Generic copyString = stringStack.Clone(); //there's definatly a better way to do this
		cloneSize = copyString.Size();
		
//		e- Remove several items from the stack (using pop () method).
		stringStack.Pop();
		stringStack.Pop();
		stringStack.Pop();
		
		//		f- Print the original stack and the clone of the original.
		tempStack = new Generic<String>();
		System.out.print("Original String Stack: ");
		stringSize = stringStack.Size();
		for(int i = 0; i < stringSize; i++)
		{
			String temp = (String) stringStack.Pop();
			System.out.print(temp + ", ");
			tempStack.Push(temp);
		}//end for
		System.out.println();
		for(int i = 0; i < stringSize; i++)
		{
			String temp = (String) tempStack.Pop();
			stringStack.Push(temp);
		}//end for
		
		System.out.print("Clone Stack: ");
		tempStack = new Generic<Integer>();
		for(int i = 0; i < cloneSize; i++)
		{
			String temp = (String)copyString.Pop();
			System.out.print(temp + ", ");
			tempStack.Push(temp);
		}//end for
		System.out.println();
		for(int i = 0; i < cloneSize; i++)
		{
			String temp = (String) tempStack.Pop();
			copyString.Push(temp);
		}//end for
		
		
	}//end main
}//end class
