package primer01NulaIzuzeci;

/* 
 * Izuzetak - objekat koji sadrzi informacije o gresci koja se desila.
 * Posto je objekat, izuzetak je instanca neke klase.
 * Izuzetak se "ispaljuje" ili "baca", a kako bi nesto moglo biti
 * "ispaljeno" ili "baceno", mora biti instanca klase Throwable.
 * Sa druge strane, izuzetak se "hvata" (eng. catch), i kada se izuzetak
 * 	uhvati, reagujemo na njega (npr. prijavljujemo gresku).
 */
public class Main {

	public static void main(String[] args) {
		int x = 10;
		
	 	try {
			// Pokusavamo "rizicnu" radnju.
			System.out.println(x/0);
			System.out.println("Ova naredba se ne izvrsava.");
			System.out.println("A ni ova.");
			System.out.println("Razlog je sto izvrsavanje try bloka staje pri "
					+ "izbacivanju prvog izuzetka, i program nastavlja u jednom od "
					+ "navedenih catch blokova.");
	 	} catch (ArithmeticException e) {
	 		// Ukoliko je nasa radnja prouzrokovala izbacivanje izuzetka
	 		// tipa 'ArithmeticException', catch blok se bavi reakcijom na tu gresku
	 		// (na primer obavestava korisnika da je doslo do greske, mozda izlazi iz programa,
	 		// 	formatira korisnikov hard disk :) ili slicno)
	 		System.err.println("Deljenje nulom!");
	 		
	 		System.out.println("-----------------------------");
	 		System.err.println("e.getMessage(): " + e.getMessage());
	 		System.out.println("e.toString(): " + e.toString());
	 		System.out.println("e.getLocalizedMessage(): " + e.getLocalizedMessage());
	 		System.out.println("-----------------------------");
	 	}
	}
}
