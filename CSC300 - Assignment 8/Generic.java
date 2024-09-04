/* **********************************
CSC300
Assignment 8
Mary Hoette

Worked with Rajé Alleyne on this project
This class has the constructor, push,
pop, peek, isEmpty, size and clone methods
************************************/

public class Generic<E> 
{
	private E[ ] data;
	private int nItems;
	
	public Generic()
	{
		nItems = 0;
	    data = (E[]) new Object[10];//make an array that can be any variable type. start with 10 objects (this number is arbitrary and can be anything you want)
	}//end constructor
	
	public void Push (E item)
	{
		if (nItems == data.length)//if we don't have enough room, double the size of the array
	      {  
			E bigger[ ] = (E[]) new Object[(nItems)*2]; //make an array that's twice as long
	        for(int i = 0; i < nItems; i++)//put every item from the original array on the new array
	        {
	        	bigger[i] = data[i];
	        }
	        data = bigger;//make our main array point to the newer bigger array
	      }//end if
		//System.out.println("adding " + item + " at index " + nItems); //I was just using this print statement to test. it is not needed
		data[nItems] = item;//put the item passed at the index of the number of items.
		nItems++;//increment the number of items
		
	}//end push
	
	public E Pop ()
	{
		E temp = data[nItems - 1];//take the last item in the stack
		//System.out.println("removing " + temp + " at index " + (nItems-1)); //this was also being used to test it is not needed
		nItems--;//decrement the number of items because we are taking one off
		return temp;//return the item you just took off the list
	}//end pop
	
	public E Peek()
	{
		return data[nItems]; //just return the last item in the stack, but don't do anything to the stack
	}//end peek
	
	public boolean IsEmpty()
	{
		if (nItems == 0)//if there are no items, the list is empty
		{
			return true;
		}
		else
		{
			return false;
		}
	}//end isEmpty
	
	public int Size()//nItems is the number of items in the stack, so return that when people want to know the size of the array
	{
		return nItems; 
	}//end Size
	
	public Generic Clone()
	{
		Generic temp = new Generic();//make a new stack
		for(int i = 0; i <= nItems -1; i++)//iterate through the stack
		{
			temp.Push(data[i]);//put everything that was on the last stack in this new stack
		}//end for
		return temp;//return the temp stack that now has a copy, but is seperate from the original stack
	}//end clone
	
}//end class
