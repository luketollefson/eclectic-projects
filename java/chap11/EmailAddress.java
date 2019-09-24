/*	The EmailAddress class
	Luke
*/

public class EmailAddress
{
	public static final char AT_SIGN = '@';
	private String email;

	public EmailAddress(String newEmail) throws IllegalEmailException
	{
		if (newEmail.indexOf(AT_SIGN) != -1)
			email = newEmail;
		else
			throw new IllegalEmailException("Email address does not contain "
												+ AT_SIGN);
	}

	public String getHost()
	{
		int index = email.indexOf(AT_SIGN);
		return email.substring(index + 1, email.length());
	}
}
