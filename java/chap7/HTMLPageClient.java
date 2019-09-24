/*	using the HTMLPage class
	Luke
*/

public class HTMLPageClient
{
	public static void main(String[] args)
	{
		HTMLPage page = new HTMLPage("<IMG>A HREF<\\IMG>");
		System.out.println(page);
		System.out.println(page.areLessAndGreaterBalanced());
		System.out.println(page.numberOfImages());
		System.out.println(page.numberOfLinks());
		page.setHTMLPage("IMG");
		System.out.println(page.equals(new HTMLPage("IMG")));
	}
}
