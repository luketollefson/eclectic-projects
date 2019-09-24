/*	BookSearchEngine class
	Luke
*/

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BookSearchEngine
{
	public static void main(String[] args)
	{
		BookStore bs = new BookStore();

		String keyword = JOptionPane.showInputDialog(null,
							"Enter a keyword");
		System.out.println("Our book collection is:");
		System.out.println(bs.toString());

		ArrayList<Book> results = bs.searchForTitle(keyword);

		System.out.println("The search results for " + keyword
							+ " are:");
		for (Book tempBook : results)
			System.out.println(tempBook.toString());
	}
}
