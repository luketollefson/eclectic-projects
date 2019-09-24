/*	Student Passwords class
	Luke
*/

public class StudentPasswords
{
	private String[][] passwords;

	public StudentPasswords(String[] a)
	{
		if (a.length != 12)
		{
			System.err.println("Bad number of passwords");
			return;
		}

		int aIndex = 0;
		passwords = new String[3][4];
		for (int i = 0; i < passwords.length; i++)
		{
			for (int j = 0; j < passwords[i].length; j++)
			{
				passwords[i][j] = a[aIndex];
				aIndex++;
			}
		}
	}

	public boolean containsWord(String word)
	{
		for (int i = 0; i < passwords.length; i++)
		{
			for (int j = 0; j < passwords[i].length; j++)
			{
				if (passwords[i][j].indexOf(word) != -1)
					return true;
			}
		}

		// if word is not found
		return false;
	}

	public void unlock()
	{
		for (int i = 0; i < passwords.length; i++)
		{
			for (int j = 0; j < passwords[i].length; j++)
			{
				passwords[i][j] = "unlock";
			}
		}
	}

	public String longestPassword()
	{
		String s = "";
		for (int i = 0; i < passwords.length; i++)
		{
			for (int j = 0; j < passwords[i].length; j++)
			{
				if (passwords[i][j].length() > s.length())
					s = passwords[i][j];
			}
		}

		return s;
	}

	// returns the student who changed their password the most
	public int mostChanged()
	{
		int student = 0;
		int changes = 0;
		int newChanges;
		for (int i = 0; i < passwords.length; i++)
		{
			newChanges = 0;
			for (int j = 0; j < passwords[i].length-1; j++)
			{
				if (!passwords[i][j].equals(passwords[i][j+1]))
					newChanges++;
			}
			if (newChanges > changes)
			{
				student = i;
				changes = newChanges;
			}
		}

		return student;
	}

	public String toString()
	{
		String s = "";
		for (int i = 0; i < passwords.length; i++)
		{
			s += "\nStudent " + (i+1) + ": ";
			for (int j = 0; j < passwords[i].length; j++)
			{
				s += passwords[i][j] + " ";
			}
		}

		return s;
	}
}
