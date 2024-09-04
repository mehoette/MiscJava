
/* **********************************
 CSC150
 Honors Work - Nin
 Mary Hoette
 
This program plays the game of Nin
where the player decides how many stones
the game starts with and then the player
and computer take turns taking either 1
or 2 stones and the person who takes the
last stone loses.
 
************************************/

import java.util.Scanner;

public class HonorsCleanedUp
{
	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		
		boolean playGame = true; //while this is true, the game will continue
		boolean playerTurn = false; //this keeps track of whose turn it is. true for the player's turn, false for computer's turn
		boolean validNumber;//this is checking 
		int stoneNumber = 0; //this is the number of stones in the middle pile. I have to set this as something because it is initialized in a do while loop so java doesn't like it
		int validDigits = 0;//this will be used to compare the number of valid digits (not letters or symbols) are in a string to the length of a string
		String stoneNumberStr; //this is a string version of the int variable stoneNumber but in string form as to test to make sure it is a number without causing an error 
		String goFirst; //this will be the answer to the question do you want to go first?
		String keepGoing; //this will be the answer to the question do you want to play again?
		
		do //this is the whole game
		{
			do //this is making sure they input a valid number of stones
			{
				System.out.println("Enter the number of starting stones: ");
				stoneNumberStr = stdIn.next(); 
				for (int i = 0; i < stoneNumberStr.length(); i++)
				{
					if (Character.isDigit(stoneNumberStr.charAt(i)))
						validDigits++;
				}//end
				if (validDigits == stoneNumberStr.length())
				{
					stoneNumber = Integer.parseInt(stoneNumberStr); //change stoneNumberStr into an int and store it in stoneNumber
					validNumber = true;
					if (stoneNumber < -1 || stoneNumber == 0) // if the stoneNumber is invalid but not -1
					{
						System.out.println("You cannot start with " + stoneNumber + " stones.");
						validNumber = false;
					}
					else if (stoneNumber == -1)//if the stoneNumber is invalid and -1 
					{
						System.out.println("You cannot start with " + stoneNumber + " stone.");
						validNumber = true;
					}
				}
				else
				{
					System.out.println("Please input a numerical value for starting stones");
					validDigits = 0;
					validNumber = false;
				}
			}while(!validNumber);
			
			do //this is making sure they answer the question with y or n
			{
				System.out.println("Do you want to go first? (y/n)");
				goFirst = stdIn.next();
				if (!(goFirst.equalsIgnoreCase("y") || goFirst.equalsIgnoreCase("n")))
					System.out.println("Please input either y or n");
			}while(!(goFirst.equalsIgnoreCase("y") || goFirst.equalsIgnoreCase("n")));

			if (goFirst.equalsIgnoreCase ("y")) //if the player wants to go first, this if loop will execute and then alternate turns
			{
				do
				{
					//player turn
					stoneNumber = PlayerTurn(stoneNumber, playerTurn, validNumber);
					//computer turn
					stoneNumber = ComputerTurn(stoneNumber, playerTurn);
				}while(stoneNumber > 0);//end 
				if (!playerTurn)
				{
					System.out.println("You win!! :D \n");
				}
				else
				{
					System.out.println("The Computer wins!! :( \n");
				}
			}//end if goFirst = yes
			
			else if (goFirst.charAt(0) == ('n')) //if goFirst = no
			{
				do
				{
					//computer turn
					stoneNumber = ComputerTurn(stoneNumber, playerTurn);
					
					//player turn
					stoneNumber = PlayerTurn(stoneNumber, playerTurn, validNumber);
				}while(stoneNumber > 0);//end 
				
				if (!playerTurn)
				{
					System.out.println("You win!! :D \n");
				}
				else
				{
					System.out.println("The Computer wins!! :( \n");
				}
			}//end else if
		
			do //making sure they answer either y or n
			{
				System.out.println("Do you want to play again? y/n");
				keepGoing = stdIn.next();
				if (!(keepGoing.equalsIgnoreCase("y") || keepGoing.equalsIgnoreCase("n")))
						System.out.println("Please input either y or n");
			}while(!(keepGoing.equalsIgnoreCase("y") || keepGoing.equalsIgnoreCase("n")));
		
			if (keepGoing.equalsIgnoreCase("n"))
			{
					playGame = false;
					System.out.println("Goodbye.");
			}//end if keep going
			validDigits = 0;
		}while(playGame == true);	//end do while loop
	}//end main
	
	public static int PlayerTurn(int stoneNumber, boolean playerTurn, boolean validNumber)
	{
		Scanner stdIn = new Scanner(System.in);
		int takeStones;
		if (stoneNumber > 0)
		{
			playerTurn = true;
			int validDigits; //this is a variable to make sure that the input is only made up of numbers
			do //this makes sure the player takes an acceptable number of stones
			{
				validDigits = 0;
				System.out.println("There are " + stoneNumber + " stones left. \nHow many stones would you like to remove? 1 or 2: ");
				String takeStoneStr = stdIn.next();
				for(int i=0; i < takeStoneStr.length(); i++)
				{
					if (Character.isDigit(takeStoneStr.charAt(i)))
					{
						validDigits++;
					}
				}
				if (validDigits == takeStoneStr.length())
				{
					takeStones = Integer.parseInt(takeStoneStr); //change takeStoneStr into an int and store it in takeStones
					if(takeStones == 1||(takeStones == 2 && stoneNumber > 1))
					{
						validNumber = true;
						stoneNumber = stoneNumber - takeStones;
					}
					else
					{
						if (stoneNumber == 1)
							System.out.println("There is only 1 stone left.");
						else
							System.out.println("Please only take 1 or 2 stones.");
						validNumber = false;
					}
				}
				else
				{
					System.out.println("Please input a numerical value.");
					validNumber = false;
				}
			}while(!validNumber);
		}//end if
		return stoneNumber;
	}//end playerTurn
	
	public static int ComputerTurn(int stoneNumber, boolean playerTurn)
	{
		if (stoneNumber > 0);
		{
			//computer turn
			playerTurn = false;
			if (stoneNumber == 1 || stoneNumber % 3 != 0) //if the number of stones is one or if the number of stones is not divisible by 3, the computer only takes 1 stone
			{
				if (stoneNumber == 1)
					System.out.println("There are" + stoneNumber + " stone left. \nThe computer takes 1 stone.\n");
				else
					System.out.println("There are " + stoneNumber + " stones left. \nThe computer takes 1 stone.\n");
				stoneNumber = stoneNumber - 1;
			}
			else
			{
				System.out.println("There are " + stoneNumber + " stones left. \nThe computer takes 2 stones.\n");
				stoneNumber = stoneNumber - 2;
			}//end if no remainder
		}//end if
		return stoneNumber;
	}//end computerTurn
}//end class