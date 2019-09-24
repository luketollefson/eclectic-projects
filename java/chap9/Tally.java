/**	Two-Dimensional Arrays as Method Parameters
*	and Return Values: the Tally class
*	Luke
*/

public class Tally
{
	int[][] voteData;

	/**	overloaded constructor
	*	@param	newVoteData		an array of vote counts
	*/
	public Tally(int[][] newVoteData)
	{
		voteData = new int[newVoteData.length][];
		for (int i = 0; i < newVoteData.length; i++)
			voteData[i] = new int [newVoteData[i].length];

		for (int i = 0; i < newVoteData.length; i++)
		{
			for (int j = 0; j < newVoteData[i].length; j++)
			{
				voteData[i][j] = newVoteData[i][j];
			}
		}
	}

	/** arrayTally method
	*	@return		a two-dimensinoal array of votes
	*/
	public int[][] arrayTally()
	{
		int[][] returnTally = new int[2][];
		returnTally[0] = new int [voteData[0].length];
		returnTally[1] = new int [voteData.length];

		for (int i = 0; i < voteData.length; i++)
		{
			for (int j = 0; j < voteData[i].length; j++)
			{
				returnTally[0][j] += voteData[i][j];
				returnTally[1][i] += voteData[i][j];
			}
		}

		return returnTally;
	}
}
