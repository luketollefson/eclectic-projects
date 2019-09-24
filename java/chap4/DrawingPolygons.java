/*	An applet that draws polygons
	Luke
*/

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Polygon;

public class DrawingPolygons extends JApplet
{
	public void paint(Graphics g)
	{
		super.paint(g);

		Polygon triangle = new Polygon();
		triangle.addPoint(75,50);
		triangle.addPoint(25,150);
		triangle.addPoint(125,150);
		g.drawPolygon(triangle);

		Polygon hexagon = new Polygon();
		hexagon.addPoint(150,100);
		hexagon.addPoint(200,13);
		hexagon.addPoint(300,13);
		hexagon.addPoint(350,100);
		hexagon.addPoint(300,187);
		hexagon.addPoint(200,187);
		g.fillPolygon(hexagon);
	}
}
