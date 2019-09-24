/*	Some parts stuff
	Luke
*/

import java.util.ArrayList;

public class Ex54
{
	public static void main(String[] args)
	{
		SelfMadePart smp = new SelfMadePart("924", 100.00, "924D", 60.00);
		System.out.println(smp.withinBudget());

		ArrayList<String> suppliers = new ArrayList<String>();
		suppliers.add("Pro Shop");
		suppliers.add("Plastics Unlimited");
		suppliers.add("MetalFab Express");
		suppliers.add("Machaigen Materials");

		ArrayList<Double> prices = new ArrayList<Double>();
		prices.add(120.00);
		prices.add(99.99);
		prices.add(300.00);
		prices.add(850.00);

		OutsourcedPart osp = new OutsourcedPart("252", 100.00, suppliers, prices);
		System.out.println(osp.lowestCostSupplier());
	}
}

abstract class Part
{
	private String partNumber;
	private double budgetCost;
	
	public Part(String pn, double bc)
	{
		partNumber = pn;
		budgetCost = bc;
	}

	public String getPartNumber()
	{
		return partNumber;
	}

	public double getBudgetCost()
	{
		return budgetCost;
	}
}

class SelfMadePart extends Part
{
	private String drawingNumber;
	private double cost;

	public SelfMadePart(String pn, double bc, String dn, double c)
	{
		super(pn, bc);
		drawingNumber = dn;
		cost = c;
	}

	public String withinBudget()
	{
		if (cost > getBudgetCost())
			return "over budget";
		else
			return "within budget";
	}
}

class OutsourcedPart extends Part
{
	private class Supplier
	{
		final String source;
		final double price;
		public Supplier(String s, double p)
		{
			source = s;
			price = p;
		}
	}
	private ArrayList<Supplier> suppliers;

	public OutsourcedPart(String pn, double bc, ArrayList<String> als, ArrayList<Double> alp)
	{
		super(pn, bc);
		suppliers = new ArrayList<Supplier>();

		for (int i = 0; i < als.size(); i++)
			suppliers.add(new Supplier(als.get(i), alp.get(i)));
	}

	public String lowestCostSupplier()
	{
		String supplier = suppliers.get(0).source;
		double price = suppliers.get(0).price;
		for (Supplier s : suppliers)
			if (s.price < price)
			{
				supplier = s.source;
				price = s.price;
			}
		
		return supplier;
	}
}
