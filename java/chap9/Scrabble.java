/*	represent Scrabble letter values in different countries
	Luke
*/

import java.util.Random;
import java.util.ArrayList;

public class Scrabble
{
	private int[][] letterPoints;
	private final char[] alphabet;
	private final String[] countries;

	public Scrabble()
	{
		letterPoints = new int[26][10];

		Random rand = new Random();
		for (int i = 0; i < letterPoints.length; i++)
		{
			for (int j = 0; j < letterPoints[i].length; j++)
			{
				letterPoints[i][j] = rand.nextInt(10) + 1;
			}
		}

		char[] cs = {'a','b','c','d','e','f','g','h','i','j','k',
					'l','m','n','o','p','q','r','s','t','u','v',
					'w','x','y','z'};
		alphabet = cs;
		cs = null;

		String[] ss = {"KH","US","AG","NZ","TV",
					 "CK","CU","CZ","GA","GI"};
		countries = ss;
		ss = null;
	}

	public int[] score(String word)
	{
		int[] wordScores = new int[countries.length];
		int[] charScore = new int[countries.length];
		for (int i = 0; i < word.length(); i++)
		{	
			charScore = scoreChar(word.charAt(i));
			for (int w = 0; w < charScore.length; w++)
				wordScores[w] += charScore[w];
		}

		return wordScores;
	}

	private int[] scoreChar(char c)
	{
		int[] scores = new int[countries.length];
		int charIndex = 0;
		for (int i = 0; i < alphabet.length; i++)
			if (alphabet[i] == c)
				charIndex = i;

		for (int j = 0; j < countries.length; j++)
		{
			scores[j] = letterPoints[charIndex][j];
		}

		return scores;
	}
		

	public ArrayList<String> countriesWith10()
	{
		int longestRow = 0;
		for (int i = 0; i < letterPoints.length; i++)
			longestRow = Math.max(longestRow, letterPoints[i].length);

		ArrayList<String> countriesl = new ArrayList<String>();
		for (int j = 0; j < longestRow; j++)
		{
			for (int i = 0; i < letterPoints.length; i++)
			{
				if (j < letterPoints[i].length)
				{
					if (letterPoints[i][j] == 10)
					{
						countriesl.add(countries[j]);
						j++; // add the country only once
						i = 0;
					}
				}
			}
		}

		return countriesl;
	}

	public int[] highestValue()
	{
		int[] highestLetterValue = new int[26];
		for (int i = 0; i < letterPoints.length; i++)
		{
			for (int j = 0; j < letterPoints[i].length; j++)
			{
				highestLetterValue[i] = Math.max(highestLetterValue[i], letterPoints[i][j]);
			}
		}

		return highestLetterValue;
	}

	public char[] getAlphabet()
	{
		char[] alpha = new char[alphabet.length];

		for (int i = 0; i < alphabet.length; i++)
			alpha[i] = alphabet[i];

		return alpha;
	}

	public String[] getCountries()
	{
		String[] cs = new String[countries.length];
		for (int i = 0; i < cs.length; i++)
			cs[i] = countries[i];

		return cs;
	}

	public String toString()
	{
		String s = "  ";
		for (int i = 0; i < countries.length; i++)
			s += countries[i] + " ";

		for (int i = 0; i < letterPoints.length; i++)
		{
			s += "\n" + alphabet[i];
			for (int j = 0; j < letterPoints[i].length; j++)
			{
				s += (letterPoints[i][j] == 10 ? " " + letterPoints[i][j] 
											   : "  " + letterPoints[i][j]);
			}
		}

		return s;
	}
}
