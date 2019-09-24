/*	A Shell GUI Application
	Luke
*/

import javax.swing.JFrame;
import java.awt.Container;

public class SchellGUIApplication extends JFrame
{
	private Constainer contents;

	public ShellGUIApplication()
	{
		super("A Shell GUI Application");

		contents = getContentPane();

		setSize(300,200);

		setVisible(true);
	}

	public static void main(String[] args)
	{
		ShellGUIApplication basicGui = new ShellGUIApplication();
		basicGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
