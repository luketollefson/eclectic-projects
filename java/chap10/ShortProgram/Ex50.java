/*	Exercise 50, some vehicles
	Luke
*/

public class Ex50
{
	public static void main(String[] args)
	{
		Bicycle bike = new Bicycle("Bush");
		System.out.println(bike.getOwner() + " " + bike.getWheels());
		MotorVehicle icu = new MotorVehicle("Nixon", 8.2);
		System.out.println(icu.getOwner() + " hp: " + icu.horsePower());
	}
}

abstract class Vehicle
{
	private String owner;
	private int wheels;

	public Vehicle(String o, int w)
	{
		owner = o;
		wheels = w;
	}

	public String getOwner()
	{
		return owner;
	}

	public int getWheels()
	{
		return wheels;
	}
}

class Bicycle extends Vehicle
{
	public Bicycle(String o)
	{
		super(o, 2);
	}
}

class MotorVehicle extends Vehicle
{
	private double cubicLiters;

	public MotorVehicle(String o, double cl)
	{
		super(o, 4);
		cubicLiters = cl;
	}

	public double horsePower()
	{
		return cubicLiters * getWheels();
	}
}
