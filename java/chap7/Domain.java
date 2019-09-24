/*	class representing a domain name
	Luke
*/

public class Domain
{
	private String domain;

	public Domain()
	{
		setDomain("unknown");
	}

	public Domain(String domain)
	{
		setDomain(domain);
	}

	public boolean isWWWDomain()
	{
		if (domain.length() >= 4
			&& domain.charAt(0) == 'w'
			&& domain.charAt(1) == 'w'
			&& domain.charAt(2) == 'w'
			&& domain.charAt(3) == '.')
			return true;
		else
			return false;
	}

	public String getDomainExtension()
	{
		String extension = "";
		for (int i = domain.length()-1; i >= 0; i--)
			if (domain.charAt(i) == '.')
				return extension;
			else
				extension = domain.charAt(i) + extension;

		// else
		return "unknown";
	}

	public String getDomainName()
	{
		if (this.isWWWDomain() == false)
			return "unknown";

		String domainName = "";

		for (int i = 4; i < domain.length(); i++)
			if (domain.charAt(i) == '.')
				return domainName;
			else
				domainName += domain.charAt(i);

		// else
		return "unknown";
	}

	public String getDomain()
	{
		return domain;
	}

	public void setDomain(String domain)
	{
		this.domain = domain;
	}

	public String toString()
	{
		return "Domain: " + domain;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Domain))
			return false;
		else
		{
			Domain obj = (Domain) o;
			if (domain.equals(obj.domain))
				return true;
			else
				return false;
		}
	}
}
