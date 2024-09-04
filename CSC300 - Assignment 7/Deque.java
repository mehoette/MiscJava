/* **********************************
CSC300
Assignment 7
Mary Hoette
 
This is an edited Deque method. It has
the insertLeft, insertRight, removeLeft
removeRight, isEmpty, isFull, size and
display method. Only the insertLeft,
removeLeft and isEmpty methods are used
in the driver.
************************************/

class Deque
{
	private int maxSize;
	private String[] dekArray;
	private int left;
	private int right;
	private int nItems;
//--------------------------------------------------------------
	public Deque(int s) // constructor
	{
		maxSize = s;
		dekArray = new String[maxSize];
		int center = maxSize/2 - 1;
		left = center+1; // left and right
		right = center; // start out "crossed"
		nItems = 0;
	}//end constructor
//--------------------------------------------------------------
	public void insertLeft(String j) // put item at left of deque
	{
		if(left == 0) // deal with wraparound
			left = maxSize;
		dekArray[--left] = j; // insert and decrement left
		nItems++; // one more item
	}//end insertLeft
//--------------------------------------------------------------
	public void insertRight(String j) // put item at right of deque
	{
		if(right == maxSize-1) // deal with wraparound
			right = -1;
		dekArray[++right] = j; // insert and increment right
		nItems++; // one more item
	}//end insertRight
//--------------------------------------------------------------
	public String removeLeft() // take item from left of deque
	{
		String temp = dekArray[left++]; // get value and incr left
		if(left == maxSize) // deal with wraparound
			left = 0;
		nItems--; // one less item
		return temp;
	}//end removeLeft
//--------------------------------------------------------------
	public String removeRight() // take item from right of deque
	{
		String temp = dekArray[right--]; // get value and decr right
		if(right == -1) // deal with wraparound
			right = maxSize-1;
		nItems--; // one less item
		return temp;
	}//end removeRight
//--------------------------------------------------------------
	public boolean isEmpty() // true if deque is empty
	{ 
		return (nItems==0); 
	}//end isEmpty
//--------------------------------------------------------------
	public boolean isFull() // true if deque is full
	{ 
		return (nItems == maxSize); 
	}//end isFull
//--------------------------------------------------------------
	public int size() // number of items in deque
	{ 
		return nItems;
	}//end size
//--------------------------------------------------------------
	public void display()
	{
		System.out.print("Array: ");
		for(int j=0; j<maxSize; j++) // print array contents
			System.out.print( dekArray[j] + " " );
		System.out.println("");
		System.out.print("Deque: ");
		if(left <= right) // print deque contents
			for(int j=left; j<=right; j++)
				System.out.print( dekArray[j] + " ");
		else if( isEmpty() == false )
		{
			for(int j=left; j<maxSize; j++)
				System.out.print( dekArray[j] + " ");
			for(int j=0; j<=right; j++)
				System.out.print( dekArray[j] + " ");
		}//end else if
		System.out.println("");
	} // end display()
//--------------------------------------------------------------
} // end class Deque