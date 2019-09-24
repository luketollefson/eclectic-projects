/*	using MyDouble
	Luke
*/

public class MyDoubleClient
{
	public static void main(String[] args)
	{
		MyDouble doub = new MyDouble(6.9872);
		System.out.println(doub);
		System.out.println(doub.getTruncatedMyDouble(2));
		System.out.println(doub.getMyDouble());
		doub.setMyDouble(Math.PI);
		System.out.println(doub.equals(new MyDouble(Math.PI)));
		System.out.println(doub);
	}
}
