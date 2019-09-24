/*	Copying Array Elements to Another Array
	Luke
*/

public class CopyingArrayElements
{
	public static void main(String[] args)
	{
		double[] cellBills = {45.24, 54.67, 42.55, 44.61, 65.29, 49.75};

		double billsBackup[] = new double [cellBills.length];
		for (int i = 0; i < cellBills.length; i++)
		{
			billsBackup[i] = cellBills[i];
		}

		billsBackup[4] = 38.00;

		System.out.println("cellBills\nElement\tValue ");
		for (int i = 0; i < cellBills.length; i++)
		{
			System.out.println(i + "\t" + cellBills[i]);
		}

		System.out.println("\nbillsBackup\nElement\tValue ");
		for (int i = 0; i < billsBackup.length; i++)
		{
			System.out.println(i + "\t" + billsBackup[i]);
		}
	}
}
