/*	Demonstating dialog boxes for input and output of number
	Luke
*/

import javax.swing.JOptionPane;

public class DialogBoxDemo2
{
	public static void main(String[] args)
	{
		String input = JOptionPane.showInputDialog(null,
						"Please enter your age in years");
		int age = Integer.parseInt(input);
		JOptionPane.showMessageDialog(null, "Next year your age will be " +
				++age);

		double average = Double.parseDouble(
				JOptionPane.showInputDialog(null,
				"Enter your GPA between 0.0 and 4.0"));
		JOptionPane.showMessageDialog(null, "Your average is "
				+ (4.0-average) + " points fom a 4.0");
	}
}
