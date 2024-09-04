/* **********************************
CSC300
Assignment 7
Mary Hoette
 
This is the driver class for Deque.java.
It takes an input sentence and sees if
the sentence is a word by word palindrome.
The sentence can only have spaces, letters
and apostrophes. If it has anything else, it
will remind you of these rules and ask you 
to put in another sentence. It repeats this 
process until told to stop.
************************************/

import java.util.Scanner;

public class DequeDriver 
{
	public static void main(String args[])
	{
		Scanner stdIn = new Scanner(System.in);
		Deque deque;
		String sentence, sentenceReverse, quit;
		int index = 0, numWords;
		boolean valid;
		
		do 
		{
			//wipe the 3 string variables
			sentence = "";
			sentenceReverse = "";
			quit = "";
			
			do //this do while loop will make sure the input is only spaces, letters and apostrophes.
			{
				
				valid = true; //we assume it is true unless proven false
				numWords = 0;//this needs to be initialized here so it will reset with any new sentence put in
				System.out.println("Input your sentence: ");
				sentence = stdIn.nextLine();
				
				for(int i = 0; i < sentence.length(); i++)
				{
					if (!(sentence.charAt(i) == ' ' || sentence.charAt(i) == '\'' || Character.isAlphabetic(sentence.charAt(i)))) //if the character isn't an apostrophe or a letter
					{
						valid = false;//not a valid character changes valid to false
					}//end if
					if(sentence.charAt(i) == ' ')
					{
						numWords++; //this will make it so after the for loop numWords is the number of spaces there are
								    //this will make numWords either the number of words or one less if it does not end with a space
									//Don't worry about it being one less, we deal with that on line 58
					}//end if space
				}//end for
				if(!valid)//we only want to print this once so it isn't in the for statement
				{
					System.out.println("Please only use letters, spaces and apostrophes"); //print this statement if it has something other than letters, spaces and apostrophes.
				}//end if
			}while(!valid); //end input validation	
			if(sentence.charAt(sentence.length() - 1) != ' ')//if it doesn't end with a space...
			{
				sentence = sentence + ' ';//add a space at the end (the space marks the end of a word.
				numWords += 1;//make it so that numWords is definitely the number of words we have.
			}//end if to add a space at end
		
			deque = new Deque(numWords); //make a new deque object with a number of spaces related to the number of words we have
			System.out.println("");//empty line
		
			for(int j = 0; j < sentence.length(); j = index + 1)//this splits the string into chunks that each have one space. this will also be the number of words you have
			{
				index = sentence.indexOf(" ", j);//find the index of a space. this will mark the end of the word
				String temp = sentence.substring(j, index);//make a substring from the character after the last space to the next space
				deque.insertLeft(temp);//add that bad boy to the deque object
			}//end for
			
			while(!(deque.isEmpty()))//now until the deque object is empty...
			{
				sentenceReverse += (deque.removeLeft() + " "); //remove a word from the left to make it in the reverse order of how we put it in
															  // also add a space because when we added them into the deque class, that got rid of the spaces
			}//end for
			System.out.println("original: " + sentence);
			System.out.println("reverse: " + sentenceReverse);
			if(sentence.equalsIgnoreCase(sentenceReverse)) //if it the same backwards and forwards, it is a palindrome
			{
				System.out.println("!! Your sentence is a palindrome !!");
			}//end if
			else //if not, it is not a palindrome
			{
				System.out.println(":( your sentence is not a palindrome :(");
			}//end else
		
			System.out.println("\nEnter q to quit. Enter any other key to continue");//ask if they want to continue
			quit = stdIn.nextLine();
		}while(!(quit.equalsIgnoreCase("q")));//if they hit q to quit, the program will stop. if they hit any other key, it will loop again
	}//end main
}//end DequeDriver
