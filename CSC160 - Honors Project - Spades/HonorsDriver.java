 /* **********************************
 CSC160
 Honors Work - HonorsDriver.java
 Mary Hoette
 
This program plays the game of Hearts
 
************************************/
import java.util.Scanner;
public class HonorsDriver 
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		int numPlayers;
		String playAgain;
		
		do
		{
			System.out.println("How many players?");
			numPlayers = stdIn.nextInt();
			Game game = new Game(4);
			game.playAGame();
			System.out.print("Play Again? (y/n)");
			playAgain = stdIn.next();
		}while (!playAgain.equals("n"));
	} // end main
} // end DeckDriver class
