/*	Web stats client
	Luke
*/

public class WebStatsClient
{
	public static void main(String[] args)
	{
		WebStats webstats = new WebStats("commercial", 100000);
		System.out.println(webstats);
		webstats.setWebsiteType("buisness");
		webstats.setNumberOfVisitors(10);

		System.out.println(webstats);
		System.out.println(webstats.getWebsiteType() + webstats.getNumberOfVisitors());
		WebStats webstats2 = new WebStats("buisness", 10);
		System.out.println(webstats.equals(webstats2));
	}
}
