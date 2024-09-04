/* *********************************
 CSC160
 Assignment 4
 Mary Hoette
 
This program creates an ArrayList that
holds Book objects. It has 2 methods. The
first, fillTheStore, adds 2 books to the 
ArrayList books. The second method, getBook,
uses both a for loop and if statement to go
through the ArrayList books and try to find the
title passed to it. If the title is in books,
it prints the title, author and isbn. If not,
it prints a message saying the book isn't found.
 
************************************/

//here I'm importing the ArrayList API
import java.util.ArrayList;

public class Bookstore 
{
	//here I'm making an array list to hold all of the books
	private ArrayList<Book> books = new ArrayList<>();
	
	//this method adds 2 books to the ArrayList books.
	public void fillTheStore()
	{
		books.add(new Book ("Siddhartha", "Hesse", "11111"));
		books.add(new Book ("Lolita", "Nabokov", "22222"));
	}//end fillTheStore
	
	
	public Book getBook(String title)
	{
		for (Book books: books) //for each Book in the ArrayList books
		{
			if (books.getTitle().equals(title)) //if the book has the same title as the one given return the title, author and isbn
			{
				//return (books.getTitle() + " " + books.getAuthor() + " " + books.getIsbn());
				return books;
			}//end if
		}//end for
		return new Book ("Book was not found.", "", ""); //this will only return if a match isn't found
	}
}//end class
