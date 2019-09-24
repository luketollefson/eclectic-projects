/*	File Extension, output the file extension
	Luke
*/

import java.util.Scanner;

public class FileExtension
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a filename > ");
		String filename = scanner.next();
		String extension = filename.substring(filename.indexOf('.')+1,filename.length());
		System.out.println("The file's extension is " + extension);
	}
}
