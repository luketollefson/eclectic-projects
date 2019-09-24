/*	Using the sales tax class
	Luke
*/

import java.util.ArrayList;

public class SalesTaxClient
{
	public static void main(String[] args)
	{
		SalesTax st = new SalesTax();
		System.out.println(st);

		System.out.println("State " + (st.highestAvgTax()+1)
					+ " has the highest average tax");

		System.out.print("States with low taxes: ");
		ArrayList<Integer> lowTaxes = st.lowTaxStates();
		for (int i : lowTaxes)
			System.out.print((i+1) + " ");
		System.out.println();

		System.out.println("State 50's highest tax is "
					+ st.highestTax(49));
	}
}
