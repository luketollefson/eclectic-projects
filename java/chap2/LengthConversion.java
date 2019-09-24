/*	Length Conversion
	Luke
*/

public class LengthConversion
{
	public static void main(String[] args)
	{
		final double IN_TO_MM = 25.4;

		double inches;
		double millimeters;

		inches = 2;
		millimeters = IN_TO_MM * inches;
		System.out.println(inches + "in is " + millimeters + "mm");

		inches = 5;
		millimeters = IN_TO_MM * inches;
		System.out.println(inches + "in is " + millimeters + "mm");

		inches = 10;
		millimeters = IN_TO_MM * inches;
		System.out.println(inches + "in is " + millimeters + "mm");
	}
}
