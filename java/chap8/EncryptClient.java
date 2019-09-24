/*	using encryption
	Luke
*/

public class EncryptClient
{
	public static void main(String[] args)
	{
		Encrypt encrypt = new Encrypt();
		System.out.println(encrypt);

		String code = "hello world";
		String code2 = encrypt.encode(code);
		System.out.println(code);
		System.out.println(code2);
		System.out.println(encrypt.encode(code2));
		System.out.println(encrypt.decode(code2));
	}
}
