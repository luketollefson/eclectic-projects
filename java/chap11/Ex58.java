/*	Determs some things
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class Ex58
{
	public static void main(String[] args)
	{
		DecimalFormat percent = new DecimalFormat("#0.0%");
		LetterFreqs frqs = new LetterFreqs("animal_farm.txt");
		for (int i = 0; i < LetterFreqs.ALPHABET.length; i++)
			System.out.println(LetterFreqs.ALPHABET[i] + ": " + percent.format(frqs.getFreqs()[i]));

		System.out.println("Most frequent letter: " + frqs.highestFrequencyCharacter());
		System.out.println("Least frequent letter: " + frqs.lowestFrequencyCharacter());
	}
}

class LetterFreqs
{
	private String file;
	private double[] freqs;
	public static final char[] ALPHABET = {'a','b','c','d','e',
								'f','g','h','i','j',
								'k','l','m','n','o',
								'p','q','r','s','t',
								'u','v','w','x','y',
								'z'};

	public LetterFreqs(String file)
	{
		this.file = file;
		freqs = new double[26];
		try
		{
			Scanner f = new Scanner(new File(this.file));	
			f.useDelimiter(Pattern.compile("[^a-zA-z]*"));

			String s;
			int totalChars = 0;
			while (f.hasNext())
			{
				s = f.next().toLowerCase();

				for (int i = 0; i < s.length(); i++)
					freqs[charToInt(s.charAt(i))]++;

				totalChars += s.length();
			}

			for (int i = 0; i < freqs.length; i++)
				freqs[i] /= totalChars;
		}
		catch (FileNotFoundException fnfe)
		{
			System.err.println(fnfe.getMessage());
		}
	}

	public char highestFrequencyCharacter()
	{
		double max = 0;
		int index = 0;
		for (int i = 0; i < freqs.length; i++)
		{
			if (freqs[i] > max)
			{
				max = freqs[i];
				index = i;
			}
		}

		return ALPHABET[index];
	}

	public char lowestFrequencyCharacter()
	{
		double min = 2.0;
		int index = 0;
		for (int i = 0; i < freqs.length; i++)
		{
			if (freqs[i] < min)
			{
				min = freqs[i];
				index = i;
			}
		}

		return ALPHABET[index];
	}


	public double[] getFreqs()
	{
		double[] temp = new double[freqs.length];
		for (int i = 0; i < freqs.length; i++)
			temp[i] = freqs[i];
		
		return temp;
	}

	private int charToInt(char c)
	{
		for (int i = 0; i < ALPHABET.length; i++)
		{
			if (ALPHABET[i] == c)
				return i;
		}

		return -1;
	}
}
