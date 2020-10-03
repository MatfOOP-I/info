package primer03Set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Primer01 {
	// Skup predstavlja strukturu podataka inspirisanu matematickim skupom.
	// Ono sto je od velikog znacaja za skup je da ne postoje duplikati u njemu.
	// Jedna od cescih implementija skupe je preko stabla.
	// Duplikati se izbegavaju tako sto pri dodavanju, ukoliko se pronadje element koji se dodaje,
	// odustaje se od dodavanja, a inace se dodaje. Slozenost ove operacija zavisi linearno od visine h stabla (O(h)).
	// Java poseduje interfejs 'Set' i nekoliko implementacija za skup. Na kursu cemo najcesce koristiti
	// implementaciju skupa preko stabla, odnosno 'TreeSet'.
	
	public static void main(String[] args) {
		Set<Integer> brojevi = new TreeSet<>();
		
		// Dodajemo 100 brojeva od kojih se neki ponavljaju.
		for (int i = 0; i < 100; i++)
			brojevi.add(i % 20);
		
		// Kroz skup mozemo iterirati kolekcijskom petljom.
		System.out.println("foreach iteracija kroz skup:");
		for (Integer i: brojevi)
			System.out.print(i + " ");
		System.out.println("\n");
		
		// Mozemo iterirati i koristeci iterator
		System.out.println("iterator iteracija kroz skup:");
		Iterator<Integer> i = brojevi.iterator();
		while (i.hasNext())
			System.out.print(i.next() + " ");
		System.out.println("\n");
		
		// ZAKLJUCAK:
		// 1) Pri obilasku kroz skup brojevi bivaju prikazani rastuce (ocekivano kada znamo da se koristi stablo)
		// 2) Ne postoje duplikati (sto je i svojstvo skupa)
	}
}
