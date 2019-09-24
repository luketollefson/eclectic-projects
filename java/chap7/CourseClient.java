/*	course exapmle
	Luke
*/

public class CourseClient
{
	public static void main(String[] args)
	{
		Course course1 = new Course("CS1", "Introduction to Computer Sciene", 3);
		System.out.println(course1);
		course1.setCode("CS2");
		course1.setDescription("Advanced Computer Science");
		course1.setCredits(4);
		System.out.println(course1);

		Course course2 = new Course("CS2", "Advanced Computer Science", 4);
		System.out.println(course1.equals(course2));

		Course course3 = new Course();
		System.out.println(course1.equals(course3));
	}
}

class Course
{
	private String code;
	private String description;
	private int credits;

	public Course()
	{
		setCode("");
		setDescription("");
	}

	public Course(String code, String description, int credits)
	{
		setCode(code);
		setDescription(description);
		setCredits(credits);
	}

	public String getCode()
	{
		return code;
	}

	public String getDescription()
	{
		return description;
	}

	public int getCredits()
	{
		return credits;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setCredits(int credits)
	{
		this.credits = credits;
	}

	public String toString()
	{
		return "Code: " + code
			 + "; Description: " + description
			 + "; Credits: " + credits;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Course))
			return false;
		else
		{
			Course obj = (Course) o;
			if (code.equals(obj.code)
				&& description.equals(obj.description)
				&& credits == obj.credits)
				return true;
			else
				return false;
		}
	}
}
