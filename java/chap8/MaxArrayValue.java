/*	Summing Array Elements
	Luke
*/

import java.text.NumberFormat;

public class MaxArrayValue
{
	public static void main(String[] args)
	{
		double[] cellBills = new double[6];
		cellBills[0] = 45.24;
		cellBills[1] = 54.67;
		cellBills[2] = 42.55;
		cellBills[3] = 44.61;
		cellBills[4] = 65.29;
		cellBills[5] = 49.75;

		int maxIndex = 0;	// initialize total
		for (int i = 0; i < cellBills.length; i++)
		{
			if (cellBills[i] > cellBills[maxIndex])
				maxIndex = i;
		}

		NumberFormat priceFormat = NumberFormat.getCurrencyInstance();
		System.out.println("Total for the bill: "
							+ priceFormat.format(cellBills[maxIndex])
							+ ", was found at index " + maxIndex);
	}
}
