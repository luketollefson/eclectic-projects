/*	Temperature Conversion
	Luke
*/

public class TemperatureConversion
{
	public static void main( String [ ] args )
	{
		final double FIVE_NINTHS = 5.0 / 9.0;
		final double NINE_FIFTHS = 9.0 / 5.0;

		int fahrenheit = 40;

		double celsius = FIVE_NINTHS * (fahrenheit - 32);

		System.out.println( fahrenheit + " degrees fhrenheit is "
							+ celsius + " degrees celsius.");

		double newFahrenheit = NINE_FIFTHS * celsius + 32;
		fahrenheit = (int) ( NINE_FIFTHS * celsius + 32 );

		System.out.println( celsius + " degrees celsius is "
							+ fahrenheit + " degrees fahrenheit.");

		
		/*
		float a = 34.2F;
		int a;
		a = 10;
		boolean a = false;
		char a = 'B';

		int a = 3;
		int b = 5;
		int c = 8;
		int total = a * b * c;
		System.out.println( total + " is the total" ); 
		*/

		/*
		int a = 3;
		int b = 5;
		float total = (float) ( a + b ) / 2;
		System.out.println( total + " is the total" );
		*/
		
		/*
		int a = 10;
		int b = 3;
		int remainder = a % b;
		System.out.println( remainder + " is the remainder" );

		int a = 7;
		a++;
		System.out.println( a + " is a" );

		int a = 7;
		a *= 3;

		b = a + 3 - 7;
		b = a * 4;
		a = b * b;
		a = b * 3 * 5;
		b = a / 2;
		b = a % 3;
		*/

		char c = 67;

		System.out.println(c);

		int a = (int) 26.4;
	}
}
