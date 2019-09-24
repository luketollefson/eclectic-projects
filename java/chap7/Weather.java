/*	Weather class
	Luke
*/

public class Weather
{
	public enum Condition {Sunny, Snowy, Cloudy, Rainy};

	private double temp;
	private Condition sky;

	public Weather()
	{
		setTemp(70.0);
		setSky(Condition.Sunny);
	}

	public Weather(double temp, Condition sky)
	{
		setTemp(temp);
		setSky(sky);
	}

	public static double fahrenheitToCelsius(double f)
	{
		return (f - 32.0) * (5.0 / 9.0);
	}

	public double getTemp()
	{
		return temp;
	}

	public Condition getSky()
	{
		return sky;
	}

	public void setTemp(double temp)
	{
		if (temp < -50.0 || temp > 150.0)
			System.err.println("Invalid tempeture");
		else
			this.temp = temp;
	}

	public void setSky(Condition sky)
	{
		if (temp < 32.0 && sky != Condition.Snowy)
			System.err.println("It's too cold to not be snowing. Sky unchanged.");
		else if (temp > 100.0 && sky != Condition.Sunny)
			System.err.println("It's too hot to not be sunny. Sky unchanged.");
		else
			this.sky = sky;
	}

	public String toString()
	{
		return "Temp: " + temp + "; Sky: " + sky;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Weather))
			return false;
		else
		{
			Weather obj = (Weather) o;
			if (Math.abs(temp - obj.temp) < 0.001 && sky == obj.sky)
				return true;
			else
				return false;
		}
	}
}
