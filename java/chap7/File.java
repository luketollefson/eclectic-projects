/*	basic file scheme
	Luke
*/

public class File
{
	private String file;

	public File()
	{
		setFile("");
	}

	public File(String file)
	{
		setFile(file);
	}

	public String getFileExtension()
	{
		for (int i = file.length()-1; i >= 0; i--)
			if (file.charAt(i) == '.')
				return file.substring(i + 1, file.length());

		// else
		return "unknown extension";
	}

	public String getFile()
	{
		return file;
	}

	public void setFile(String file)
	{
		this.file = file;
	}

	public String toString()
	{
		return "File: " + file;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof File))
			return false;
		else
		{
			File obj = (File) o;
			if (file.equals(obj.file))
				return true;
			else
				return false;
		}
	}
}
