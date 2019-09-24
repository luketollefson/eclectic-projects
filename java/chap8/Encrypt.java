/*	contains methods to encrypt and decrypt
	Luke
*/

import java.util.Random;

public class Encrypt
{
	private final char[] alphabet;
	private char[] mixedAlphabet;

	public Encrypt()
	{
		char[] a = {'a','b','c','d','e','f','g',
					'h','i','j','l','m','n','o',
					'p','q','r','s','t','u','v',
					'w','x','y','z'};
		alphabet = a;
		a = null;
		newEncryption();
	}

	public void newEncryption()
	{
		mixedAlphabet = new char[alphabet.length];
		for (int i = 0; i < alphabet.length; i++)
			mixedAlphabet[i] = alphabet[i];

		Random rand = new Random();
		double[] randNumbers = new double[mixedAlphabet.length];
		for (int i = 0; i < randNumbers.length; i++)
			randNumbers[i] = rand.nextDouble();

		char tempChar;
		double tempDouble;
		int index;
		for (int i = 0; i < randNumbers.length; i++)
		{
			index = highestDoubleIndex(randNumbers, 0, randNumbers.length-i-1);

			tempDouble = randNumbers[index];
			randNumbers[index] = randNumbers[randNumbers.length-i-1];
			randNumbers[randNumbers.length-i-1] = tempDouble;

			tempChar = mixedAlphabet[index];
			mixedAlphabet[index] = mixedAlphabet[randNumbers.length-i-1];
			mixedAlphabet[randNumbers.length-i-1] = tempChar;
		}
	}

	public String encode(String s)
	{
		String encoded = "";

		for (int i = 0; i < s.length(); i++)
			encoded += encodeChar(s.charAt(i));

		return encoded;
	}

	public String decode(String s)
	{
		String decoded = "";

		for (int i = 0; i < s.length(); i++)
			decoded += decodeChar(s.charAt(i));

		return decoded;
	}


	private char encodeChar(char c)
	{
		for (int i = 0; i < alphabet.length; i++)
			if (alphabet[i] == c)
				return mixedAlphabet[i];
		
		return c;
	}
	private char decodeChar(char c)
	{
		for (int i = 0; i < mixedAlphabet.length; i++)
			if (mixedAlphabet[i] == c)
				return alphabet[i];
		
		return c;
	}

	private int highestDoubleIndex(double[] a, int istart, int ilast)
	{
		int index = 0;
		for (int i = istart; i < ilast+1; i++)
			if (a[i] > a[index])
				index = i;

		return index;
	}

	public char[] getEncryption()
	{
		char[] temp = new char[mixedAlphabet.length];
		for (int i = 0; i < mixedAlphabet.length; i++)
			temp[i] = mixedAlphabet[i];

		return temp;
	}

	public void setEncryption(char[] a)
	{
		if (!(a.length == 26))
		{
			System.err.println("Encryption needs to be 26 chars long");
			return;
		}

		mixedAlphabet = new char[26];
		for (int i = 0; i < a.length; i++)
			mixedAlphabet[i] = a[i];
	}

	public String toString()
	{
		String s = "The encryption is as follows\n";
		for (int i = 0; i < mixedAlphabet.length; i++)
			s += mixedAlphabet[i];

		return s;
	}
}
