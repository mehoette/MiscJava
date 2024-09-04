/* *********************************
 CSC160
 Assignment 4
 Mary Hoette
 
This program makes Book objects. It
includes a constructor and 3 getter
methods for each of the instance variables.
 
************************************/


public class Book 
{
	//each book has 3 variables: title, author and ibsn
	private String title;
	private String author;
	private String ibsn;
	
	//this is the constructor using the variables made above
	public Book(String title, String author, String ibsn)
	{
		this.title = title;
		this.author = author;
		this.ibsn = ibsn;
	}//end constructor
	
	//the next 3 methods are getter methods
	public String getTitle()
	{
		return this.title;
	}//end getTitle
	public String getAuthor()
	{
		return this.author;
	}
	public String getIsbn()
	{
		return this.ibsn;
	}//end getIsbn
}//end class
