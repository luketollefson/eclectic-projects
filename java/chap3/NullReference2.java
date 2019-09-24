/*	A demonstration of trying to use a null object reference
	Luke
*/

public class NullReference2
{
	public static void main(String[] args)
	{
		SimpleDate independenceDay = new SimpleDate(7, 4, 1776);
		System.out.println("The month of independenceDay is "
						   + independenceDay.getMonth());

		independenceDay = null;
		// attempt to use object referene
		System.out.println("The month of independenceDay is "
						   + independenceDay.getMonth());
	}
}
