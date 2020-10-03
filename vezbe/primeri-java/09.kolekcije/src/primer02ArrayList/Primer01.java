package primer02ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Primer01 {
	public static void main(String[] args) {
		/*
			Kako da inicijalizujemo kolekciju?
 			Staticka funkcija 'asList' vraca 'ArrayList' objekat
 			koji sadrzi prosledjene argumente kao elemente liste.
		*/
		List<Integer> xs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


		// Mozemo obrnuti kolekciju.
		Collections.reverse(xs);
		System.out.println("Nakon obrtanja: ");
		Iterator<Integer> iterator = xs.iterator();
		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");
		System.out.println();

		// Mozemo da promesamo elemente.
		Collections.shuffle(xs);
		System.out.println("\nNakon mesanja elemenata:");
		System.out.println(xs + "\n");

		// Razmena elemenata.
		int i = 0, j = 5;
		Collections.swap(xs, i, j);
		System.out.println("Razmena elemenata na indeksima " + i + " i " + j);
		System.out.println(xs + "\n");

		// Trazenje minimuma i maksimuma.
		Integer maksimum = Collections.max(xs);
		Integer minimum = Collections.min(xs);
		System.out.println("Maksimum: " + maksimum);
		System.out.println("Minimum: " + minimum);
		

		// Rotiranje elemenata za k.
		System.out.println("\nNakon rotacije za 3 mesta udesno:");
		// rotiramo udesno za 3 pozicije
		Collections.rotate(xs, 3);
		System.out.println(xs);

		// rotiramo ulevo za 3 pozicije
		Collections.rotate(xs, -3);
		System.out.println("\nNakon rotacije za 3 mesta ulevo:");
		System.out.println(xs);

		/*
			Mozemo sortirati kolekciju. Neophodno je da postoji
			nacin poredjenja za klasu cije objekte cuvamo u
			kolekciji. Vise o tome u primerima 10.poredjenje.objekata.
			Klasa Integer ima implementiran nacin poredjenja pa ne
			moramo nista da dodajemo.
		*/

		Collections.sort(xs);
		System.out.println("\nNakon sortiranja\n" + xs);
	}
}
