
/* **********************************
 CSC150
 Honors Work - Nin
 Mary Hoette
 
This program plays the game of Nin
where the player decides how many stones
the game starts with and then the player
and computer take turns taking either 1
or 2 stones and the person who takes the
last stone o
 
************************************/

import java.util.Scanner;

public class HonorsNin
{
	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		
		boolean playGame = true; //while this is true, the game will continue
		boolean playerTurn; //this keeps track of whose turn it is. true for the player's turn, false for computer's turn
		boolean validNumber;
		int stoneNumber = 0; //this is the number of stones in the middle pile. I have to set this as something because it is initialized in a do while loop so java doesn't like it
		int takeStones; //this is the number of stones the player is taking on any specific turn
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
				}
				System.out.println(validDigits + " = " + stoneNumberStr.length());
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
			
			do//this is making sure they answer the question with y or n
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
					do //this makes sure the player takes an acceptable number of stones
					{
						playerTurn = true;
						System.out.println("There are " + stoneNumber + " stones left. \nHow many stones would you like to remove? 1 or 2: ");
						takeStones = stdIn.nextInt();
						
						if(takeStones == 1||(takeStones == 2 && stoneNumber > 1))
						{
							validNumber = true;
							stoneNumber = stoneNumber - takeStones;
						}
						else
						{
							if (takeStones != -1)
								System.out.println("You can not take " + takeStones + " stones.");
							else
								System.out.println("You can not take " + takeStones + " stone.");
							validNumber = false;
						}
					}while(!validNumber);
					
					//computer turn
					playerTurn = false;
					if (stoneNumber % 3 == 0 && stoneNumber != 0)
					{
						System.out.println("The computer takes 2 stones.");
						stoneNumber = stoneNumber - 2;
						System.out.println("The number of stones left is " + stoneNumber +".\n");
					}//end if no remainder
					else if (stoneNumber != 0)
					{
						System.out.println("The computer takes 1 stone.");
						stoneNumber = stoneNumber - 1;
						System.out.println("The number of stones left is " + stoneNumber +".\n");
					}
				}while(stoneNumber != 0);//end 
				if (playerTurn)
				{
					System.out.println("You win!! :D \n");
				}
				else
				{
					System.out.println("The Computer wins!! :( \n");
				}
			}//end if goFirst = yes
			
			else if (goFirst.charAt(0) == ('n')) //this
			{
				do
				{
					//computer turn
					playerTurn = false;
					if (stoneNumber % 3 == 0)
					{
						System.out.println("There are " + stoneNumber + " stones left. \nThe computer takes 2 stones.");
						stoneNumber = stoneNumber - 2;
					}//end if no remainder
					else
					{
						System.out.println("There are " + stoneNumber + " stones left. \nThe computer takes 1 stone.");
						stoneNumber = stoneNumber - 1;
					}//end computer turn
					
					//player turn
					if (stoneNumber >0)
					{
						playerTurn = true;
						do //this makes sure the player takes an acceptable number of stones
						{
							playerTurn = true;
							System.out.println("There are " + stoneNumber + " stones left. \nHow many stones would you like to remove? 1 or 2: ");
							takeStones = stdIn.nextInt();
							if(takeStones == 1||(takeStones == 2 && stoneNumber > 1))
							{
								validNumber = true;
								stoneNumber = stoneNumber - takeStones;
							}
							else
							{
								validNumber = false;
							}
						}
						while(!validNumber);
					}//end player turn
				}while(stoneNumber != 0);//end 
				
				System.out.println(stoneNumber);
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
}//end class
