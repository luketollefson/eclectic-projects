/*	Exercise 50, some food stuff
	Luke
*/

public class Ex51
{
	public static void main(String[] args)
	{
		Drink beer = new Drink("Coors Banquet", 100, 0.01);
		System.out.println(beer.totalCalories(5));

		Fruit mango = new Fruit("Mango", 50, Fruit.Season.Summer);
		System.out.println(mango.getSeason());
	}
}

abstract class Food
{
	private String description;
	private int caloriesPerServing;

	public Food(String des, int cps)
	{
		description = des;
		caloriesPerServing = cps;
	}

	public abstract int totalCalories(int servings);

	public String getDescription()
	{
		return description;
	}

	public int getCaloriesPerServing()
	{
		return caloriesPerServing;
	}
}

class Drink extends Food
{
	private double viscosity;

	public Drink(String des, int cps, double vis)
	{
		super(des, cps);
		viscosity = vis;
	}

	public int totalCalories(int servings)
	{
		return servings * getCaloriesPerServing();
	}
}


class Fruit extends Food
{
	public static enum Season {Spring, Summer, Autum, Winter};
	private Season season;

	public Fruit(String des, int cps, Season s)
	{
		super(des, cps);
		season = s;
	}

	public int totalCalories(int servings)
	{
		return servings * getCaloriesPerServing();
	}

	public Season getSeason()
	{
		return season;
	}
}
