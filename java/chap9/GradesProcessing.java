/*	Processing Each Column in a 2d array
	Luke
*/

public class GradesProcessing
{
	public static void main(String[] args)
	{
		int[][] grades = { {89, 75},
						   {84, 76, 92, 96},
						   {80, 88, 95} };

		int maxNumberOfColumns = grades[0].length;
		for (int i = 1; i < grades.length; i++)
		{
			if (grades[i].length > maxNumberOfColumns)
				maxNumberOfColumns = grades[i].length;
		}
		System.out.println("The maximum number of columns in grades is "
							+ maxNumberOfColumns);

		for (int j = 0; j < maxNumberOfColumns; j++)
		{
			System.out.print("\nColumn " + j + ": ");
			for (int i = 0; i < grades.length; i++)
			{
				if (j < grades[i].length)
					System.out.print(grades[i][j]);
				System.out.print("\t");
			}
		}
		System.out.println();
	}
}
