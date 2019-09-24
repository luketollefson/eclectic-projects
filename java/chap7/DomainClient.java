/*	Using the Domain class
	Luke
*/

public class DomainClient
{
	public static void main(String[] args)
	{
		Domain yahoo = new Domain("www.yahoo.com");
		System.out.println(yahoo);
		System.out.println(yahoo.isWWWDomain());
		System.out.println(yahoo.getDomainExtension());
		System.out.println(yahoo.getDomainName());
		System.out.println(yahoo.getDomain());

		yahoo.setDomain("www.bing.com");
		System.out.println(yahoo);
		yahoo.setDomain("bing.com");
		System.out.println(yahoo.isWWWDomain());
		System.out.println(yahoo.getDomainExtension());
		System.out.println(yahoo.getDomainName());
	}
}
