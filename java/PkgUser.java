import test.TestPkg;

public class PkgUser
{
	public static void main(String[] args)
	{
		TestPkg pkg = new TestPkg(100);
		System.out.println(pkg.getHi());
	}
}
