/*	Arithmetic Operators
	Luke
*/

public class ArithmeticOperators
{
	public static void main( String [ ] args )
	{
		// calculate the cost of lunch
		double salad = 5.95;
		double water = .89;
		System.out.println( "The cost of lunch is $"
							  + ( salad + water ) );

		// calculate your age as of a certain year
		int targetYear = 2011;
		int birthYear = 1993;
		System.out.println( "Your age in " + targetYear + " is "
							  + ( targetYear - birthYear ) );

		// calcuate the toatl calories of apples
		int caloriesPerApple = 127;
		int numberOfApples = 3;
		System.out.println( "The calories in " + numberOfApples
							 + " apples is " +
							 + ( caloriesPerApple * numberOfApples ) );
								
		// calcualte miles per gallon
		double miles = 426.8;
		double gallons = 15.2;
		double mileage = miles / gallons;
		System.out.println( "The mileage is "
							+ mileage + " miles per gallon." );
		
		int pennies = 2 * 25 + 3 * 10 + 2 * 5;
		//double result = x ( 2 * y ); // different from x / 2 * y
	}
}
