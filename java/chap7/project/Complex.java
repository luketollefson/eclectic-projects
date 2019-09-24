/*	represents complex number
	Luke
*/

public class Complex
{
	private double real;
	private double imaginary;

	public Complex(double r, double i)
	{
		setReal(r);
		setImaginary(i);
	}

	public boolean isReal()
	{
		if (imaginary == 0)
			return true;
		else
			return false;
	}

	public double getReal()
	{
		return real;
	}

	public double getImaginary()
	{
		return imaginary;
	}

	public void setReal(double r)
	{
		real = r;
	}

	public void setImaginary(double i)
	{
		imaginary = i;
	}

	public String toString()
	{
		if (imaginary == 0)
			return "" + real;
		else if (real == 0)
			return imaginary + "i";
		else if (imaginary >= 0)
			return real + "+" + imaginary + "i";
		else
			return "" + real + imaginary + "i";
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Complex))
			return false;
		else
		{
			Complex obj = (Complex) o;
			if (real == obj.real
				&& imaginary == obj.imaginary)
				return true;
			else
				return false;
		}
	}
}
