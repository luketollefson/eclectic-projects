/*	using the coins class
	Luke
*/

public class CoinsClient
{
	public static void main(String[] args)
	{
		Coins pocket = new Coins(10,5,3,2);

		System.out.println(pocket);
		pocket.setQuarters(pocket.getQuarters() + 1);
		pocket.setDimes(pocket.getDimes() + 1);
		pocket.setNickels(pocket.getNickels() + 1);
		pocket.setPennies(pocket.getPennies() + 1);
		System.out.println(pocket);

		System.out.println(pocket.equals(new Coins(11,6,4,3)));	

		System.out.println(pocket.totalValue());
	}
}
