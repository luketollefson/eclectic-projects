/*	Fill In The Code exercies
	Luke
*/

public class FillInTheCode
{
	private int grade;
	private char letterGrade;

	public static final double FEDERAL_TAX_RATE = .07;

	private String name;
	private int number;
	private boolean cable;

	public FillInTheCode()
	{
		name = "";
		number = 0;
		cable = false;
	}

	public FillInTheCode(String name, int number, boolean cable)
	{
		setName(name);
		setNumber(number);
		setCable(cable);
	}

	public int numberOfDigits()
	{
		String digits = number + "";
		return digits.length();
	}

	public String cableOrNetwork()
	{
		return (cable ? "cable" : "network");
	}

	public String getName()
	{
		return name;
	}

	public int getNumber()
	{
		return number;
	}

	public boolean getCable()
	{
		return cable;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public void setCable(boolean cable)
	{
		this.cable = cable;
	}

	public String toString()
	{
		return "Name " + name
			   + "; Number " + number
			   + "; Cable? " + cable;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof FillInTheCode))
			return false;
		else
		{
			FillInTheCode objFillInTheCode = (FillInTheCode) o;
			if (name.equals(objFillInTheCode.name)
				&& number == objFillInTheCode.number
				&& cable == objFillInTheCode.cable)
				return true;
			else
				return false;
		}
	}
}
