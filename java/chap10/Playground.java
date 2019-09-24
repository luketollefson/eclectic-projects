/*	Testing some stuff
	Luke
*/

public class Playground
{
	public static void main(String[] args)
	{
		B b3 = new B();
		int n = b3.foo2();

		System.out.println(b3.name);

		C c1 = new C();
		c1.foo1();
	}

}

class A
{
	private int number;
	protected String name;
	public double price;

	public A()
	{
		System.out.println("A() called");
	}

	private void foo1()
	{
		System.out.println("A version of foo1() called");
	}

	protected int foo2()
	{
		System.out.println("A version of foo2() called");
		return number;
	}

	public String foo3()
	{
		System.out.println("A version of foo3() called");
		return "Hi";
	}
}

class B extends A
{
	private char service;

	public B()
	{
		super();
		System.out.println("B() called");
	}

	public void foo1()
	{
		System.out.println("B version of foo1() called");
	}

	protected int foo2()
	{
		int n = super.foo2();
		System.out.println("B version of foo2() called");
		return (n + 5);
	}

	public String foo3()
	{
		String temp = super.foo3();
		System.out.println("B version of foo3()");
		return (temp + " foo3");
	}
}

class C extends B
{
	public C()
	{
		super();
		System.out.println("C() called");
	}

	public void foo1()
	{
		System.out.println("C version of foo1() called");
	}
}
