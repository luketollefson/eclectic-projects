/*	Using the Student Passwords class
	Luke
*/

public class StudentPasswordsClient
{
	public static void main(String[] args)
	{
		String[] passes = {"Bunny", "Bunny", "Bunny", "Dog1",
						   "132", "42", "952", "4",
						   "nice", "nice1", "nice1", "nice1"};
		StudentPasswords st = new StudentPasswords(passes);

		System.out.println(st);
		System.out.println("Most changed " + st.mostChanged());
		System.out.println("Longest pass " + st.longestPassword());
		System.out.println("contians noice? " + st.containsWord("noice"));

		st.unlock();
		System.out.println(st);
	}
}
