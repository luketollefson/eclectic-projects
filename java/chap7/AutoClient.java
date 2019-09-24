/*	Auto Client, Version 1
	Luke
*/

public class AutoClient
{
	public static void main(String[] args)
	{
		Auto suv = new Auto("Trailblazer", 7000, 437.5);

		System.out.println("suv: model is " + suv.getModel()
					+ "\n miles driven is " + suv.getMilesDriven()
					+ "\n gallons of gas is " + suv.getGallonsOfGas());

		suv.setModel("Sportage");
		suv.setMilesDriven(200);
		suv.setGallonsOfGas(10.5);

		System.out.println("suv: model is " + suv.getModel()
					+ "\n miles driven is " + suv.getMilesDriven()
					+ "\n gallons of gas is " + suv.getGallonsOfGas());

		suv.setMilesDriven(-1);

		System.out.println("suv: model is " + suv.getModel()
					+ "\n miles driven is " + suv.getMilesDriven()
					+ "\n gallons of gas is " + suv.getGallonsOfGas());

		double mileage = suv.calculateMilesPerGallon();
		System.out.println("Mileage for suv is " + mileage);

		Auto sporty = new Auto("Spyder", 0, 0.0);
		System.out.println(sporty.toString());

		Auto compact = new Auto("Accent", 0, 0.0);
		System.out.println();
		System.out.println(compact);

		if (compact.equals(sporty))
			System.out.println("\nsporty and compact are equal");
		else
			System.out.println("\nsporty and compact are not equal");

		System.out.println("\nAfter initlizing some autos, the number "
							+ "of Auto objects is " + Auto.getCountAutos());

		Auto bestauto = new Auto();
		System.out.println(compact.getHello());
		System.out.println(bestauto.getHello());
	}
}
