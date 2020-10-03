package v13.v04KoriscenjeHashMape;

import java.io.*;

class BrojTelefona implements Serializable
{
	private String pozivniBroj;
	private String brojTelefona;

	public BrojTelefona(String pozivniBroj, String brojTelefona)
	{
		this.pozivniBroj = pozivniBroj;
		this.brojTelefona = brojTelefona;
	}

	// Read a phone number from the keyboard
	public static BrojTelefona citajBroj()
	{
		FormatizovaniUlaz ulaz = new FormatizovaniUlaz();

		// Read in the area code
		System.out.println("\nUnesi pozivni broj:");
		String pozivni = Integer.toString(ulaz.citajCeoBroj());

		// Read in the number
		System.out.println("Unesi broj telefona:");
		String broj = Integer.toString(ulaz.citajCeoBroj());

		return new BrojTelefona(pozivni, broj);
	}

	public String toString()
	{
		return pozivniBroj + ' ' + brojTelefona;
	}

}
