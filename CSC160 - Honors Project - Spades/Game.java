/* **********************************
 CSC160
 Honors Work - Game.java
 Mary Hoette
 
This program plays the game of Hearts
 
************************************/
import java.util.ArrayList;

public class Game 
{
	public static int PLAYERS = 0;
	
	//alright so you need a deck and 2 arrayLists filled with a Hand for each player and a Trick for each round
	private Deck deck = new Deck();
	private ArrayList<Hand> players = new ArrayList();
	private ArrayList<Trick> tricks = new ArrayList();
	
	//then 
	private int numberOfTricks = 0;
	private boolean hearts = false;//has hearts been broken? if no = false
	private boolean queenOfSpades = false;//has the queen been played? if no = false
	
	//these instance variables are ones I made, not ones in the worksheet
	private boolean firstTurn = true; //if it is the first turn of the first trick you HAVE to play the 2 of clubs
	private int index; //index of the card being played
	private Card card; //a placeholder for the card being played
	private int currentPlayer; //which player is currently playing
	private int leadingSuit;
	
	//easy constructor also makes a hand for each player
	public Game(int numOfPlayers)
	{
		this.PLAYERS = numOfPlayers;
		for (int i = PLAYERS; i > 0; i--)//for each player, make them a hand with an equal number of cards for each player
		{
			players.add(new Hand(i, 52/PLAYERS));
		}//end for
		System.out.println("player 0 hand size =" + players.get(0).getCurrentSize());
	}//end constructor
	
	//the next 3 get methods are self explanitory
	public int getNumberOfTricks()
	{
		return this.numberOfTricks;
	}//end getNumberOfTricks
	
	public boolean getHearts() 
	{
		return this.hearts;
	}//end getHearts
	
	public boolean getQueen() 
	{
		return this.queenOfSpades;
	}//end getQueen
	
	//now this is the method the whole game is based on
	public void playAGame()
	{
		//shuffle the cards and then find out how many undelt cards you will have
		deck.shuffle();
		int cardsLeft = deck.TOTAL_CARDS % this.PLAYERS; //why is this returning 0 it shouldn't
		System.out.println("cardsLeft: " + cardsLeft);
		
		//these 2 for loops deal the cards
		for(int card = (deck.TOTAL_CARDS - cardsLeft) / this.PLAYERS; card > 0; card --)//Iterate for the number of cards that should be in your hand
		{
			//you're going to add a new trick with enough cards for each player
			tricks.add(new Trick(this.PLAYERS));
			numberOfTricks++; //then you're going to increase the number of players by 1 each time
			for (int player = 0 ; player < this.PLAYERS; player ++)//iterate between all the players
			{
				//for each trick you're going to deal one card for each player
				Hand currentPlayer = players.get(player);
				currentPlayer.addCard(deck.dealCard());
			}//end player for loop
		}//end card for loop
		
		//now sort the hand for each player
		for (int player = 0; player < this.PLAYERS; player ++)
		{
			Hand currentPlayer = players.get(player);
			currentPlayer.sort();
			//also print the hand and the suit with the shortest amount of cards
			System.out.println("\tplayer " + (player) + " shortest = " + currentPlayer.getShortest());
			currentPlayer.display();
			System.out.println();
		}//end sort & display for
		
		//now that we have all of the hands set up, we can actually start the game
		//the player with the 2 of clubs always starts, so we need to find the player with the 2 of clubs
		for (int player = 0; player < this.PLAYERS; player ++)
		{
			Hand currentHand = players.get(player);
			System.out.println("Player " + player + " has the 2 of clubs at " + currentHand.find(2,0, currentHand));
			System.out.println("player hand size =" + currentHand.getCurrentSize());
			if ((currentHand.find(2,0,currentHand)) >= 0)//if the 2 of clubs is in this player's hand
			{
				//update index to the index of the 2 of clubs (the last card in the hand)
				this.index = currentHand.find(2,0, currentHand);
				//and 
				this.currentPlayer = player; //make the current player to the player who has the 2 of clubs. this will make them go first
				break; //you don't really NEED this break statement, but it does make it so you don't have to look throught the other hands once you found the 2 of clubs
			}//end if have the club
		}//end finding the 2 of clubs for
		//then the rest repeats every round
		for (int round = 0; round < numberOfTricks; round++)
		{
			Trick currentTrick = tricks.get(round); //get the trick for the current round
			for (int player = 0; player < this.PLAYERS; player++)
			{
				System.out.println("round: " + round + " player: " + currentPlayer);//this is just a placeholder and won't be part of the final code
				Hand currentHand = players.get(currentPlayer); //get the hand of the current player

				if (!firstTurn)
				{
					//use the playACard method if it isn't the first turn. If it is the first turn, you have to play the 2 of clubs
					this.index = currentHand.playACard(this, tricks.get(round));
				}//end else
				//remove the card you are going to play from your hand
				System.out.println(index);
				
				this.card = currentHand.removeCard(index);
				currentTrick.addCard(card); // add it to the trick
				//then update the current trick and the Hearts and Queen
				currentTrick.update(currentPlayer, card);
				this.updateHeartsAndQueen(card);
				//then print the player and the card they played
				System.out.print("player " + currentPlayer + "\t");
				this.card.display();
				
				//then increase the current player
				this.currentPlayer++;
				if (this.currentPlayer % (this.PLAYERS) == 0) //and it it is higher than the number of players,
					this.currentPlayer = 0; //go back to the beginning of the line with player 0
			}//end for each player
			if (firstTurn)
			{
				for (int extras = 0; extras < cardsLeft; extras--)
				{
					System.out.println("hfk");
					System.out.print("undelt card \t ");
					deck.getCard(extras).display();
				}//end print extras for
				firstTurn = false;
			}//end if first turn play cards in deck
			currentPlayer = currentTrick.getWinner();
			System.out.print(currentPlayer);
		}//end rounds
		
		//after the rounds are over print point totals
		for (int player = 0; player < this.PLAYERS; player ++)
			System.out.println("Player " + player + " score = " + computePoints(player));
	}//end playAGame
	
	public void updateHeartsAndQueen(Card card)
	{
		if (card.getSuit() == 2)
		{
			System.out.println("Hearts is now broken");
			this.hearts = true;
		}//end if hearts
		else if (card.getSuit() == 3 && card.getNum() == 12);
		{
			this.queenOfSpades = true;
		}//end else if queen of spades
	}//end updateHeartsAndQueen
	
	private int computePoints(int playerNum)
	{
		int points = 0;
		for (int round = 1; round <= numberOfTricks; round++)
		{
			Trick currentTrick = tricks.get(round);
			if (currentTrick.getWinner() == playerNum)//if this player was the winner
			{
				//go through each card in the trick
				for (int card = 0; card < currentTrick.getCurrentSize(); card++)
				{
					Card currentCard = currentTrick.getCard(card);
					if (currentCard.getSuit() == 2)
					{
						points++; //add one point for every heart you get
					}//end if hearts
					else if (currentCard.getSuit() == 3 && currentCard.getNum() == 12)
					{
						points += 13; //add 13 points if you get the Queen of Spades
					}//end if queen of spades
				}//end for
			}//end if
		}//end for
		return points;
	}//end computePoints
}//end class Game




