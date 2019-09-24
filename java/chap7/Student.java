/*	Prudent student
	Luke
*/

import java.text.DecimalFormat;

public class Student
{
	private String name;
	private String ssn;
	private double gpa;

	public Student()
	{
		setName("");
		setSSN("");
	}

	public Student(String name, String ssn, double gpa)
	{
		setName(name);
		setSSN(ssn);
		setGPA(gpa);
	}

	public String getName()
	{
		return name;
	}

	public String getSSN()
	{
		return ssn;
	}

	public double getGPA()
	{
		return gpa;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setSSN(String ssn)
	{
		if (ssn.length() == 11
			&& Character.isDigit(ssn.charAt(0))	
			&& Character.isDigit(ssn.charAt(1))	
			&& Character.isDigit(ssn.charAt(2))	
			&& ssn.charAt(3) == '-'
			&& Character.isDigit(ssn.charAt(4))	
			&& Character.isDigit(ssn.charAt(5))	
			&& ssn.charAt(6) == '-'
			&& Character.isDigit(ssn.charAt(7))	
			&& Character.isDigit(ssn.charAt(8))	
			&& Character.isDigit(ssn.charAt(9))	
			&& Character.isDigit(ssn.charAt(10)))
			this.ssn = ssn;	
		else
			System.err.println("Invalid SSN, SSN unchanged");	
	}

	public void setGPA(double gpa)
	{
		if (gpa >= 0.0 && gpa <= 4.0)
			this.gpa = gpa;
		else
			System.err.println("Invalid GPA, GPA unchanged");
	}

	public String toString()
	{
		DecimalFormat grade = new DecimalFormat("0.0000");
		return "Name: " + name
			+ "; SSN: " + ssn
			+ "; GPA: " + grade.format(gpa);
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Student))
			return false;
		else
		{
			Student obj = (Student) o;
			if (name.equals(obj.name)
				&& ssn.equals(obj.ssn)
				&& Math.abs(gpa - obj.gpa) < 0.00001)
				return true;
			else
				return false;
		}
	}
}
