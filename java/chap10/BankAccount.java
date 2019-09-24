/**	BankAccount class
*	Luke
*	Represents a eneric bank account
*/
import java.text.DecimalFormat;

public class BankAccount
{
	public final DecimalFormat MONEY
					= new DecimalFormat("$#,##0.00");
	private double balance;

	/**	Default constructor
	*	sets balance to 0.0
	*/
	public BankAccount()
	{
		balance = 0.0;
	}

	/**	Overloaded constructor
	*	@param startBalance beginning balance
	*/
	public BankAccount(double startBalance)
	{
		deposit(startBalance);
	}

	/**	Accessor for balance
	*	@return current account balance
	*/
	public double getBalance()
	{
		return balance;
	}

	/**	Deposit amount to account
	*	@param amount amount to deposit;
	*				  amount must be >= 0.0
	*/
	public void deposit(double amount)
	{
		if (amount >= 0.0)
			balance += amount;
		else
			System.err.println("Deposit amount must be positive.");
	}

	/** withdraw amount from account
	*	@param amount	amount to withdraw;
	*					amount must be >= 0.0
	*					amount must be <= balance
	*/
	public void withdraw(double amount)
	{
		if (amount >= 0.0 && amount <= balance)
			balance -= amount;
		else
			System.err.println("Withdrawl amount must be positive "
							+ "and cannot be greater than balance");
	}

	/**	toString
	*	@return the balance formatted as money
	*/
	public String toString()
	{
		return ("balance is " + MONEY.format(balance));
	}
}
