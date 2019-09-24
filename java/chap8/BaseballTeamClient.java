/*	BaseballTeam client
	Luke
*/

public class BaseballTeamClient
{
	public static void main(String[] args)
	{
		int[] h = {4,2,5,2};
		int[] b = {60,4,6,10};
		BaseballTeam team = new BaseballTeam(4, h, b);

		System.out.println(team);
		int[] c = team.sortedHits();

		for (int i = 0; i < c.length; i++)
			System.out.print(c[i] + " ");


		System.out.println();
		System.out.println(team.totalHits());
		System.out.println(team.playersOver300());

		double[] avgs = team.battingAverages();
		for (int i = 0; i < avgs.length; i++)
			System.out.println(avgs[i]);
	}
}
