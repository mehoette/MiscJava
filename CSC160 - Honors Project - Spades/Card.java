/* **********************************
 CSC160
 Honors Work - Card.java
 Mary Hoette
 
This program plays the game of Hearts
 
************************************/
public class Card
{
	//this class has 2 instance variables
	private int num; //num is the value 2-14 on the card (11 = jack, 12 = queen, 13 = king, 14 = ace)
	private int suit; //suit represents the playing card suit (0 = clubs, 1 = diamonds, 2 = hearts, 3 = spades)
	
	
	
	//the constructor, getNum and getSuit classes are pretty self explanatory
	public Card(int num, int suit)
	{
		this.num = num;
		this.suit = suit;
	}//end constructor
	
	public int getNum()
	{
		return this.num;
	}//end getNum
	
	public int getSuit()
	{
		return this.suit;
	}//end getSuit
	
	//the display method prints the value and suit of the card
	public void display()
	{
		//this switch statement print the name of the face cards, or just the numerical value
		switch (this.num)
		{
			case 14://if this.num = 14 print Ace
				System.out.print("Ace");
				break;
			case 13://if this.num = 13 print King
				System.out.print("King");
				break;
			case 12://if this.num = 12 print King
				System.out.print("Queen");
				break;
			case 11://if this.num = 11 print Jack
				System.out.print("Jack");
				break;
			default://if it is not a face card, just print the number
				System.out.print(this.num);
				break;
		}//end number switch
		
		switch (this.suit)//this switch statement prints the corresponding suit to number
		{
			case 0://if this.suit = 0 print of Clubs
				System.out.println(" of Clubs");
				break;
			case 1://if this.suit = 1 print of Diamonds
				System.out.println(" of Diamonds");
				break;
			case 2://if this.suit = 2 print of Hearts
				System.out.println(" of Hearts");
				break;
			case 3://if this.suit = 3 print of Hearts
				System.out.println(" of Spades");
				break;
		}//end suit switch
	}//end display
} // end class Card
