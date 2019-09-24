/*	using the tic tac toe board
	Luke
*/

import java.util.Scanner;

public class TicTacToeGame
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); 
		TicTacToe board = new TicTacToe();

		System.out.println("Welcome to tic-tac-toe, places are labeld 1-9");
		System.out.println("Player 1 is X, Player 2 is O");
		System.out.println(board);

		int move;
		int currentPlayer = 1;
		for (int i = 1; i <= 9 && !board.hasWon(1) && !board.hasWon(2); i++)
		{
			System.out.print("Play player " + currentPlayer + " > ");
			move = scan.nextInt();
			if (board.play(move-1, currentPlayer))
			{
				currentPlayer = currentPlayer % 2 + 1;
				System.out.println(board);
			}
			else
			{
				System.out.println("Invalid move");
				i--;
				System.out.println(board);
			}
		}

		if (board.hasWon(1))
			System.out.println("Player 1 Wins");
		else if (board.hasWon(2))
			System.out.println("Player 2 Wins");
		else
			System.out.println("Draw");
	}
}
