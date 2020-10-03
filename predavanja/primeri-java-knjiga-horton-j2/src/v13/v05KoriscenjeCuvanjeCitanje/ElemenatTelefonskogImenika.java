package v13.v05KoriscenjeCuvanjeCitanje;

import java.io.*;

class ElemenatTelefonskogImenika implements Serializable
{
	private Osoba licnost;
	private BrojTelefona broj;

	public ElemenatTelefonskogImenika(Osoba licnost, BrojTelefona broj)
	{
		this.licnost = licnost;
		this.broj = broj;
	}

	public Osoba getLicnost()
	{
		return licnost;
	}

	public BrojTelefona getBroj()
	{
		return broj;
	}

	public String toString()
	{
		return licnost.toString() + '\n' + broj.toString();
	}

	// Read an entry from the keyboard
	public static ElemenatTelefonskogImenika citajElemenat()
	{
		return new ElemenatTelefonskogImenika(
			Osoba.citajLicnost(), BrojTelefona.citajBroj());
	}

}
