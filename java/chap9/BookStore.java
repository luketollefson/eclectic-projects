/*	BookStore class
	Luke
*/

import java.util.ArrayList;

public class BookStore
{
	private ArrayList<Book> library;

	/** default constructor
	*	instantiates ArrayList of Books
	*/
	public BookStore()
	{
		library = new ArrayList<Book>();
		library.add(new Book("Intro to Java", "James", 56.99));
		library.add(new Book("Advanced Java", "Green", 56.99));
		library.add(new Book("Java Servlets", "Brown", 56.99));
		library.add(new Book("Intro to HTML", "James", 56.99));
		library.add(new Book("Intro to Flash", "James", 56.99));
		library.add(new Book("Advanced HTML", "Green", 56.99));
		library.trimToSize();
	}

	/** toString
	*	@return each book in library, one per line
	*/
	public String toString()
	{
		String result = "";
		for (Book tempBook : library)
		{
			result += tempBook.toString() + "\n";
		}
		return result;
	}

	/** Generates list of books containing searchString
	*	@param searchString the keyword to search for
	*	@return		the ArrayList of books containing the keyword
	*/
	public ArrayList<Book> searchForTitle(String searchString)
	{
		ArrayList<Book> searchResult = new ArrayList<Book>();
		for (Book currentBook : library)
		{
			if ((currentBook.getTitle()).indexOf(searchString) != -1)
				searchResult.add(currentBook);
		}
		searchResult.trimToSize();
		return searchResult;
	}
}
