/* **********************************
CSC300
Assignment 4
Mary Hoette
 
This class uses the sorting methods taught
in class (bubble, selection and insertion 
to sort 5000 integers and compares them 
using the System.currentTimeMillis() method.

I referenced the codes of the different 
sorting methods posted on moodle, but did
not copy it. I just used them to check my
work. :)
************************************/

public class Hoette {

	public static void main(String[] args) 
	{
		//create int varibles for in, out, temp, and min. these will be used for the various sorting methods
		int in, out, temp, min;
		//create 3 arrays for each sorting method
		int bubbleArr[] = new int[5000];
		int selectArr[] = new int[5000];
		int insertArr[] = new int[5000];
		
		//fill one array with random number between 0 - 4999
		//then copy that array into the other 2 arrays, so the 
		for(int index = 0; index < bubbleArr.length; index++)//fill the array with a random int value at every index
		{
			bubbleArr[index] = (int) (5000 * Math.random()); // this fills the array at index i with a random number between 0-4999
		}//end for loop
		for(int index = 0; index < bubbleArr.length; index++)//for each index...
		{
			selectArr[index] = bubbleArr[index];//copy the bubbleArr into the selectArr
		}//end for loop
		
		for(int index = 0; index < bubbleArr.length; index++)//for each index...
		{
			insertArr[index] = bubbleArr[index];//copy the bubbleArr into the insertArr
		}//end for loop	
		
		//now we are going to start sorting and recording the time
		long start = System.currentTimeMillis(); // start recording the time
		for(out = bubbleArr.length - 1; out > 0; out--)
		{
			for(in = 0; in < out; in++) //use 2 for loops to compare each number to all the others
			{
				if (bubbleArr[in] > bubbleArr[in+1])//if the number lower in the array is larger than the one higher in the array...
				{
					//swap them
					temp = bubbleArr[in]; 
					bubbleArr[in] = bubbleArr[in+1];
					bubbleArr[in+1] = temp;
				}//end if bubble
			}//end inner for bubble
		}//end outer for bubble
		long end=System.currentTimeMillis(); //stop recording time
		System.out.println("Execution time bubble sort: "+(end-start) + " ms"); //print how long the sorting took
		
		start = System.currentTimeMillis(); // start recording the time
		for(out = 0; out < selectArr.length-1; out++)
		{
			min = out; //make the minimum value from earlier the smallest number in the set. initialize it as the first number in the set
			for(in = out+1; in < selectArr.length; in++)
			{
				if(selectArr[in]< selectArr[min])//if there you find a number smaller than the current minimum...
				{
					min = in;//make that number the new minimum
				}//end if selection
			}//end inner for selection
			
			//swap the smallest number with the one farthest to the left
			temp = selectArr[out];
			selectArr[out] = selectArr[min];
			selectArr[min] = temp;
		}//end outer for selection
		end=System.currentTimeMillis(); //stop recording the time
		System.out.println("Execution time selection sort: "+(end-start) + " ms"); //print how long the sorting took
		
		start = System.currentTimeMillis(); //start recording time
		
		for (out = 0; out < insertArr.length; out++)
		{
			temp = insertArr[out];
			in = out;
			while(in > 0 && insertArr[in-1] >= temp)
			{
				insertArr[in] = insertArr[in-1];
				in--;
			}//end while insertion
			insertArr[in] = temp;
		}//end outer for insertion
		end=System.currentTimeMillis(); //start recording time
		System.out.println("Execution time insertion sort: "+(end-start) + " ms");//print how long the sorting took
		
	}//end main
}//end class
