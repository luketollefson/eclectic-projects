/*	represents a chess game
	Luke
*/

public class ChessBoard
{
	// row 0 is white, row 1 is black
	private int[][] chessPieces;
	private String[] pieces;

	public ChessBoard()
	{
		chessPieces = new int[][]{ {1, 1, 2, 2, 2, 8},
						 	       {1, 1, 2, 2, 2, 8} };
		pieces = new String[]{"King","Queen","Bishop","Knight","Rook","Pawn"};
	}

	// true, white takes black
	// false, black takes white
	public void playerATakesPlayerB(boolean player, int piece)
	{
		if (player)
			chessPieces[1][piece]--;
		else
			chessPieces[0][piece]--;
	}

	public int numberOfPeice(int piece)
	{
		return chessPieces[0][piece] + chessPieces[1][piece];
	}

	public int valueOf(boolean player)
	{
		int p = (player ? 1 : 0);

		return chessPieces[p][0] * 0 // King
			 + chessPieces[p][1] * 6 // Queen
			 + chessPieces[p][2] * 3 // Bishop
			 + chessPieces[p][3] * 3 // Knight
			 + chessPieces[p][4] * 4 // Rook
			 + chessPieces[p][5] * 1;// Pawn
	}
}
