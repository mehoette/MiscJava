/* **********************************
 CSC160
 Assignment 6 - PartyDriver.java
 Mary Hoette
 
This program is the driver for the
Party Class
 
************************************/
public class PartyDriver {

	public static void main(String[] args) 
	{
		Party party = new Party(3, "David Beckham");
		party.addGuest("Roberto Baggio");
		party.addGuest("Zinedine Zidane");
		party.addGuest("Roberto Baggio");
		party.addGuest("Johan Cruyff");
		party.addGuest("Diego Maradona");
		party.printParty();
	}//end main
}//end PartyDriver Class
