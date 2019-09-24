/*	MetricLength - converts inches to centimeters
	Luke
*/

public class MetricLength
{
	public static void main( String [ ] args )
	{
		final double CM_PER_INCH = 2.54;

		double inches = 12.2;

		double centimeters = inches * CM_PER_INCH;

		System.out.println( inches + " inches are equivalent to "
							 + centimeters + " centimeters." );
	}
}
