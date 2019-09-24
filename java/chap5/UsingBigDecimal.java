/*	Using BigDecimal to compute percise decimal numbers
	Luke
*/

import java.math.BigDecimal;

public class UsingBigDecimal
{
	public static void main(String[] args)
	{
		BigDecimal d1 = new BigDecimal("0.0");
		BigDecimal pointOne = new BigDecimal("0.1");

		d1 = d1.add(pointOne);
		d1 = d1.add(pointOne);
		d1 = d1.add(pointOne);
		d1 = d1.add(pointOne);
		d1 = d1.add(pointOne);
		d1 = d1.add(pointOne);
		d1 = d1.add(pointOne);
		d1 = d1.add(pointOne);
		d1 = d1.add(pointOne);
		d1 = d1.add(pointOne);
		d1 = d1.add(pointOne);

		BigDecimal d2 = new BigDecimal("0.1");
		BigDecimal eleven = new BigDecimal("11");
		d2 = d2.multiply(eleven);

		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		if (d1.compareTo(d2) == 0)
			System.out.println("d1 and d2 are equal");
		else
			System.out.println("d1 and d2 are not equal");
	}
}
