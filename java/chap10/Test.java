/*	Deggugin java
	Luke
*/

public class Test { }

class N 
{
}

abstract class M
{
	private int n;
	protected double p; 
	public abstract void foo1();
}

class P extends M
{
	public P(double newP)
	{
		p = newP;
	}
	public void foo1() 
	{
	}
}

class Q extends P
{
	private int z;
	public Q(double newP, int newZ)
	{
		super(newP);
		z = newZ;
	}
}
