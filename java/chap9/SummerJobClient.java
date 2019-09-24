/*	Using the Summer Job class
	Luke
*/

import java.text.NumberFormat;

public class SummerJobClient
{
	public static void main(String[] args)
	{
		SummerJob job = new SummerJob(20, 6);
		System.out.println(job + "\n");

		System.out.println("The person to make the most is "
					+ (job.getHighestPayed()+1));

		System.out.println("The highest salary was earned on year "
					+ (job.yearOfHighestEarnings()+1));

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("The total amount payed is " 
					+ currency.format(job.totalPayed()));

	}
}

