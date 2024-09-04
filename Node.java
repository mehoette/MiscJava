/* **********************************
CSC310
Assignment 2
Mary Hoette
3/12/2023
 
This is the node class which has a String
and int variables to hold the key and value
respectively and then 2 pointers to their
left and right children.
************************************/

public class Node {
	public String key;
	public int value;
	public Node rightChild;
	public Node leftChild;
	
	public Node(String key, int value)//when you make a new node
	{
		this.key = key;//put in the input key into the key variable
		this.value = value;//put the input value into the value variable
	}//end constructor
}//end class
