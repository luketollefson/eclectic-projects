/*	Using dialog boxes for input and output of Strings
	Luke
*/

import javax.swing.JOptionPane;

public class DialogBoxDemo1
{
	public static void main(String[] args)
	{
		String name = JOptionPane.showInputDialog(null,
					  "Please enter your first and last names");
		JOptionPane.showMessageDialog(null, "Hello, " + name);
	}
}
