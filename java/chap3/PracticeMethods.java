/*	Chapter 3 Programming Activity 2
	Calling class methods
	Luke
*/

import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class PracticeMethods
{
	public static void main(String[] args)
	{
		// create a scanner object for console input
		Scanner scanner = new Scanner(System.in);

		// show the user how many letters is in their first name
		System.out.print("Enter your first name > ");
		String name = scanner.next();
		System.out.println("Hello " + name + "\nYour name has " 
							+ name.length() + " letters\n");

		// show the user how old they are
		System.out.print("In what year were you born > ");
		int birthYear = scanner.nextInt();
		int age = 2018 - birthYear;
		System.out.println("This year, you will be " + age);

		// show the user how much of their life they have already lived
		final float LIFE_EXPECTANCY = 77.9f;
		DecimalFormat percentFormat = new DecimalFormat("#0.0%");
		System.out.println("You have lived " 
							+ percentFormat.format(age / LIFE_EXPECTANCY)
							+ " of your life.");

		// generate a number to be guessed between 1 and 20
		Random rand = new Random();
		int number = rand.nextInt(20) + 1;

		// prompt the user to guess what the random number is
		int userGuess = Integer.parseInt(JOptionPane.showInputDialog(null,
							"I am thinking of a number between 1 and 20.\n"
							+ "What is your guess?"));

		// show the user the correct number and how far
		// off they were form that number
		JOptionPane.showMessageDialog(null, "The number was " + number
									+ "\nYour guess was " + Math.abs(number-userGuess) + " away.");
	}
}
