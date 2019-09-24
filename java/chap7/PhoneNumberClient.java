/*	Client for phone number
	Luke
*/

public class PhoneNumberClient
{
	public static void main(String[] args)
	{
		PhoneNumber pn = new PhoneNumber("320-759-8097");
		System.out.println(pn);

		pn.setPhoneNumber("02-292-4282");
		System.out.println(pn.getAreaCode());
		System.out.println(pn.getPhoneNumber());
	}
}
