/*	Using equality operators on floating-point numbers
	Luke
*/

public class EqualityFloatingPoint
{
	public static void main(String[] args)
	{
	// Part 1: computer 11 * .1 two ways

	double d1 = .0;
	d1 += .1;
	d1 += .1;
	d1 += .1;
	d1 += .1;
	d1 += .1;
	d1 += .1;
	d1 += .1;
	d1 += .1;
	d1 += .1;
	d1 += .1; 
	d1 += .1; // 11

	double d2 = .1 * 11;

	System.out.println("d1 = " + d1);
	System.out.println("d2 = " + d2);
	if (d1 == d2)
		System.out.println("d1 and d2 are equal");
	else
		System.out.println("d1 and d2 are not equal");

	// Part 2: Compare float and double with same value

	float piF = 3.141592653589793f;
	double piD = 3.141592653589793;

	System.out.println("piF = " + piF);
	System.out.println("piD = " + piD);
	if (piF == piD)
		System.out.println("piF and piD are equal");
	else
		System.out.println("piF and piD are not equal");

	final double THRESHOLD = .0001;
	if (Math.abs(d1 - d2) < THRESHOLD)
		System.out.println("d1 and d2 are considered equal");
	else
		System.out.println("d1 and d2 are not considered equal");

	if (Math.abs(piF - piD) < THRESHOLD)
		System.out.println("piF and piD are considered equal");
	else
		System.out.println("piF and piD are not considered equal");
	}
}
