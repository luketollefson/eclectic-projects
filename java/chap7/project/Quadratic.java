/*	representation of a quadraic equation
	Luke
*/

public class Quadratic
{
	// ax^2 + bx + c
	public double a;
	public double b;
	public double c;

	public Quadratic(double a, double b, double c)
	{
		setA(a);
		setB(b);
		setC(c);
	}

	public double getDiscriminant()
	{
		return (b * b) - 4 * a * c;
	}

   	public ComplexPair findRoots()
   	{
     		double delta = getDiscriminant();

       		if (delta > 0)
           	return new ComplexPair(new Complex((-b+Math.sqrt(delta))/(2*a),0),
                                   new Complex((-b-Math.sqrt(delta))/(2*a),0));
        	else if (Math.abs(delta) < 0.0001)
            		return new ComplexPair(new Complex(-b/(2*a),0),
                                   		   new Complex(-b/(2*a),0));
        	else // imaginary
            		return new ComplexPair(new Complex(-b/(2*a),
                                               		   Math.sqrt(-delta)/(2*a)),
                                   		   new Complex(-b/(2*a),
                                          		       -Math.sqrt(-delta)/(2*a)));
	}

	public double getA()
	{
		return a;
	}

	public double getB()
	{
		return b;
	}

	public double getC()
	{
		return c;
	}

	public void setA(double a)
	{
		this.a = a;
	}

	public void setB(double b)
	{
		this.b = b;
	}

	public void setC(double c)
	{
		this.c = c;
	}

	public String toString()
	{
		return a + "x^2 + "
			+ b + "x "
			+ c;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Quadratic))
			return false;
		else
		{
			Quadratic obj = (Quadratic) o;
			if (a == obj.a
				&& b == obj.b
				&& c == obj.c)
				return true;
			else
				return false;
		}
	}
}
