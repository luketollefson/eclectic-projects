/*	a pair complex numbers
	Luke
*/

public class ComplexPair
{
	private Complex complexA;
	private Complex complexB;
	
	public ComplexPair()
	{
		setComplexA(new Complex(0, 0));
		setComplexB(new Complex(0, 0));
	}

	public ComplexPair(Complex cA, Complex cB)
	{
		setComplexA(cA);
		setComplexB(cB);
	}

	public boolean areABEqual()
	{
		if (complexA.equals(complexB))
			return true;
		else
			return false;
	}

	public Complex getComplexA()
	{
		return complexA;
	}

	public Complex getComplexB()
	{
		return complexB;
	}

	public void setComplexA(Complex cA)
	{
		complexA = cA;
	}

	public void setComplexB(Complex cB)
	{
		complexB = cB;
	}

	public String toString()
	{
		return complexA + ", " + complexB;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof ComplexPair))
			return false;
		else
		{
			ComplexPair obj = (ComplexPair) o;
			if (complexA.equals(obj.complexA)
				&& complexB.equals(obj.complexB))
				return true;
			else
				return false;
		}
	}
}
