/* **********************************
CSC300
Assignment 3
Mary Hoette
 
This is the double array class.
It makes an array with negative indexes
set to the right starting with the index -1
and then the positive indexes on the left
it has the get, put, size, largest and 
smallest methods.
************************************/

public class DoubleArray
{
	//we have 3 arrays, the one that holds all you values 
	//and 2 for temporarily holding your negative or positive numbers respectively while you make the array bigger
	double[] arr, tempNeg, tempPos; 
	
	//because we are not allowed to use any array APIs, we have to keep track of the length manually
	int length; // this is the length for half of the combined array (so just posArr OR negArr) because in the code they are seperate
	//we also have to keep track of the filled elements so we can double the size of the arrays when they get full
	//these values initialize as 0 because even though we will created available indexes, there's nothing in there yet.
	//when the array is full posFilled + negFilled with = length
	int posFilled = 0;
	int negFilled = 0;
	
	//we also need values for the largest and smallest index given
	double minIndex = 0;
	double maxIndex = 0;
	
	public DoubleArray() 
	{
		//we make a new array with length 10 and set the length value to 10
		arr = new double[10];
		length = 10; 
		
	}//end constructor
	
	//if they specify how long the array should be...
	public DoubleArray(int lengthInput) 
	{
		//we make a new array with the length given and set the length value to the one given
		arr = new double[lengthInput];
		length = lengthInput; 
		
	}//end constructor

	public Double get(int index) 
	{
		
		if(index>=0 && (arr[index] != 0)) //if the value of i is positive or 0 and has been filled (is no longer the default double value of 0.0)
		{
			return arr[index];
		}//end if >= 0 & filled
		else if (index<0 && (arr[length+index] != 0)) //if the value of i is negative and has been filled (is no longer the default double value of 0.0)
		{
			return arr[length+index];
		}//end else if <0 and filled
		else //if the element has not been filled (and still has the default value of 0.0)
		{
			return Double.NaN;
		}//end else	
	}//end method get
	
	public void put(double value, int index)
	{
		
		//before adding anything we have to check if the array is full
		//because we are using one array for both positve and negative values, you have to add the number of each together
		//we want the number of indexes total not just the positive or negative ones
		if (posFilled + negFilled == length)
		{
			System.out.println();
			System.out.println("The array is now full.");
			tempPos = new double[length]; //make 2 temp arrays for negative and positive
			tempNeg = new double[length];
			for(int elem = 0; elem < posFilled; elem++)
			{
				tempPos[elem] = arr[elem];
			}//end for loop

			//then repeat the process but for the negative side
			
			for(int elem = negFilled; elem > 0; elem--)
			{
				tempNeg[elem-1] = arr[length-elem];
			}//end for loop
			
			length = length*2; //double the length
			arr = new double [length];
			//now add the positive indexes to the left side of the new array
			for(int elem = 0; elem < posFilled; elem++)
			{
				arr[elem] = tempPos[elem];
			}//end adding pos indexes
			//now add the negative indexes to the right side of the array
			
			for(int elem = 0; elem < negFilled; elem++)
			{
				arr[length-1-elem] = tempNeg[elem];
			}//end for adding neg indexes
				
			System.out.println("The capacity has been doubled:" + length);
			System.out.println();
		}//end if length = filled
		
		//now we for sure have room to put the new value
		//if it is trying for an index we don't have...
		//this is different from having a full array we can have empty seats, but they want to be somewhere they aren't allowed to be
		if ((index > 0 && index > length-negFilled) || (index < 0 && index+length < posFilled))
			System.out.println("Error: index out of range index:" + index);
		else
		{
			if (index >= 0)//if the index is positive or 0 put it on the left
			{
				arr[index] = value;
				posFilled++;
			}
			else if (index < 0)//else if the index is negative, put it on the right with the right most index being -1
			{
				//
				arr[length + index] = value;
				negFilled++;
			}
	
			//we also have to check if this new index is either the highest or lowest index so far
			if(index > maxIndex)
				maxIndex = index;
			if(index < minIndex)
				minIndex = index;
		}//end if valid index
	}//end put class

	public int size() 
	{
		//just return the size of the array
		return length;
	}//end method size

	public double largest() 
	{
		//if no numbers have been put on the positive side of the array
		if(posFilled == 0)
			return Integer.MAX_VALUE;
		else
			return maxIndex;
	}//end method largest
	
	public double smallest()
	{
		//if no numbers have been put on the negative side of the array
		if(negFilled == 0)
			return Integer.MIN_VALUE;
		else
			return minIndex;
	}//end method smallest
}//end class DoubleArray

















