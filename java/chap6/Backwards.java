/*	Print a sentence backward
	Luke
*/

import javax.swing.JOptionPane;

public class Backwards
{
	public static void main(String[] args)
	{
		String original, backwards = "";

		original = JOptionPane.showInputDialog(null, "Enter a sentence");

		for (int i = original.length() - 1; i >= 0; i--) {
			backwards += original.charAt(i);
		}

		JOptionPane.showMessageDialog(null, "The sentence backwards is: " + backwards);
	}
}
