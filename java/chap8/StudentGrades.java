/*	Student grade class
	Luke
*/

import java.util.Random;

public class StudentGrades
{
	private int[] studentGrades;

	public StudentGrades(int numberOfStudents)
	{
		Random rand = new Random();
		studentGrades = new int[numberOfStudents];
		for (int i = 0; i < numberOfStudents; i++)
			studentGrades[i] = rand.nextInt(101);
	}

	public int getModeGrade()
	{
		int[] grades = new int[101];

		for (int i = 0; i < studentGrades.length; i++)
			grades[studentGrades[i]]++;

		int index = 0;
		for (int i = 1; i < grades.length; i++)
			if (grades[i] > grades[index])
				index = i;

		return index;
	}

	public double getMedianGrade()
	{
		int[] sortedGrades = sortStudentGrades();

		double median;
		int l = sortedGrades.length;
		if (l % 2 == 0)
			median = ((double) sortedGrades[l/2] + sortedGrades[l/2-1])/2;
		else
			median = (double) sortedGrades[l/2];

		return median;
	}

	public int getLowestGrade()
	{
		int min = studentGrades[0];

		for (int i = 0; i < studentGrades.length; i++)
			min = Math.min(min, studentGrades[i]);

		return min;
	}

	public int getHighestGrade()
	{
		int max = studentGrades[0];

		for (int i = 0; i < studentGrades.length; i++)
			max = Math.max(max, studentGrades[i]);

		return max;
	}

	public int[] sortStudentGrades()
	{
		int[] array = new int[studentGrades.length];

		for (int i = 0; i < studentGrades.length; i++)
			array[i] = studentGrades[i];

		int j, temp;

		for (int i = 1; i < array.length; i++)
		{
			j = i;
			temp = array[i];

			while (j != 0 && array[j - 1] > temp)
			{
				array[j] = array[j - 1];
				j--;
			}

			array[j] = temp;
		}

		return array;
	}

	public int[] getStudentGrades()
	{
		int[] grades = new int[studentGrades.length];

		for (int i = 0; i < studentGrades.length; i++)
			grades[i] = studentGrades[i];

		return grades;
	}

	public void setStudentGrades(int[] grades)
	{
		studentGrades = new int[grades.length];

		for (int i = 0; i < grades.length; i++)
			studentGrades[i] = grades[i];
	}

	public String toString()
	{
		String s = "";
		for (int i = 0; i < studentGrades.length; i++)
			s += studentGrades[i] + " ";

		s += "\n";
		return s;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof StudentGrades))
			return false;
		else
		{
			StudentGrades obj = (StudentGrades) o;
			if (studentGrades.length != obj.studentGrades.length)
				return false;

			for (int i = 0; i < studentGrades.length; i++)
				if (studentGrades[i] != obj.studentGrades[i])
					return false;

			return true;
		}
	}
}
