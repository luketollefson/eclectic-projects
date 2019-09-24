/*	an encrypted telephone exercise
	Luke
*/

import java.util.Scanner;

public class EncryptedTelephone
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		boolean properNumber;
		int numberOfDigits;
		String inputNumber; // User inputed number
		String phoneNumber; // Processed number, only digits

		// Ask user for phone number
		do
		{
			numberOfDigits = 0;
			properNumber = false;
			phoneNumber = "";

			System.out.print("Enter a telephone number: ");
			inputNumber = scan.next();

			for (int i = 0; i < inputNumber.length(); i++)
				if (Character.isDigit(inputNumber.charAt(i))) {
					numberOfDigits++;
					phoneNumber += inputNumber.charAt(i);
				}

			if (numberOfDigits == 10)
				properNumber = true;
		} while (!properNumber);

		// Calculate the amount it's shifted
		int shift = Integer.parseInt(phoneNumber.charAt(0)+"") - 2;

		// Calcluate the decrypted phone number
		String decryptPhone = "";
		int d; // a single digit
		for (int i = 0; i < phoneNumber.length(); i++)
		{
			d = Integer.parseInt(phoneNumber.charAt(i)+"");
			d += (10 - shift);
			d %= 10;
			decryptPhone += d;

			// print hyphens
			if (i == 2 || i == 5)
				decryptPhone += '-';
		}

		// Determine if the phone number is in the form 212-xxx-xxxx
		if (decryptPhone.charAt(1) != '1' || decryptPhone.charAt(2) != '2')
			System.out.println("The phone can not be decrypted");
		else
		{
			System.out.println("The shift is " + shift);
			System.out.println("The decrypted telephone number is " + decryptPhone);
		}
	}
}
