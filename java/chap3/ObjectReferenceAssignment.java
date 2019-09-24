/*	A demonstration of object reference assignment
	Luke
*/

public class ObjectReferenceAssignment
{
	public static void main(String[] args)
	{
		SimpleDate hireDate = new SimpleDate(2, 15, 2007);
		System.out.println("hireDate is " + hireDate.getMonth()
							+ "/" + hireDate.getDay()
							+ "/" + hireDate.getYear());

		SimpleDate promotionDate = new SimpleDate(9, 28, 2007);
		System.out.println("promotionDate is "
							+ promotionDate.getMonth()
							+ "/" + promotionDate.getDay()
							+ "/" + promotionDate.getYear());
		
		promotionDate = hireDate;
		System.out.println("\nAfter assigning hireDate "
						   + "to promotionDate:");
		System.out.println("hireDate is " + hireDate.getMonth()
						   + "/" + hireDate.getDay()
						   + "/" + hireDate.getYear());
		System.out.println("promotionDate is "
						   + promotionDate.getMonth()
						   + "/" + promotionDate.getDay()
						   + "/" + promotionDate.getYear());
	}
}
