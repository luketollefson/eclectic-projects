/**	Print Command Line argument
*	Luke
*/
public class CommandLineArguments
{
	public static void main(String[] args)
	{
		System.out.println("The number of parameters is "
							+ args.length);
		for (int i = 0; i < args.length; i++)
		{
			System.out.println("args[" + i + "]: " + args[i]);
		}
	}
}
