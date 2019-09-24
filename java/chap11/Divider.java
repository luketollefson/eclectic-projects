/*	Divider
*	Handling multiple exception
*	Luke
*/

import javax.swing.JOptionPane;

public class Divider
{
	public static void main(String[] args)
	{
		int divisor = 0;
		int quotient = 0;
		int dividend = 100;

		boolean goodInput = false;

		String s = JOptionPane.showInputDialog(null, "Enter an integer divisor");

		do
		{
			try
			{
				divisor = Integer.parseInt(s);

				quotient = dividend / divisor;

				goodInput = true;
			}
			catch (NumberFormatException nfe)
			{
				s = JOptionPane.showInputDialog(null,
									s + " is not an integer. "
									+ "Enter an integer divisor");
			}
			catch (ArithmeticException ae)
			{
				s = JOptionPane.showInputDialog(null,
									"Divisor cannot be 0. "
									+ "Enter an integer divisor");
			}
		} while (!goodInput);
		
		JOptionPane.showMessageDialog(null, "The result is " + quotient);
	}
}
