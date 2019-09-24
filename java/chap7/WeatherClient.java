/*	Tests the weather class
	Luke
*/

public class WeatherClient
{
	public static void main(String[] args)
	{
		Weather weather = new Weather(90, Weather.Condition.Rainy);
		System.out.println(weather);
		weather.setTemp(80);
		weather.setSky(Weather.Condition.Sunny);
		System.out.println(weather);

		System.out.println(weather.equals(new Weather(80, Weather.Condition.Sunny)));
		System.out.println("" + weather.getSky() + weather.getTemp());

		System.out.println(Weather.fahrenheitToCelsius(212));
	}
}
