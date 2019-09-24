/*	Using the student grades
	Luke
*/

public class StudentGradesClient
{
	public static void main(String[] args)
	{
		StudentGrades grades = new StudentGrades(400);

		System.out.println(grades.getMedianGrade());
		System.out.println(grades.getHighestGrade());
		System.out.println(grades.getLowestGrade());
		System.out.println(grades.getModeGrade());
	}
}
