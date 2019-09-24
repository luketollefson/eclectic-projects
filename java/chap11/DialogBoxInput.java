/*	An exception generated by the parseInt method
*	Luke
*/

import javax.swing.JOptionPane;

public class DialogBoxInput
{
	public static void main(String[] args)
	{
		int n = 0;
		boolean goodInput = false;

		String s = JOptionPane.showInputDialog(null, "Enter an integer");

		do
		{
			try
			{
				n = Integer.parseInt(s);
				goodInput = true;
			}
			catch (RuntimeException nfe)
			{
				s = JOptionPane.showInputDialog(null,
									s + " is not an integer."
									+ "Enter and integer");
			}
		} while (!goodInput);

		JOptionPane.showMessageDialog(null, "The integer is " + n);
	}
}