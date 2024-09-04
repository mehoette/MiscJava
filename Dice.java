
/* **********************************
 CSC150
 Assignment 7 - Dice
 Mary Hoette
 
This program plays a game of dice. In
this game, the player and computer both
roll a six sided die and whoever has the
highest number wins. In this program, 5
rounds are played.
 
************************************/
import java.util.Scanner;

public class Dice 
{
	public static void main(String[] args) 
	{
		//here I'm setting up all of my variables
		Scanner stdIn = new Scanner(System.in);
		boolean playGame = false; //if they answer no to playing the game this let's them skip the game
		String playInput; //this is the input for if they want to play the game or not
		int playerRoll; //this will be the value of the player's dice roll
		int computerRoll;//this will be the value of the player's dice roll
		int playerScore = 0;
		int computerScore = 0;
		
		do
		{
			//so first it asks if the player wants to play the game and only accepts y or n. if the input is anything else it asks the player to retry  
			System.out.print("Lets play a game of dice! We both roll and whoever \nis higher after 5 turns wins! \nDo you want to play? (y/n)");
			playInput = stdIn.next();
			if(playInput.equalsIgnoreCase("y") || playInput.equalsIgnoreCase("n"))
			{
				playGame = true;
			}//end if
			else
			{
				System.out.println("\nPlease input either y or n\n");
			}
		}while(!playGame);//end do while
		if (playInput.equalsIgnoreCase("y"))
		{
			for(int i = 1; i <= 5; i++)
			{
				//this first chunk gives the scores before the game starts
				System.out.println("\n-----------------------------------------------------------\n");
				System.out.println("The score is:");
				System.out.println("You: "+ playerScore);
				System.out.println("Computer: " + computerScore + "\n");
				
				//now the player rolls the dice and the value is displayed
				playerRoll = (int)((Math.random() * 6) + 1);
				System.out.println("Your number is: " + playerRoll);
				
				//now the computer rolls the dice and the value is displayed
				computerRoll = (int)((Math.random() * 6) + 1);
				System.out.println("The computer's number is: " + computerRoll);
				
				//this next chunk displays a message for whoever had the higher roll wins the winner also gets 1 point added to their score
				System.out.println("\n-----------------------------------------------------------");
				if(computerRoll > playerRoll)
				{
					System.out.print("Computer Wins!");
					computerScore ++;
				}//end computer win
				else if(playerRoll > computerRoll)
				{
					System.out.print("You Win!");
					playerScore ++;
				}//end player win
				else
				{
					System.out.print("It is a tie!");
				}//end tie
			}//end for loop
			
			//now I'm printing out the final score board and displaying who won based on the scores that were added up earlier
			System.out.println("\n-----------------------------------------------------------\n");
			System.out.println("The final score is:\nYou: "+ playerScore + "\nComputer: " + computerScore);
			if(computerScore > playerScore)
			{
				System.out.println("\nComputer Wins!");
			}//end computer win
			else if(playerScore > computerScore)
			{
				System.out.println("\nYou Win!");
			}//end player win
			else
			{
				System.out.println("\nIt is a tie!");
			}//end tie
			System.out.println("\nThanks for playing!");
		}
		else
			//if the player does not wish to play the following message is displayed
			System.out.println("\nGoodbye.");
	}//end main
}//end class