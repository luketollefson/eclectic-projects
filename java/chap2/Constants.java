/*	Constants Class
	Luke Tollefson
*/

public class Constants
{
	public static void main( String [ ] args )
	{
		final char ZORRO = 'Z';
		final double PI = 3.14159;
		final int DAYS_IN_LEAP_YEAR = 366, DAYS_IN_NON_LEAP_YEAR = 365;

		System.out.println( "The value of constant ZORRO is " + ZORRO );
		System.out.println( "The value of constant PI is " + PI );
		System.out.println( "The number of days in a leap year is "
							  + DAYS_IN_LEAP_YEAR );
		System.out.println( "The number of days in a non-leap year is "
							  + DAYS_IN_NON_LEAP_YEAR );
		
		// PI = 3.14;
		// The statement avoe would generate a compiler error
		// You cannot change the value of a constant
	}
}
