/*	class describing an HTML page
	Luke
*/

public class HTMLPage
{
	private String htmlPage;

	public HTMLPage()
	{
		setHTMLPage("");
	}

	public HTMLPage(String page)
	{
		setHTMLPage(page);
	}

	public boolean areLessAndGreaterBalanced()
	{
		int lessThanSigns = 0;
		int greaterThanSigns = 0;

		for (int i = 0; i < htmlPage.length(); i++)
			if (htmlPage.charAt(i) == '<')
				lessThanSigns++;
			else if (htmlPage.charAt(i) == '>')
				greaterThanSigns++;

		if (lessThanSigns == greaterThanSigns)
			return true;
		else
			return false;
	}

	public int numberOfImages()
	{
		String imageTag = "IMG";
		int images = 0;

		for (int i = 0; i < htmlPage.length()-3; i++)
			if (htmlPage.substring(i,i+3).equals(imageTag))
				images++;

		return images;
	}

	public int numberOfLinks()
	{
		String linkTag = "A HREF";
		int links = 0;

		for (int i = 0; i < htmlPage.length()-6; i++)
			if (htmlPage.substring(i,i+6).equals(linkTag))
				links++;

		return links;
	}

	public String getHTMLPage()
	{
		return htmlPage;
	}

	public void setHTMLPage(String page)
	{
		htmlPage = page;
	}

	public String toString()
	{	
		return "HTML Page:\n" + htmlPage;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof HTMLPage))
			return false;
		else
		{
			HTMLPage obj = (HTMLPage) o;
			if (htmlPage.equals(obj.htmlPage))
				return true;
			else
				return false;
		}
	}
}
