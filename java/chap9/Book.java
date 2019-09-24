/*	Book class
	Luke
*/

public class Book
{
	private String title;
	private String author;
	private double price;

	/**	default constructor
	*/
	public Book()
	{
		title = "";
		author = "";
		price = 0.0;
	}

	/** overloaded constructor
	*	@param newTitle		the value to assign to title
	*	@param newAuthor	the value to assign to author
	*	@param newPrice		the value to assign to price
	*/
	public Book(String newTitle, String newAuthor, double newPrice)
	{
		title = newTitle;
		author = newAuthor;
		price = newPrice;
	}

	/** getTitle method
	*	@return the title
	*/
	public String getTitle()
	{
		return title;
	}

	/** getAuthor method
	*	@return the author
	*/
	public String getAuthor()
	{
		return author;
	}

	/**	getPrice method
	*	@return the price
	*/
	public double getPrice()
	{
		return price;
	}

	/** toString
	*	@return title, author, and price
	*/
	public String toString()
	{
		return ("title: " + title + "\t"
				+ "author: " + author + "\t"
				+ "price: " + price);
	}
}
