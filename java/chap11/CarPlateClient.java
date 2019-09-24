import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
// import java.io.ClassNotFoundException;

import java.util.ArrayList;

public class CarPlateClient
{
    public static void main(String[] args)
    {
	CarPlate p1 = new CarPlate("324", "MN", "Blue");
	CarPlate p2 = new CarPlate("ABE", "NJ", "Purple");
	CarPlate p3 = new CarPlate("294", "UK", "Yellow");
	CarPlate p4 = new CarPlate("AOB", "ND", "Green");
	CarPlate p5 = new CarPlate("003", "SD", "Orange");
	CarPlate p6 = new CarPlate("NEO", "ID", "Tan");

	try
	{
	    FileOutputStream fos = new FileOutputStream("carplates.objects", false);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);

	    oos.writeObject(p1);
	    oos.writeObject(p2);
	    oos.writeObject(p3);
	    oos.writeObject(p4);
	    oos.writeObject(p5);
	    oos.writeObject(p6);

	    oos.close();
	}
	catch (FileNotFoundException fnfe)
	{
	    System.err.println(fnfe.getMessage());
	}
        catch (IOException ioe)
	{
	    ioe.printStackTrace();
	}

	ArrayList<CarPlate> plates = new ArrayList<CarPlate>();

	try
	{
	    FileInputStream fis = new FileInputStream("carplates.objects");
	    ObjectInputStream ois = new ObjectInputStream(fis);

	    try
	    {
		while (true)
		    plates.add((CarPlate) ois.readObject());
	    }
	    catch (EOFException eof)
	    { }
	    catch (ClassNotFoundException cnfe)
	    {
		System.err.println(cnfe.getMessage());
	    }
	    catch (IOException ioe)
	    {
		ioe.printStackTrace();
	    }
	    finally
	    {
		ois.close();
	    }
	}
	catch (FileNotFoundException fnfe)
	{
	    System.err.println(fnfe.getMessage());
	}
	catch (IOException ioe)
	{
	    ioe.printStackTrace();
	}

	for (CarPlate p : plates)
	    System.out.println(p);
    }
}

class CarPlate implements Serializable
{
    private String plateNumber;
    private String state;
    private String color;

    public CarPlate(String pn, String s, String c)
    {
	plateNumber = pn;
	state = s;
	color = c;
    }

    public String toString()
    {
	return "plate number: " + plateNumber
	    + "; state: " + state
	    + "; color: " + color;
    }
}
