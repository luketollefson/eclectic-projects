/*	A Demonstration of Using Constructors
	Luke
*/

public class Constructors
{
	public static void main(String[] args)
	{
		SimpleDate independenceDay = new SimpleDate(7, 4, 1776);
		int independenceMonth = independenceDay.getMonth();
		System.out.println("Independence day is in the month " + independenceMonth);

		SimpleDate graduationDate = new SimpleDate(5, 15, 2012);
		System.out.println("The current day for graducation is " + graduationDate.getDay());

		graduationDate.setDay(12);
		System.out.println("The revised day for graducation is " + graduationDate.getDay());

		SimpleDate currentDay = new SimpleDate(9, 30, 2008);
		System.out.println("The current day is "
						   + currentDay.getMonth() + '/'
						   + currentDay.getDay() + '/'
						   + currentDay.getYear());

		currentDay.nextDay();
		System.out.println("The next day is "
						   + currentDay.getMonth() + '/'
						   + currentDay.getDay() + '/'
						   + currentDay.getyear());

		SimpleDate defualtDate = new SimpleDate();
	}
}
