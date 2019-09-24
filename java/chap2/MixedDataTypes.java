/*	MixedDataTypes Class
	Luke
*/

public class MixedDataTypes
{
	public static void main( String [ ] args )
	{
		final double PI = 3.14159;
		int radius = 4;

		double area = PI * radius * radius;
		System.out.println( "The area is " + area );

		int total = 365, count = 4;
		double average = total / count;
		System.out.println( "\nPerforming integer division, "
							+ "then implicit typecasting" );
		System.out.println( "The average test score is " + average );
		// 91.0 INCCORECT ANSWRE!

		average = ( double ) (total / count );
		System.out.println( "\nPerforming integer division, "
							+ "then explicit typecasting" );
		System.out.println( "The average test score is " + average );
		// 91.0 INCORRECT ANSER!

		average = ( double ) total / count;
		System.out.println( "\nTypecast one variable to double, "
							+ "then perform division" );
		System.out.println( "The average test score is " + average );
		// 91.25 CORRECT ANSWER
	}
}
