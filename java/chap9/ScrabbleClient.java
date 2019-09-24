/*	Scrabble client
	Luke
*/

import java.util.ArrayList;

public class ScrabbleClient
{
	public static void main(String[] args)
	{
		Scrabble scrab = new Scrabble();

		System.out.println(scrab);

		char[] alphabet = scrab.getAlphabet();
		int[] value = scrab.highestValue();

		/*
		System.out.println("\nHighest value for each letter in any country:");
		for (int i = 0; i < 26; i++)
			System.out.println(alphabet[i] + " " + value[i]);
		*/

		System.out.println("Countries with a 10");
		ArrayList<String> countriesWith10 = scrab.countriesWith10();
		for (String s : countriesWith10)
			System.out.print(s + " ");
		System.out.println();

		System.out.println("The value of hello");
		String[] countries = scrab.getCountries();
		for (int i = 0; i < countries.length; i++)
			System.out.print(countries[i] + "\t");

		System.out.println();
		int[] score = scrab.score("hello");
		for (int i = 0; i < score.length; i++)
			System.out.print(score[i] + "\t");
		System.out.println();

	}
}
