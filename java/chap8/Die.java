/**	Die class
	Luke
*/
import java.util.Random;

public class Die
{
	public final int SIDES = 6;
	private Random rand;

	/** default constructor
	*	instantiates the Random object
	*/
	public Die()
	{
		rand = new Random();
	}

	/** rolls the die
	*	@return the value of the roll
	*/
	public int roll()
	{
		return rand.nextInt(SIDES) + 1;
	}
}
