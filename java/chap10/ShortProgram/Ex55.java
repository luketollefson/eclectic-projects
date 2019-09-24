/*	some number stuff
	Luke
*/

public class Ex55
{
	public static void main(String[] args)
	{
		RationalNumber rn = new RationalNumber(11, 5);
		System.out.println(rn);
		rn.square();
		System.out.println(rn);

		ComplexNumber cn = new ComplexNumber(-11, +17);
		System.out.println(cn);
		cn.square();
		cn.square();
		cn.square();
		cn.square();
		cn.square();
		cn.square();
		cn.square();
		System.out.println(cn);
	}
}

abstract class Number
{
	public abstract void square();
}

class RationalNumber extends Number
{
	private int numerator;
	private int denominator;

	public RationalNumber(int n, int d)
	{
		numerator = n;
		denominator = d;
	}

	public void square()
	{
		numerator *= numerator;
		denominator *= denominator;
	}

	public String toString()
	{
		return numerator + "/" + denominator;
	}
}

class ComplexNumber extends Number
{
	private double real;
	private double imaginary;

	public ComplexNumber(double r, double i)
	{
		real = r;
		imaginary = i;
	}

	public void square()
	{
		double tempReal = real * real - (imaginary * imaginary);
		double tempImaginary = 2 * (real * imaginary);

		real = tempReal;
		imaginary = tempImaginary;
	}

	public String toString()
	{
		if (imaginary == 0)
			return "" + real;
		else if (real == 0)
			return "" + imaginary + "i";
		else if (imaginary > 0)
			return "" + real + "+" + imaginary + "i";
		else
			return "" + real + imaginary + "i";
	}
}
