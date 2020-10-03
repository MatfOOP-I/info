package primer05HashMap;

import java.util.*;

public class TelefonskiImenik
{
	public static void main(String[] args)
	{
		/*
			HashMap je implementacija mape preko hes tabele.

			Neophodno je da za kljuceve budu predefinisani metodi equals
			i hashCode iz klase Object. Hes kod odredjuje mesto u
			tabeli gde ce element biti smesten.

			Za implementaciju ovih metoda mora biti ispunjen uslov da
			ako metod equals vrati true za dva objekta onda metod
			hashCode mora vratiti istu vrednost za oba. Obrnuto ne vazi -
			moze da se desi da equals vrati false za dva objekta, a da
			im hes kodovi budu jednaki. Tu pojavu nazivamo kolizija.
			Resenje kolizije koje nudi ova implementacija je odrzavanje
			povezane liste na mestima u tabeli gde je doslo do kolizije.
		*/
		HashMap<Osoba, String> imenik = new HashMap<>();

		/*
			Za dodavanje elemenata u mapu koristimo metod put.
		*/
		imenik.put(new Osoba("Ana", "Anic"), "0611234567");
		imenik.put(new Osoba("Jovan", "Jovanovic"), "0659876543");
		imenik.put(new Osoba("Bojana", "Bojanic"), "062345678");
		imenik.put(new Osoba("Pavle", "Pavlovic"), "0645678901");

		/*
			Ako pokusamo da dodamo element sa kljucem koji se vec nalazi
			u mapi, izmenicemo mu vrednost, posto duplikati nisu
			dozvoljeni.
		*/
		imenik.put(new Osoba("Ana", "Anic"), "0612233445");

		/*
			Elemente mape mozemo proci preko skupa unosa koje dobijamo
			pozivom metoda entrySet. Takodje, mozemo proci elemente
			preko skupa kljuceva i metodom get dobiti odgovarajuce
			vrednosti.
		*/
		for(Map.Entry<Osoba, String> unos : imenik.entrySet()) {
			System.out.println(unos.getKey() + ": " + unos.getValue());
		}
	}
}
