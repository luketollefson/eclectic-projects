/*	Compares area of a square and rectangle
	Luke
*/

public class SquareAndRectangle
{
	public static void main(String[] args)
	{
		double squareSide = 0.666666667;
		double rectH = 1.0 / 9.0;
		double rectW = 4.0;

		double squareArea = squareSide * squareSide;
		double rectArea = rectH * rectW;

		System.out.println("The area of the square is " + squareArea);
		System.out.println("The area of the rectangle is " + rectArea);

		if (Math.abs(squareArea - rectArea) < 0.00001)
			System.out.println("Their areas are the same");
		else
			System.out.println("Their areas are the different");
	}
}
