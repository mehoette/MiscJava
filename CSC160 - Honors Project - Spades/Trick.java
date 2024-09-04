/* **********************************
 CSC160
 Honors Work - Trick.java
 Mary Hoette
 
This program plays the game of Hearts
 
************************************/

public class Trick extends GroupOfCards //Trick is a subclass of GroupOfCards
{
	private int winner; //which card is the winner (what place? first card, second card...?)
	private Card winningCard; //what card was it
	private boolean hearts = false; //is there hearts in the trick (1pt for each heart)
	private boolean queen = false; //was the queen of spades in the trick (13 pts for the queen)
	private int cardsInTrick; //I added this variable to count the number of Cards already in the trick
	
	public Trick(int players)
	{
		super(players*2 -1);// you really only need the number of players, but if there are undelt cards
							// we need to leave room for those
	}//end constructor
	
	public void addCard (Card card) //I made this method for myself. It just adds 1 to cardsInTrick to see how many cards are already in the trick
	{
		super.addCard(card);
		cardsInTrick++;
	}//end add Card
	
	//the next 5 methods are self explanatory
	public int getCardsInTrick()
	{
		return this.cardsInTrick;
	}//end get CardsInTrick
	
	public int getWinner()
	{
		return this.winner;
	}//end getWinner
	
	public Card getWinningCard()
	{
		return this.winningCard;
	}//end getWinningCard
	
	public boolean getHearts()
	{
		return this.hearts;
	}//end getHearts
	
	public boolean getQueen()
	{
		return this.queen;
	}//end getQueen
	
	//update
	public void update (int playerNum, Card card)
	{
		if (isWinner(card))//if this card is the winner, set winner to the playerNum & set this card to the winning card
		{
			winner = playerNum;
			winningCard = card;
		}//end if winner
		
		if (card.getSuit() == 2) //if the suit = 2 (which is hearts)
		{
			hearts = true;
		}//end if hearts
		
		if (card.getNum() == 12 && card.getSuit() == 3) //if the card is the Queen(num = 12) of Spades (suit = 3)
		{
			queen = true;
		}//end if Queen of Spades
	}//end update
	
	private boolean isWinner(Card card)
	{
		if (this.winningCard != null &&((this.winningCard.getSuit() != card.getSuit()) || this.winningCard.getNum() > card.getNum()))
			{
				//if there is a winning card and you play off suit or if you play a lower number card, you aren't the winner
				return false;
			}//end if
		else
		{
			//but if you're the first to play or you play a higher suited card, you win.
			return true;
		}//end else
	}//end isWinner
}//ends Trick










