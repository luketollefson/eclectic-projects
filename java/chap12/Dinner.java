/*	Using JLabels to display text and images
	Luke
*/

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;

public class Dinner extends JFrame
{
	private Container contents;
	private JLabel labelText;
	private JLabel labelImage;

	public Dinner()
	{
		super("What's for dinner?");

		contents = getContentPane();

		contents.setLayout(new FlowLayout());

		labelText = new JLabel("Sushi tonight?");

		labelText.setForeground(Color.WHITE);
		labelText.setBackground(Color.BLUE);
		labelText.setOpaque(true);

		labelImage = new JLabel(new ImageIcon("sushi.jpg"));

		labelImage.setToolTipText("photo of sushi");

		contents.add(labelText);
		contents.add(labelImage);

		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		Dinner dinner = new Dinner();
		dinner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
