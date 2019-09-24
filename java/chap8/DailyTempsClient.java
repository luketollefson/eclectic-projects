/*	using the daily temps class
	Luke
*/

public class DailyTempsClient
{
	public static void main(String[] args)
	{
		int[] a = {10,90,110,34,73,60,80};
		DailyTemps temps = new DailyTemps(a);
		System.out.println(temps);

		int[] b = temps.sortDailyTemps();
		DailyTemps temps2 = new DailyTemps(b);
		System.out.println(temps2);

		System.out.println(temps.largestChange());
		System.out.println(temps.freezingDays());
		System.out.println(temps.hotDays());
	}
}
