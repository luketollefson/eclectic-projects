/*	Testing the print and println methods
	Luke
*/

public class PrintDemo
{
	public static void main(String[] args)
	{
		System.out.println("Combine the arguments using concatenation");
		System.out.println("A double: " + 23.7 + ", and an int: " + 78);

		System.out.print("\nJava is case sensitive: ");
		System.out.println('a' + " is different from " + 'A');

		System.out.println("\nCreate a variable and print its value");
		String s = new String("The grade is");
		double grade = 3.81;
		System.out.println(s + " " + grade);

		/*
		System.out.println();  // skip a line
		SimpleDate d = new SimpleDate(4, 5, 2009);
		System.out.println("Explicitly calling toString, d is "
							+ d.toString());
		System.out.println("Implicitly calling toString, d is " + d);
		*/

		System.exit(0); // optional
	}
}
