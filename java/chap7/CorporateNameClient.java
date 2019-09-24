/*	class here to make some money shizz
	Luke
*/

public class CorporateNameClient
{
	public static void main(String[] args)
	{
		CorporateName ibm = new CorporateName("IBM");
		System.out.println(ibm);

		ibm.setCorporateName("Machines");
		System.out.println(ibm);
		System.out.println(ibm.getCorporateName());

		System.out.println(ibm.equals(new CorporateName("Machines")));

		System.out.println(ibm.webAddress());
	}
}
