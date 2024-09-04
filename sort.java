/* **********************************
CSC310
Assignment 1
Mary Hoette
2/14/2023
 
This class has the display, reverseDisplay,
flip and itemAt methods. :)
************************************/
import java.io.*;
import java.util.Scanner;

public class sort 
{
	public static void main (String[]args) throws Exception
	{
		long start, end;//make 2 variables for the start time and end time
		
		//alright so basically the format is hey make a file and then send that file and number of lines it has to the run function
		//also I can't name a variable starting with a number, so I do have to spell out the number and it gets kinda long. so sorry
		//I swear my code does compile but it takes a HOT second. oh boy
		File ten = new File("10.txt");
		run(ten, 10);
		File hundred = new File("100.txt");
		run(hundred, 100);
		File thousand = new File ("1000.txt");
		run(thousand, 1000);
		File tenThousand = new File ("10000.txt");
		run(tenThousand, 10000);
		File hundredThousand = new File ("100000.txt");
		run(hundredThousand, 100000);
		File million = new File ("1000000.txt");
		run(million, 1000000);
		File tenMillion = new File ("10000000.txt");
		run(tenMillion, 10000000);
		File twentyFiveThousand = new File ("25000.txt");
		run(twentyFiveThousand, 25000);
		File twoHundredFiftyThousand = new File ("250000.txt");
		run(twoHundredFiftyThousand, 250000);
		File fiveThousand = new File ("5000.txt");
		run(fiveThousand, 5000);
		File fiftyThousand = new File ("50000.txt");
		run(fiftyThousand, 50000);
		File fiveHundredThousand = new File ("500000.txt");
		run(fiveHundredThousand, 500000);
		File seventyFiveThousand = new File ("75000.txt");
		run(seventyFiveThousand, 75000);
		File sevenHundredFiftyThousand = new File ("750000.txt");
		run(sevenHundredFiftyThousand, 750000);
	}//end main
	
	public static void run(File file, int size) throws Exception
	{
		long start, end;//make 2 variables for the start time and end time
		Scanner input = new Scanner(file);
		int [] arr = new int[size];//make an array with the given size
		
		for(int i = 0; i <size; i++)
		{
			arr[i] = input.nextInt();
		}//end for
		
		
		System.out.println("Reading data from " + size + ".txt");
		isSorted(arr);
		//System.out.println("Sorting using Selection Sort");
		System.out.println("Sorting using Merge Sort");
		start = System.currentTimeMillis();//start recording the time
		//selectionSort(arr);
		mergeSort(arr, size);
		end = System.currentTimeMillis();
		System.out.println("It took " + (end-start) + " ms to sort.");
		isSorted(arr);
		System.out.println();//hey put an empty line between each file so it isn't an absolute block of text
	}
	
	public static void isSorted(int[] arr)
	{
		for(int i = 0; i < arr.length-1; i++)//make a number of comparisons equal to one less than the length
		{
			if(arr[i] > arr[i+1])//if a value in the list is greater than the next number in the array, it is not sorted. 
			{
				System.out.println("confirmed NOT sorted");
				return;
			}//end if
		}//end for
		System.out.println("confirmed sorted");//if all values are less than the value after it, the array is sorted.
	}//end isSorted method 
	
	public static void selectionSort(int[] arr)
	{
		for(int out = 0; out < arr.length-1; out++)//go through the unsorted part of the array looking for the next number to sort
		{
			//create a variable for the smallest number, default this value to the first number you look at
			int min = out; //this will hold its spot in the array, not the actual value
			
			for (int in = out+1; in < arr.length; in ++)//now go through the rest of the array to try to find a smaller number
			{
				if (arr[in] < arr[min])//if you find a smaller number, make that the new min
				{
					min = in;
				}//end if
			}//end inner loop
			
			int temp = arr[out];
			arr[out] = arr[min];
			arr[min] = temp;
		}//end outer for loop
	}//end selection sort method
	
	public static void mergeSort(int[] arr, int high) 
	{
	    if (high < 2) //if the array only as one object, you don't have to sort it
	    {
	        return;
	    }
	    
	    int mid = high / 2;
	    int[] lowArray = new int[mid];//copy the array up to mid
	 
	    for (int i = 0; i < mid; i++)
	    {
	        lowArray[i] = arr[i];
	    }//end for
	    
	    int[] highArray = new int[high - mid];//copy the array after mid

	    for (int i = mid; i < high; i++) 
	    {
	        highArray[i - mid] = arr[i];
	    }//end for
	    
	    mergeSort(lowArray, mid);//sort the low array
	    mergeSort(highArray, high - mid);//sort the high array

	    merge(arr, lowArray, highArray, mid, high - mid);//merge lowArray and highArray and put it in arr. also pass the values where lowArray and highArray will end
	}//end mergeSort method
	
	public static void merge(int[] arr, int[] lowArray, int[] highArray, int left, int right) 
	{
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) //as long as there's still values in both arrays
		    {
			    if (lowArray[i] <= highArray[j]) //if the next value in lowArray is less than or equal to the next value in highArray
			    {
			            arr[k] = lowArray[i];//put the value of index i in the lowArray in the next open spot in the full array
			            //mark that we have put one more value in the low and full array
			            k++;
			            i++;
			    }//end if
			    else 
			    {
			    	arr[k] = highArray[j];//put the value of index i in the highArray in the next open spot in the full array
		            //mark that we have put one more value in the high and full array
			    	k++;
			    	j++;
			    }//end else
			}//end while stuff in both arrays
		while (i < left) //while no low array left
		{
		    arr[k++] = lowArray[i++];
		}//end while 
		while (j < right) //while
		{
		    arr[k++] = highArray[j++];
		}//end while
	}//end merge method
	
}//end class


