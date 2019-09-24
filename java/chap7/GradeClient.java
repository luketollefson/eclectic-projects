public class GradeClient
{
	enum Seasons {Winter, Spring, Summer, Fall};
	public static void main(String[] args)
	{
		/* 47
		Grade g = new Grade('B');
		g.setLetterGrade('A');
		*/

		/* 48
		Grade g = new Grade('A');
		*/

		Seasons s = Seasons.Spring;
		if (s.equals(Seasons.Winter))
			System.out.println("It is cold");
		else
			System.out.println("The weather is fine");
	}
}
