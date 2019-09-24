/*	client of Student
*/

public class StudentClient
{
	public static void main(String[] args)
	{
		Student stud = new Student("Bill", "123-x5-6789", 3.9604);
		System.out.println(stud);
		stud.setSSN("123-85-6780");
		System.out.println(stud);
		stud.setName("Billybob");
		stud.setGPA(2.0042);

		System.out.println(stud);
		Student stud2 = new Student();
		System.out.println(stud2);
		Student stud3 = new Student("Billybob", "123-85-6780", 2.0042);
		System.out.println(stud3);
		System.out.println(stud.equals(stud3));
	}
}
