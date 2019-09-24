/*	checks to see if the number of < is equal to the number of >
	Luke
*/

import javax.swing.JOptionPane;

public class HTMLChecker
{
	public static void main(String[] args)
	{
		String input = JOptionPane.showInputDialog(null,
						"Enter some HTML code");
		int greaterThan = 0;
		int lessThan = 0;
		for (int i = 0; i < input.length(); i++)
			if (input.charAt(i) == '>')
				greaterThan++;
			else if (input.charAt(i) == '<')
				lessThan++;

		if (greaterThan > lessThan)
			JOptionPane.showMessageDialog(null, "Too many >");
		else if (greaterThan < lessThan)
			JOptionPane.showMessageDialog(null, "Too many <");
		else
			JOptionPane.showMessageDialog(null, "Same number of < and >");
	}
}
