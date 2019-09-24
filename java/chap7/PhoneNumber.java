/*	a phone number
	Luke
*/

public class PhoneNumber
{
	private String phoneNumber;

	public PhoneNumber()
	{
		setPhoneNumber("");
	}

	public PhoneNumber(String pn)
	{
		setPhoneNumber(pn);
	}

	public String getAreaCode()
	{
		if (phoneNumber.length() >= 3
			&& Character.isDigit(phoneNumber.charAt(0))
			&& Character.isDigit(phoneNumber.charAt(1))
			&& Character.isDigit(phoneNumber.charAt(2)))
			return phoneNumber.substring(0,3);
		else
			return "unknown area code";
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String pn)
	{
		phoneNumber = pn;
	}

	public String toString()
	{
		return "Phone Number: " + phoneNumber;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof PhoneNumber))
			return false;
		else
		{
			PhoneNumber obj = (PhoneNumber) o;
			if (phoneNumber.equals(obj.phoneNumber))
				return true;
			else
				return false;
		}
	}
}
