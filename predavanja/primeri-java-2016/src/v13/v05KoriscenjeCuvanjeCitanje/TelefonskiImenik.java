package v13.v05KoriscenjeCuvanjeCitanje;

import java.util.*;
import java.io.*;

class TelefonskiImenik implements Serializable
{
	private HashMap imenik = new HashMap();
	private File datoteka = new File("C:\\Temp\\imenik.bin");

	public TelefonskiImenik()
	{
		if (datoteka.exists())
			try
			{
				ObjectInputStream in =
					new ObjectInputStream(new FileInputStream(datoteka));
				imenik = (HashMap) in.readObject();
				in.close();
			}
			catch (ClassNotFoundException e)
			{
				System.out.println(e);
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
	}

	public void dodajElemenat(ElemenatTelefonskogImenika elemenat)
	{
		imenik.put(elemenat.getLicnost(), elemenat);
	}

	public ElemenatTelefonskogImenika getElemenat(Osoba key)
	{
		return (ElemenatTelefonskogImenika) imenik.get(key);
	}

	public BrojTelefona getBroj(Osoba kljuc)
	{
		return getElemenat(kljuc).getBroj();
	}

	public void sacuvaj()
	{
		try
		{
			System.out.println("Cuvanje telefonskog imenika. ");
			ObjectOutputStream izlaz =
				new ObjectOutputStream(new FileOutputStream(datoteka));
			izlaz.writeObject(imenik);
			System.out.println(" Gotovo.");
			izlaz.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}

	// List all entries in the book
	public void izlistaj()
	{
		// Get the keys as a list
		LinkedList osobe = new LinkedList(imenik.keySet());
		Collections.sort(osobe); // Sort the keys
		Iterator iter = osobe.iterator(); // Get iterator for sorted keys
		while (iter.hasNext())
			System.out.println(imenik.get((Osoba) iter.next()));
	}

}
