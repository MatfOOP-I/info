package primer01LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class Primer01 {
	public static void main(String[] args) {
		LinkedList<String> imena = new LinkedList<>(Arrays.asList("Blue ranger", "Red ranger", "White ranger", "Zordon", "Yellow ranger"));
		
		// Kroz listu mozemo da iteriramo kolekcijskom petljom
		System.out.println("Sadrzaj liste (foreach petlja):");
		for (String ime: imena)
			System.out.print(ime + " ");
		System.out.println("\n");
		
		// Mozemo i starom dobrom for petljom
		// No ovo je lose, metod 'get' mora da krene od pocetka liste
		// kako bi dosao do i-tog elementa!!
		System.out.println("Sadrzaj liste (stari dobri for):");
		for (int i = 0; i < imena.size(); i++)
			System.out.print(imena.get(i) + " ");
		System.out.println("\n");
			
		// Lista se moze ispisati na standardni izlaz i na sledeci nacin,
		// toString() metod se poziva implicitno.
		System.out.println("Sadrzaj liste (toString): ");
		System.out.println(imena);
		
		// Lista omogucava i da dodajemo i citamo elemente sa pocetka i kraja
		imena.addLast("Rita");
		imena.addFirst("Alpha 5");

		System.out.println("\nNakon dodavanja na pocetak i kraj: " + imena);
		
		// Mozemo i uklanjati elemente
		imena.removeFirst();
		imena.removeLast();
		System.out.println("\nNakon uklanjanja sa pocetka i kraja: " + imena);
		
		// Mozemo i ukloniti i-ti element, no 
		System.out.println("\nNakon uklanjanja elementa: " + imena.get(3));
		imena.remove(3);
		System.out.println(imena);
	}
}
