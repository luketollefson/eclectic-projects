/*	a double with more feautres
	Luke
*/

public class MyDouble
{
	private double myDouble;

	public MyDouble(double d)
	{
		setMyDouble(d);
	}

	public double getTruncatedMyDouble(int n)
	{
		return Math.floor(myDouble * Math.pow(10,n)) / Math.pow(10,n);
	}

	public double getMyDouble()
	{
		return myDouble;
	}

	public void setMyDouble(double d)
	{
		myDouble = d;
	}

	public String toString()
	{
		return "" + myDouble;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof MyDouble))
			return false;
		else
		{
			MyDouble obj = (MyDouble) o;
			if (myDouble == obj.myDouble)
				return true;
			else
				return false;
		}
	}
}
