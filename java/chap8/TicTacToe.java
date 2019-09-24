/*	represents a tictactoe game
	Luke
*/

public class TicTacToe
{
	// 0 is open, 1 is X, 2 is 0
	private int[] board;

	public TicTacToe()
	{
		board = new int[9];
	}

	// returns true is move was played
	public boolean play(int i, int p)
	{
		if (board[i] != 0)
			return false;

		board[i] = p;
		return true;
	}
		
	// returns true is p has won
	public boolean hasWon(int p)
	{
		if (   board[0] == p && board[1] == p && board[2] == p
			|| board[3] == p && board[4] == p && board[5] == p
			|| board[6] == p && board[7] == p && board[8] == p
			|| board[0] == p && board[3] == p && board[6] == p
			|| board[1] == p && board[4] == p && board[7] == p
			|| board[2] == p && board[5] == p && board[8] == p
			|| board[0] == p && board[4] == p && board[8] == p
			|| board[2] == p && board[4] == p && board[6] == p)
			return true;
		else
			return false;
	}

	public String toString()
	{
		return ""   + player(0)+'|'+player(1)+'|'+player(2)+'\n'
					+ "-------" + '\n'
					+ player(3)+'|'+player(4)+'|'+player(5)+'\n'
					+ "-------" + '\n'
					+ player(6)+'|'+player(7)+'|'+player(8);
	}
		
	private char player(int i)
	{
		switch(board[i])
		{
			case 0:
				return ' ';
			case 1:
				return 'X';
			case 2:
				return 'O';
			default:
				return '?';
		}
	}
}
