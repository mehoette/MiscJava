import java.util.ArrayList;

//this is just to test things

public class Test
{
	public static void main(String args[])
	{
//		Hand test = new Hand(1, 4);
//		Card card1 = new Card(14, 0);
//		Card card2 = new Card(13, 3);
//		Card card3 = new Card(14, 2);
//		Card card4 = new Card(14, 3);
//		
//		test.addCard(card1);
//		test.addCard(card2);
//		test.addCard(card3);
//		test.addCard(card4);
//		
//		
//		test.display();
//		System.out.println();
//		
//		test.sort();
//		
//		System.out.println();
//		test.display();
		
		
//		Deck deck = new Deck();
//		int num = 2;
//		int suit = 0;
//		for(int card = Deck.TOTAL_CARDS; card > 0; card --)
//		{
//			
//			deck.addCard(new Card(num, suit));
//			num ++;
//			if (num % 15 == 0)//once you get to the highest number (14/ace)
//			{
//				num = 2;//reset num back down to 2
//				suit++;//move on to the next suit
//			}//end if
//		}//end for
//		deck.display();
		
		
		Game game = new Game(4);
//		ArrayList<Trick> tricks = new ArrayList();
		
	
		game.playAGame();
	}//end main
}//end class