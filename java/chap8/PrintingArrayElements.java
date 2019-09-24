/*	Printing array elements
	Luke
*/

public class PrintingArrayElements
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

		System.out.println("Element\tValue");
		for (int i = 0; i < cellBills.length; i++)
		{
			System.out.println(i + "\t" + cellBills[i]);
		}
	}
}
