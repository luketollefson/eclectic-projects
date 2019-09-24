/**	Auto class, version 1
	Luke
*/

import java.text.DecimalFormat;

public class Auto
{
	private String model;
	private int milesDriven;
	private double gallonsOfGas;
	private final int hello;

	private static int countAutos = 0;


	/**
	* Default constructor:<BR>
	* initializes model to "unknown"<BR>
	* milesDriven are autoinitilized to 0, and gallonsOfGas to 0.0
	*/
	public Auto()
	{
		model = "unknown";
		countAutos++;
		hello = 4;
	}

	public Auto(String startModel, int startMilesDriven, double startGallonsOfGas)
	{
		model = startModel;
		setMilesDriven(startMilesDriven);
		setGallonsOfGas(startGallonsOfGas);
		countAutos++;
		hello = 2;
	}

	public int getHello()
	{
		return this.hello;
	}

	public String getModel()
	{
		return model;
	}

	public int getMilesDriven()
	{
		return milesDriven;
	}

	public double getGallonsOfGas()
	{
		return gallonsOfGas;
	}

	public static int getCountAutos()
	{
		return countAutos;
	}

	public void setModel(String newModel)
	{
		model = newModel;
	}

	public void setMilesDriven(int newMilesDriven)
	{
		if (newMilesDriven >= 0)
			milesDriven = newMilesDriven;
		else
		{
			System.err.println("Miles driven cannot be negative.");
			System.err.println("Value not changed.");
		}
	}

	public void setGallonsOfGas(double newGallonsOfGas)
	{
		if (newGallonsOfGas >= 0.0)
			gallonsOfGas = newGallonsOfGas;
		else
		{
			System.err.println("Gallons of gas cannot ge negative.");
			System.err.println("Value not changed.");
		}
	}

	public double calculateMilesPerGallon()
	{
		if (gallonsOfGas != 0.0)
			return milesDriven / gallonsOfGas;
		else
			return 0.0;
	}

	public String toString()
	{
		DecimalFormat gallonsFormat = new DecimalFormat("#0.0");
		return "Model: " + model
			   + "; miles driven: " + milesDriven
			   + "; gallons of gas: "
			   + gallonsFormat.format(gallonsOfGas);
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Auto))
			return false;
		else
		{
			Auto objAuto = (Auto) o;
			if (model.equals(objAuto.model)
				&& milesDriven == objAuto.milesDriven
				&& Math.abs(gallonsOfGas - objAuto.gallonsOfGas)
											< 0.0001)
				return true;
			else
				return false;
		}
	}
}
