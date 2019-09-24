/*	Fill in the code exercieses
	Luke
*/

public class FillInTheCode 
{ 
	public static void main(String[] args)
	{
		G g1 = new G("Hello", "We", 'b');
		G g2 = new G("Hello", "We", 'b');
		System.out.println(g1.equals(g2));
	}
}

class F
{
	private String first;
	protected String name;

	public F()
	{ }

	public F(String f, String n)
	{
		first = f;
		name = n;
	}

	public String getFirst()
	{
		return name;
	}

	public String toString()
	{
		return ("first: " + first + "\tname: " + name);
	}
	public boolean equals(Object f)
	{
		if (!(f instanceof F))
			return false;
		else
		{
			F objF = (F) f;
			return (first.equals(objF.first) && name.equals(objF.name));
		}
	}
}

interface I
{
	public static final String TYPE = "human";
	public abstract int age();
}

// class K extends F implements I

// 21
class G extends F
{
	private char middleInitial;

	public G(String f, String n, char mi)
	{
		super(f, n);
		middleInitial = mi;
	}

	public String toString()
	{
		return super.toString() + "; middle initial: " + middleInitial;
	}

	public boolean equals(Object o)
	{
		if (super.equals(o) && this.middleInitial == ((G) o).middleInitial)
			return true;
		else
			return false;
	}
}
