/*	using the File class
	Luke
*/

public class FileClient
{
	public static void main(String[] args)
	{
		File file = new File("what.txt");
		System.out.println(file);
		file.setFile("not.you.java");
		System.out.println(file);
		System.out.println(file.getFile());

		System.out.println(file.equals(new File("not.java")));

		System.out.println(file.getFileExtension());
	}
}
