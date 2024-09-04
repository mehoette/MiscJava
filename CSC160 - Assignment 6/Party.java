/* **********************************
 CSC160
 Assignment 6 - Party.java
 Mary Hoette
 
 This program has the party class. It
 includes a constructor, an addGuest
 method, a isOnList helper method, and
 a printParty Method.
 
************************************/
public class Party 
{
	private final int MAX_GUESTS; //this stores the maximum number of guests this can not change, so it is final
	private int numOfGuests = 0; //this stores the actual number of guests
	private String guestNameArray[]; //this is an array that stores the names of the party guests
	private String hostName; //this string holds the host's name
	
	public Party(int maxGuests, String hostName) 
	//this constructor assigns values to MAX_GUESTS and the Host name. 
	//It also initializes the Array for guestNameArray with the amount of slots specified by MAX_GUESTS
	{
		this.MAX_GUESTS = maxGuests;
		this.hostName = hostName;
		guestNameArray = new String[MAX_GUESTS];
	}//end constructor
	
	public void addGuest(String name)
	//this method adds a guest name to guestNameArray if it is not already on the list and if the array isn't full
	{
		//if the numOfGuests is over or equal to MAX_GUESTS, you can't add another name
		if (this.MAX_GUESTS <= this.numOfGuests)
		{
			System.out.println(name + " can not come to the party. The guest list is full.");
		}//end if
		//if the name is already on the list, don't add it twice
		else if(this.isOnList(name))
		{
			System.out.println(name + " is already on the guest list.");
		}//end else if
		else //if the name is allowed to be on the list, add it and increase the numOfGuests by 1
		{
			guestNameArray[numOfGuests] = name;
			this.numOfGuests++;
		}//end else
	}//end addGuest
	
	public boolean isOnList(String name)
	//take a name and see if it is on the list. If yes, return true. If not, return False.
	{
		for(int i = 0; i<MAX_GUESTS; i++)//for each name in the array
		{
			if (name.equals(this.guestNameArray[i]))//if the name is the same as that on the array return true
			{
				return true;
			}
		}//end for statement
		return false; //if it is not the same as any on the list, return false
	}//end isOnList
	
	public void printParty()
	//this method prints the names of the party guests
	{
		System.out.println("Guest list for " + this.hostName + "'s party:");
		for(int i = 0; i<MAX_GUESTS; i++) //for each name on the list, print that name
		{
			System.out.println(this.guestNameArray[i]);
		}//end for
	}//end printParty
}//end class Party
