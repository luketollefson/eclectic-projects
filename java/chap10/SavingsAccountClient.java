/*	Saving accout client
	Luke
*/

public class SavingsAccountClient
{
	public static void main(String[] args)
	{
		SavingsAccount sva = new SavingsAccount(500, .08);
		System.out.println(sva);
		sva.applyInterest();
		System.out.println(sva);
	}
}
