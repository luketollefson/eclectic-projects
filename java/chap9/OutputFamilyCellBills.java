/*	Processing a 2d array of cell phone bills
	Luke
*/

public class OutputFamilyCellBills
{
	public static void main(String[] args)
	{
		double[][] familyCellBills = { {45.24, 54.67, 32.55, 25.61},
									   {65.29, 49.75, 32.08, 26.11},
									   {75.24, 54.53, 34.55, 28.16} };
		
		System.out.println("\tData for family cell bills");

		for (int i = 0; i < familyCellBills.length; i++)
		{
			System.out.print("\nrow " + i + ":\t");
			for (int j = 0; j < familyCellBills[i].length; j++)
			{
				System.out.print(familyCellBills[i][j] + "\t");
			}
		}
		System.out.println();

		for (int i = 0; i < familyCellBills[2].length; i++)
			System.out.print(familyCellBills[2][i] + "\t");

		System.out.println();
	}
}
