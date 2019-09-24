/*	Some college stuff
	Luke
*/

public class Ex52
{
	public static void main(String[] args)
	{
		UndergradApplicant udrg = new UndergradApplicant("Luke", "NDSU", 30, 3.9604);
		System.out.println(udrg.getGPA());

		GradApplicant grdg = new GradApplicant("Rachel", "UOC", "UND");
		System.out.println(grdg.source());
	}
}

abstract class CollegeApplicant
{
	private String applicant;
	private String college;

	public CollegeApplicant(String ap, String co)
	{
		applicant = ap;
		college = co;
	}

	public String getApplicant()
	{
		return applicant;
	}

	public String getCollege()
	{
		return college;
	}
}

class UndergradApplicant extends CollegeApplicant
{
	private int satScore;
	private double gpa;

	public UndergradApplicant(String ap, String co, int sat, double gpa)
	{
		super(ap, co);
		satScore = sat;
		this.gpa = gpa;
	}

	public int getSATScore()
	{
		return satScore;
	}

	public double getGPA()
	{
		return gpa;
	}
}

class GradApplicant extends CollegeApplicant
{
	private String collegeOrigin;

	public GradApplicant(String ap, String co, String from)
	{
		super(ap, co);
		collegeOrigin = from;
	}

	public String source()
	{
		if (collegeOrigin.equals(getCollege()))
			return "from inside";
		else
			return "from outside";
	}

	public String getCollegeOrigin()
	{
		return collegeOrigin;
	}
}
