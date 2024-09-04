/* **********************************
 CSC160
 Honors Work - Deck.java
 Mary Hoette
 
This program plays the game of Hearts
 
************************************/

public class Deck extends GroupOfCards //Deck is a subclass of GroupOfCards
{
	public final static int TOTAL_CARDS = 52; //there are always 52 cards in a deck
	
	public Deck() //this calls the superclass constructor and also fills the deck (cards 2-14, suits 0-3)
	{
		super(TOTAL_CARDS);
		
		//this for loop runs 52 times and creates the 52 cards in the deck
		int suit = 0;
		int num = 2;

		for(int card = TOTAL_CARDS; card > 0; card --)
		{
			
			this.addCard(new Card(num, suit));
			num ++;
			if (num % 15 == 0)//once you get to the highest number (14/ace)
			{
				num = 2;//reset num back down to 2
				suit++;//move on to the next suit
			}//end if
		}//end for
	}//end constructor
	
	//shuffle randomizes the order of the cards
	
	public void shuffle()
	{
		for (int unshuffled = super.getCurrentSize(); unshuffled > 1; unshuffled--)
		{
			Card temp = super.removeCard((int)(Math.random()*52)); //remove the card in a random place
			super.addCard(temp);//put the removed card back in the in at the high end of the array
		}//end for
	}//end shuffle
	
	//to deal a card remove the first card in the deck
	public Card dealCard()
	{
		return (super.removeCard(0));
	}//end dealCard
} // end Deck class
