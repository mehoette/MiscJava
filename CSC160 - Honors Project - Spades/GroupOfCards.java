/* **********************************
 CSC160
 Honors Work - GroupOfCards.java
 Mary Hoette
 
This program plays the game of Hearts
 
************************************/
import java.util.ArrayList;

public class GroupOfCards 
{
	//make an array list out of Card objects
	private ArrayList<Card> cards = new ArrayList<>();
	private int currentSize = 0;
	
	//most of these methods are pretty self explanatory
	public GroupOfCards(int num)
	{
		this.currentSize = num;
	}//end constructor
	
	public int getCurrentSize()
	{
		return this.currentSize;
	}//end getCurrentSize
	
	public Card getCard(int i)
	{
		return cards.get(i);
	}//end getCard
	
	public void addCard (Card card)
	{
		cards.add(card);
	}//end addCard
	
	public Card removeCard(int index)
	{
		//you have to make a temporary card, so you can both remove it from the list and return it
		Card temp = cards.get(index);
		cards.remove(index);
		this.currentSize--;
		return temp;
	}//end removeCard
	
	public void display()
	{
		//for each card in cards display the card
		for (Card card : cards)
			card.display();
	}//end display
}//end class GroupOfCards







