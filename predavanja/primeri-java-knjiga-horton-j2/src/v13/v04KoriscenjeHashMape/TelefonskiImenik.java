package v13.v04KoriscenjeHashMape;

import java.util.*;
import java.io.*;

class TelefonskiImenik implements Serializable
{
	private HashMap imenik = new HashMap();

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

}
