/*	Array of Cell Phone Bills
	Luke
*/

public class CellBills
{
	public static void main(String[] args)
	{
		// declare and instantiate the arry
		double[] cellBills = new double[6];

		// assign values to arry elements
		cellBills[0] = 45.24;
		cellBills[1] = 54.67;
		cellBills[2] = 42.55;
		cellBills[3] = 44.61;
		cellBills[4] = 65.29;
		cellBills[5] = 49.75;

		System.out.println("The first monthly cell bill is "
						+ cellBills[0]);
		System.out.println("The last monthly cell bill is "
						+ cellBills[cellBills.length - 1]);
	}
}
