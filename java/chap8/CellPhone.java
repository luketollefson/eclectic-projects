/** CellPhone class
	Luke
*/

import java.text.DecimalFormat;

public class CellPhone
{
	public final int MONTHS = 6;
	private String phoneNumber;
	private double[] cellBills;

	public CellPhone()
	{
		phoneNumber = "";
		cellBills = new double[MONTHS];
	}

	/** Constructor
	* @param number cell phone number
	* @param bills	array of monthly bills
	*/
	public CellPhone(String number, double[] bills)
	{
		phoneNumber = number;

		cellBills = new double[bills.length];

		for (int i = 0; i < cellBills.length; i++)
		{
			cellBills[i] = bills[i];
		}
	}

	/** Returns the phone number
	*	@return the phone number
	*/
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/** Returns an arry of cell phone bills
	*	@return copy of cellBills array
	*/
	public double[] getCellBills()
	{
		double[] temp = new double[cellBills.length];
		for (int i = 0; i < cellBills.length; i++)
		{
			temp[i] = cellBills[i];
		}
		return temp;
	}

	/** Calculates total of all cell phone bills
	*	@return total of all elements in cellBills array
	*/
	public double calcTotalBills()
	{
		double total = 0.0;

		for (int i = 0; i < cellBills.length; i++)
		{
			total += cellBills[i];
		}
		return total;
	}

	/** Finds a maximum bill
	*	@return largest value in cellBills array
	*/
	public double findMaximumBill()
	{
		double max = cellBills[0];

		for (int i = 1; i < cellBills.length; i++)
		{
			if (cellBills[i] > max)
				max = cellBills[i];
		}
		return max;
	}

	/** Returns printable version of CellPhone object
	*	@return phone number plus each month's bill
	*/
	public String toString()
	{
		String returnValue = phoneNumber + "\n";
		DecimalFormat money = new DecimalFormat("$##0.00");
		for (int i = 0; i < cellBills.length; i++)
		{
			returnValue += money.format(cellBills[i]) + "\t";
		}
		returnValue += "\n";

		return returnValue;
	}

	/** Compares two CellPhone objects for equality
	*	@param c CellPhone object
	*	@return true if objects are equal; false, otherwise
	*/
	public boolean equals(Object c)
	{
		if (!(c instanceof CellPhone))
			return false;
		else
		{
			CellPhone objCP = (CellPhone) c;
			if (!(phoneNumber.equals(objCP.phoneNumber)))
				return false;

			if (cellBills.length != objCP.cellBills.length)
				return false;

			for (int i = 0; i < cellBills.length; i++)
			{
				if (cellBills[i] != objCP.cellBills[i])
					return false;
			}
			return true;
		}
	}
}
