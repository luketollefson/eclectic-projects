/*	Client to exercise class
	Luke
*/

public class FillInTheCodeClient
{
	public static void main(String[] args)
	{
		FillInTheCode obj = new FillInTheCode("wow", 131, false);

		System.out.println(obj.numberOfDigits());
		System.out.println(obj.cableOrNetwork());
		System.out.println(obj.toString());
	}
}
