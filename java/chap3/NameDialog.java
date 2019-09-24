/*	Name Dialog, ask for a persons name and output the first name
	Luke
*/

import javax.swing.JOptionPane;

public class NameDialog
{
	public static void main(String[] args)
	{
		String fullName = JOptionPane.showInputDialog(null,
										"Enter your full name.");
		String firstName = fullName.substring(0, fullName.indexOf(' '));
		JOptionPane.showMessageDialog(null, "Your first name is " + firstName);
	}
}
