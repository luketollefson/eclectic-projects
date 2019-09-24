/*	Wight Conversion
	Luke
*/

public class WeightConversion
{
	public static void main(String[] args)
	{
		final double KG_TO_LBS = 0.454;
		double kilos;
		double pounds;

		kilos = 10;
		pounds = KG_TO_LBS * kilos;
		System.out.println(kilos + "kg is " + pounds + "lbs.");

		kilos = 50;
		pounds = KG_TO_LBS * kilos;
		System.out.println(kilos + "kg is " + pounds + "lbs.");

		kilos = 100;
		pounds = KG_TO_LBS * kilos;
		System.out.println(kilos + "kg is " + pounds + "lbs.");
	}
}
