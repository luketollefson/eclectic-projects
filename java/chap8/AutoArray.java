/*	Working with an Array of Objects
	Luke
*/

public class AutoArray
{
	public static void main(String[] args)
	{
		// 1. instantiate cars array
		Auto[] cars = new Auto[3];

		// instantiate Auto objects
		Auto sportsCar = new Auto("Ferrari", 100, 15.0);
		cars[0] = sportsCar;
		cars[1] = new Auto();

		System.out.println("cars[0] is a " + cars[0].getModel());

		Auto myCar = cars[1];
		System.out.println("myCar has used " + myCar.getGallonsOfGas()
							+ " gallons of gas");

		// System.out.println("cars[2] is a " + cars[2].getModel());

		System.out.println(cars);
	}
}

