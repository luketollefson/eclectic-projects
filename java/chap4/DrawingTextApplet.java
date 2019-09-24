/*	Drawing Text
	Luke
*/

import javax.swing.JApplet;
import java.awt.Graphics;

public class DrawingTextApplet extends JApplet
{
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString("Programming is not", 140, 100);
		g.drawString("a spectator sport!", 140, 115);

		g.drawLine(100,150,100,250);
		g.drawLine(150,75,275,75);
		g.drawLine(0,0,399,299);
	}
}
