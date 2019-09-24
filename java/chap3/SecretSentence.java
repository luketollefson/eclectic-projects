/*	Secret Sentence, some secret stuff!
	Luke
*/

import javax.swing.JOptionPane;

public class SecretSentence
{
	public static void main(String[] args)
	{
		String sentence = JOptionPane.showInputDialog(null,
							"Enter the sentence");
		String decryptedSentence = ""
								 + sentence.charAt(0)
								 + sentence.charAt(2)
								 + sentence.charAt(4)
								 + sentence.charAt(6)
								 + sentence.charAt(8);

		JOptionPane.showMessageDialog(null,"The secret was " + decryptedSentence);
	}
}
