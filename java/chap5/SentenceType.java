/*	Determine the type of sentence
	Luke
*/

import javax.swing.JOptionPane;

public class SentenceType
{
	public static void main(String[] args)
	{
		String sentence = JOptionPane.showInputDialog(null,
								"Enter a sentence");

		char punctuation = sentence.charAt(sentence.length() - 1);

		switch (punctuation)
		{
			case '.':
				JOptionPane.showMessageDialog(null, "Sentence is declarative");
				break;
			case '?':
				JOptionPane.showMessageDialog(null, "Sentence is interrogative");
				break;
			case '!':
				JOptionPane.showMessageDialog(null, "Sentence is exclamatory");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Improper punctuation");
				break;
		}
	}
}
