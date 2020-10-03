package v13.v01Guzve;

import java.util.*;

public class TestGuzveProsto
{
	public static void main(String[] args)
	{
		Vector osobe = new Vector();
		String[] imena =
			{ "Dragan", "Katarina", "Bata", "Marko", "Zarko", "Ana" };
		for (int i = 0; i < imena.length; i++)
			osobe.add(imena[i]);
		for (int i = 0; i < osobe.size(); i++)
			System.out.println((String) osobe.elementAt(i));
	}
}
