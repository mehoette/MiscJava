/* **********************************
 CSC160
 Honors Work - Hand.java
 Mary Hoette
 
This program plays the game of Hearts
 
************************************/
public class Hand extends GroupOfCards
{
	public final int NUM; //this is the player Number. Each player has a different hand, so each hand class has a different ID
	private int shortest = 0; //initially clubs, but you don't want it to stay that because you get one out for free

	public Hand(int playerNum, int numberOfCards) 
	{
		super(numberOfCards);
		NUM = playerNum;
	}//end constructor

	
	public void sort()
	//this method sorts the array by both number and suit
	{
		int size = super.getCurrentSize();
		// go through each card one by one
		for (int card = size-1; card >= 0; card--)
		{
			//OK so I struggled a lot with this one but I finally got it.
			//Basically you want to make 3 variables, highestCard, highestCardValue and highestCardIndex
			// start you want to set all of these to be base card you're comparing the others to
			Card highestCard = super.getCard(card);
			int highestCardValue = (13*highestCard.getSuit()+highestCard.getNum()); // each card has a value from 2-53 based on number and suit
			int highestCardIndex = card;
			
			//now compare it to all the other cards
			for (int other = 0; other < card; other++)
			{
				
				Card otherCard = super.getCard(other);
				int otherCardValue = (13*otherCard.getSuit()+otherCard.getNum());
				if (otherCardValue > highestCardValue) //if the other card has a higher value than the first highest card, make the other card the new highest card
				{
					//update all 3 variables
					highestCardValue = otherCardValue;
					highestCard = otherCard;
					highestCardIndex = other;
				}//end if
			}//end in for
			//remove the highest card and then add it back at the end of the sorted part of the array.
			super.removeCard(highestCardIndex);
			super.addCard(highestCard);
			//every time the for loop iterates, compares one less card every time
		}//end out for
	}//end sort
	
	public void setShortest()
	{
		//this will be easier to do once I have the find method :)
		//these variables stores the number of cards of each suit and find that using the findCount method
		int clubNum = findCount(0);
		int diamondNum = findCount(1);
		int spadeNum = findCount(2);
		//in this strategy, you don't want to lead with hearts, so we don't let shortest be hearts(2)
		boolean badSpades = false;//this will turn true if you have the ace, king or queen and want to keep all your spades
		
		
			//if you have the least amount of diamonds, set shortest to 1 (diamonds)
			if (diamondNum <= clubNum && diamondNum <= spadeNum)
				this.shortest = 1;
			//but if you have the least amount of spades and have no bad spades, set shortest to 3 (spades)
			else if(!badSpades && spadeNum <= diamondNum && spadeNum <= clubNum)
				this.shortest = 3;
			//you want to keep all your hearts and you don't want to play your highest spades first and have the queen dumped on you
	}//end setShortest
	
	public int getShortest() //the UML says this should be void, but I think it makes more sense for it to return int
	{
		this.setShortest();// in order to make sure you get the real shortest, set the shortest inside the getShortest method
		return this.shortest;
	}//end getShortest
	
	public int playACard (Game game, Trick trick)
	{
		//this is the method that returns what card you are going to play in that round
		
		int index;//this is the index of the card you are going to play
		int suit;
		
		//if there is not a winning card yet (so you're the first player) return the suit to be -1
		if (trick.getWinningCard() == null)
			suit = -1;
		else//if there is a winning card, make suit the suit of the winning card
			suit = trick.getWinningCard().getSuit();
		if (trick.getCardsInTrick() == 0)
		{
			//if you go first, set the index to the highest card in your shortest suit
			this.setShortest();//set the shortest to not keep it -1
			index = findHighest(shortest);
			if (findHighest(shortest) == -1) //if you don't have one of the suits (and findHighest comes back as -1) just find the lowest card you can play
				index = findLowest(game);
		}//end if you go first
		//else if you go last and there's no points in the trick and you can play on suit and you aren't winning with the queen
		else if (trick.getCardsInTrick() == game.PLAYERS - 1 && !trick.getHearts() && !trick.getQueen() && findLastHigh(suit) >= 0 && findLastHigh(suit) != find(12,2))
			index = findLastHigh(suit); 
		//else if you are in the middle of a hand or in the last hand but you don't want it and you can play on suit
		else if (findHighestBelow(trick.getWinningCard()) >= 0)
			index = findHighestBelow(trick.getWinningCard());
		else if (findMiddleHigh(game, suit) >= 0)
			index = findMiddleHigh(game, suit);
		//if you can't play on suit, you should get rid of one of your bad cards
		else if (find(12,3) >= 0) //get rid of the queen of spades
			index = find(12,3);
		else if (find(14,3) >= 0) //get rid of the ace of spades
			index = find(14,3);
		else if (find(13,3) >= 0) //get rid of the king of spades
			index = find(13,3);
		else
			index = findHighest(); //get rid of your next highest card regardless of suit
		return index; 
	}//end playACard
	
	public int findLowest(int suit) //find the lowest card of a certain suit
	{
		int lowestIndex = -1; //if your hand doesn't have any of this suit, the index will be -1
		int lowestNum = 15;//higher than all the other cards
		for (int card = 0; card < super.getCurrentSize() - 1; card++) //go through every card in your hand
		{
			Card currentCard = super.getCard(card);
			if (currentCard.getSuit() == suit && currentCard.getNum() < lowestNum)//if the current card is on suit and lower than all the other cards
			{
				//update the lowestIndex and lowestNum variables to represent the new lowest card
				lowestIndex = card;
				lowestNum = currentCard.getNum();
			}//end if
		}//end for
		return lowestIndex;//will return the index of the card with the lowest value in that suit. If you don't have that suit it will return -1
	}//end findLowest
	
	public int find(int num, int suit, Hand hand) //in the instructions, they said to make this private, but I think it is easier to make it public to find the 2 of spades
	{
		//you want to find a certain card
		int index = -1;
		System.out.println("0 < " + hand.getCurrentSize());
		for (int card = 0; card < hand.getCurrentSize(); card++)
		//look through each card, if the suit and number match set index to the index of that card
		{
			
			Card currentCard = super.getCard(card);
			if (currentCard.getSuit()==suit && currentCard.getNum()==num)
				index = card;
				
		}//end for
		return index;//return the index of the card. If that card was not found return -1.
	}//end find
	
	private int findCount(int suit)
	{
		int numOfSuit = 0;
		//look at each card in your hand. If it is the suit specified add 1 to numOfSuit
		for (int card = 0; card < super.getCurrentSize(); card++)
		{
			
			System.out.println("findCount round " + card);
			Card currentCard = super.getCard(card);
			if (currentCard.getSuit()==suit)
			{
				numOfSuit++;
			}//end if
		}//end for
		return numOfSuit; //return the number of cards in the suit
	}//end findCount
	
	private int findHighest(int suit)
	{
		int index = -1;
		int highestNum = 0;
		//look through each card in hand
		for (int card = 0; card < getCurrentSize(); card++)//??
		{
			System.out.println("findHighest");
			Card currentCard = getCard(card);
			int currentSuit = currentCard.getSuit();
			int currentNum = currentCard.getNum();
			
			//if the card is on suit and higher than the current highestNumber,
			if (currentSuit == shortest && currentNum > highestNum)
			{
				//update index and highestNum to reflect the new Card
				index = card;
				highestNum = currentNum;
			}//end if
		}//end for
		return index;//return the index of the highest card of that suit. if you don't have that suit return -1
	}//end findHighest 
	
	private int findLowest(Game game)
	{
		//this method finds the lowest card you can play regardless of suit
		int index = -1;
		int lowestNum = 15;//one higher than the highest number
		
		//look at all the cards in your hand
		for (int card = 0; card < super.getCurrentSize(); card--)
		{
			Card currentCard = getCard(card);
			int currentNum = currentCard.getNum();
			int currentSuit = currentCard.getSuit();
			
			//if the current card is lower than the lowest card and isn't hearts before hearts is broken
			if (currentNum < lowestNum && (currentSuit != 2 || !game.getHearts())) //if the currentCard' number is less than the previous lowest card's number and the card is not a heart unless hearts has been broken
			{
				//update index and lowestNum to reflect the new lowest card
				index = card;
				lowestNum = currentNum;
			}//end if
		}//end for
		return index; //return the index of the lowest card, if there isn't one you can play legally (hearts when hearts isn't broken) return -1
	}//end findLowest
	
	private int findLastHigh(int suit)
	{
		//I don't really understand how this is different from the findHighest method
		//this finds the highest number in the suit led
		int winningNum = 0;
		int winningIndex = -1;
		
		//look at each card in your hand
		for (int card = super.getCurrentSize(); card >= 1; card--)
		{
			Card currentCard = super.getCard(card);
			int currentSuit = currentCard.getSuit();
			int currentNum = currentCard.getNum();
			int indexOfQueen = find(12, 3); //index of the queen of spades (you don't want to take the queen of spades)
			
			if (suit == currentSuit && winningNum < currentNum && card != indexOfQueen)//if the card is on suit and is better than the best card so far and isn't the queen of spades (we don't want to play her yet)
			{
				//update winningNum and winningIndex to reflect the new best card in the suit
				winningNum = currentNum;
				winningIndex = card;
			}//end if
		}//end for
		return winningIndex;//return the index of the new winning card, if you don't have any cards of this suit return -1
	}//end findLastHigh
	
	private int findHighestBelow(Card winningCard)
	{
		//here the winning card and the card we want to return are different, so there's more variables
		int winningSuit = winningCard.getSuit();
		int winningNum = winningCard.getNum();
		int nextBestIndex = -1;
		int nextBestNum = 0;
		
		//look at eachcard in your hand
		for (int card = super.getCurrentSize(); card >= 1; card--)
		{
			Card currentCard = super.getCard(card);
			int currentSuit = currentCard.getSuit();
			int currentNum = currentCard.getNum();
			
			if (currentSuit == winningSuit && currentNum > nextBestNum && currentNum < winningNum)//if the card is on suit and better than the current next best card you have, but still worse than the winning card
			{
				//update the nextBestIndex and nextBestNum to reflect the new next best card 
				nextBestIndex = card;
				nextBestNum = currentNum;
			}//end if
		}//end for loop
		return nextBestIndex;//return the next best card. if you don't have a card that is worse of of that suit, return -1
	}//end findHighestBelow
	
	private int findMiddleHigh(Game game, int suit)
	{
	//in this method you want to return the highest card in the suit, but not take the queen of spades on this trick
		int winningNum = 0;
		int winningIndex = -1;
		
		//look at each card in your hand
		for (int card = super.getCurrentSize(); card >= 1; card--)
		{
			Card currentCard = super.getCard(card);
			int currentSuit = currentCard.getSuit();
			int currentNum = currentCard.getNum();
			//if it is on suit and higher than your current best card and one of three things:
			//if isn't spades OR if it is spades, but the number would lose to the queen, OR if the queen was already played
			if (suit == currentSuit && currentNum > winningNum &&((suit != 3 || currentNum < 12 || game.getQueen())))
			{
				//update winningNum and winningIndex to reflect the new winning card
				winningNum = currentNum;
				winningIndex = card;
			}//end if
		}//end for
		return winningIndex; //return the winning card, if you don't have a card that fits the conditions, return -1
	}//end findMiddleHigh
	
	private int findHighest()
	{
		//this method finds the highest card regardless of suit
		int highestNum = 0;
		int highestIndex = -1;
		
		//look at each card in your hand
		for (int card = super.getCurrentSize(); card >= 1; card--)
		{
			Card currentCard = super.getCard(card);
			int currentNum = currentCard.getNum();
			
			//if the current number is higher than the old highest number
			if (currentNum > highestNum)
			{
				//update highestNum and highestIndex to reflect the new highest card
				highestNum = currentNum;
				highestIndex = card;
			}
		}//end for
		return highestIndex; //return the index of the highest card. If you don't have any cards, return -1
	}//end findHighest
}//end Hand