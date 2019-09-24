/*	contains some web stats
	Luke
*/

public class WebStats
{
	private String websiteType;
	private int numberOfVisitors;

	public WebStats()
	{
		setWebsiteType("");
	}

	public WebStats(String websiteType, int numberOfVisitors)
	{
		setWebsiteType(websiteType);
		setNumberOfVisitors(numberOfVisitors);
	}

	public String getWebsiteType()
	{
		return websiteType;
	}

	public int getNumberOfVisitors()
	{
		return numberOfVisitors;
	}

	public void setWebsiteType(String websiteType)
	{
		this.websiteType = websiteType;
	}

	public void setNumberOfVisitors(int nofv)
	{
		this.numberOfVisitors = nofv;
	}

	public String toString()
	{
		return "Website Type: " + websiteType
			+ "; Number of Visitors: " + numberOfVisitors;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof WebStats))
			return false;
		else
		{
			WebStats obj = (WebStats) o;
			if (websiteType.equals(obj.websiteType)
				&& numberOfVisitors == obj.numberOfVisitors)
				return true;
			else
				return false;
		}
	}
}
