/*	class to use Rational
	Luke
*/

public class RationalClient
{
	public static void main(String[] args)
	{
		Rational r = new Rational(10, 3);
		System.out.println(r);
		r.setNumerator(r.getNumerator()+1);
		r.setDenominator(r.getDenominator()+1);
		System.out.println(r);
		System.out.println(r.equals(new Rational(22,8)));

		r = r.add(new Rational(3141,3920));
		r = r.multiply(new Rational(42,92));

		System.out.println(r);
		r.simplify();
		System.out.println(r);
	}
}
