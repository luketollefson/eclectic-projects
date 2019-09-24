/*	class for rational number
	Luke
*/

public class Rational
{
	private int numerator;
	private int denominator;

	public Rational()
	{
		setNumerator(0);
		setDenominator(1);
	}

	public Rational(int n, int d)
	{
		setNumerator(n);
		if (d != 0)
			setDenominator(d);
		else
		{
			System.err.println("Denominator cannot be zero, set to 1");
			setDenominator(1);
		}
	}

	public Rational add(Rational r)
	{
		return new Rational(numerator+r.numerator,
							denominator+r.denominator);
	}

	public Rational multiply(Rational r)
	{
		return new Rational(numerator*r.numerator,
							denominator*r.denominator);
	}

	public void simplify()
	{
		int d = gcd(numerator, denominator);
		numerator /= d;
		denominator /= d;
	}

	private int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public int getNumerator()
	{
		return numerator;
	}

	public int getDenominator()
	{
		return denominator;
	}

	public void setNumerator(int n)
	{
		numerator = n;
	}

	public void setDenominator(int d)
	{
		if (d != 0)
			denominator = d;
		else
			System.err.println("Denominator cannot be zero, unchanged");
	}

	public String toString()
	{
		return numerator + "/" + denominator;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Rational))
			return false;
		else
		{
			Rational obj = (Rational) o;
			this.simplify();
			obj.simplify();
			if (numerator == obj.numerator
				&& denominator == obj.denominator)
				return true;
			else
				return false;
		}
	}
}
