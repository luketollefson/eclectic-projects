/*	TV set
	Luke
*/

import java.text.NumberFormat;

public class TelevisionClient
{
	public static void main(String[] args)
	{
		Television tv = new Television("LG", 200);
		Television tv2 = new Television("LG", 200.006);

		System.out.println(tv.toString());
		System.out.println(tv2.toString());
		System.out.println(tv.equals(tv2));
	}
}

class Television
{
	private String brand;
	private double price;

	public Television()
	{
		brand = "unknown";
		price = 0.0;
	}

	public Television(String brand, double price)
	{
		setBrand(brand);
		setPrice(price);
	}

	public String getBrand()
	{
		return brand;
	}

	public double getPrice()
	{
		return price;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public void setPrice(double price)
	{
		if (price >= 0.0)
			this.price = price;
		else
			System.err.println("Invalid negative price, price unchanged");
	}

	public String toString()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return "Brand: " + brand + "; Price: " + currency.format(price);
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Television))
			return false;
		else
		{
			Television objTV = (Television) o;
			if (brand.equals(objTV.brand)
				&& Math.abs(price - objTV.price) <= 0.005)
				return true;
			else
				return false;
		}
	}
}


