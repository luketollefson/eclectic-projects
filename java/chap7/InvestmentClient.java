/*	using investments
	Luke
*/

public class InvestmentClient
{
	public static void main(String[] args)
	{
		Investment i = new Investment(1000, 0.06);
		System.out.println(i);
		i.setValue(i.getValue()+10000);
		i.setInterestRate(i.getInterestRate()+.008);
		System.out.println(i);

		System.out.println(i.equals(new Investment(11000,0.068)));
		System.out.println(i.futureValue(20));
	}
}
