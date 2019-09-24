/*	Team exercies
	Luke
*/

public class TeamClient
{
	public static void main(String[] args)
	{
		Team team = new Team("HellCats");

		System.out.println(team.getTeamName());
	}
}

class Team
{
	private String teamName;

	public Team()
	{
		teamName = "unknown";
	}

	public Team(String teamName)
	{
		setTeamName(teamName);
	}

	public String getTeamName()
	{
		return teamName;
	}

	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}

	public String toString()
	{
		return teamName;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Team))
			return false;
		else
		{
			Team objTeam = (Team) o;
			if (objTeam.equals(teamName))
				return true;
			else
				return false;
		}
	}
}
