/*	some money shizz
	Luke
*/

public class CorporateName
{
	private String corporateName;

	public CorporateName()
	{
		setCorporateName("");
	}

	public CorporateName(String corporateName)
	{
		setCorporateName(corporateName);
	}

	public String webAddress()
	{
		return "www." + corporateName.toLowerCase() + ".com";
	}

	public String getCorporateName()
	{
		return corporateName;
	}

	public void setCorporateName(String corporateName)
	{
		this.corporateName = corporateName;
	}

	public String toString()
	{
		return "Corporate Name: " + corporateName;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof CorporateName))
			return false;
		else
		{
			CorporateName obj = (CorporateName) o;
			if (corporateName.equals(obj.corporateName))
				return true;
			else
				return false;
		}
	}
}
