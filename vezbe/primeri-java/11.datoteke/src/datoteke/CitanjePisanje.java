package datoteke;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class CitanjePisanje {

	public static void main(String[] args) {

		// Interfejs Path predstavlja apstrakciju putanje na fajl sistemu.
		// Posto je Path interfejs, ne mozemo instancirati objekat pozivajuci
		// konstruktor new Path(...), vec sa desne strane dodele mora biti
		// poziv konstuktora koji instancira objekat "neke" klase koja implementira
		// interfejs 'Path'.
		// U klasi 'Paths' postoji staticka funkcija 'get' koja nam vraca referencu
		// na objekat koji predstavlja 'Path' dobijen za 'String' koji smo prosledili.
		
		// Zasto je Path interfejs? Postoji vise fajl sistema, pozivanjem staticke funkcije 'get',
		// Java nam vraca "pravi" Path objekat u zavisnosti od fajl sistema na kojem se program izvrsava.
		// Ovo donekle ilustruje pojam enkapsulacije, programer ne mora brinuti o tim detaljima
		// vec dobija "uslugu" koju pruzaju klase za rad sa putanjama, a kod se potencijalno
		// drugacije izvrsava u zavisnosti od operativnog sistema na kojem se program pokrece.
		Path ulaznaPutanja = Paths.get("input.txt");
		
		// Neke zanimljivosti
		System.out.println("path.toString() = " + ulaznaPutanja/*.toString()*/);
		
		// Npr ako je path: /home/korisnik/Desktop/input.txt
		// getFileName(): vratice se "input.txt"
		// getParent(): vratice se "/home/korisnik"
		// getRoot(): vratice se "/"
		System.out.println("Ime datoteke: " + ulaznaPutanja.getFileName());
		System.out.println("Parent putanje: " + ulaznaPutanja.getParent());
		System.out.println("Root: " + ulaznaPutanja.getRoot());
		
		// Izuzetno koristan metod za slucaj da nam se ne pronalazi datoteka
		// koja je zadataka relativno (jer najcesce ne znamo od odnosu NA STA je relativno).
		System.out.println("Apsolutna putanja: " + ulaznaPutanja.toAbsolutePath().toString());
		System.out.println();
		
		// ----------------------------------------------------------------------------------------
		// CITANJE
		// ----------------------------------------------------------------------------------------
		try {
			// Liste i ostale genericke kolekcije u Javi ce biti obradjeni narednih casova.
			// Za sada, dovoljno nam je da znamo da iteriramo kroz listu.
			// StandardCharsets predstavlja klasu kojoj mozemo pronaci kodiranje koje nam je potrebno.
			// Na kursu cemo uvek specifikovati UTF_8.
			List<String> linije = Files.readAllLines(ulaznaPutanja, StandardCharsets.UTF_8);
			System.out.println("Sadrzaj datoteke:" + ulaznaPutanja.toAbsolutePath());
			for (String linija: linije)
				System.out.println(linija);
		} catch (IOException e) {
			System.err.println("Neuspelo otvaranje ulazne datoteke!");
			e.printStackTrace();
		} 

		// ----------------------------------------------------------------------------------------
		// PISANJE
		// ----------------------------------------------------------------------------------------
		Path izlaznaPutanja = Paths.get("output.txt");
		System.out.println("\nPisemo u datoteku: " + izlaznaPutanja.toAbsolutePath());
		List<String> linije;
		
		// Primer kako mozemo da inicijalizujemo listu (slicno poput int[] a = {1, 2, 3, 4};
		linije = Arrays.asList("Zdravo", " ", "svete", "!");

		try {
			// Klasa StandardOpenOption omogucava da specifikujemo na koji nacin se "otvara" datoteka.
			// Odnosno, da li da ukoliko postoji datoteka, ne uspe otvaranje (eng. File already exists),
			// da li da se pisanje vrsi tako sto se stari sadrzaj obrise, ili se ipak pise na kraj datoteke i slicno.
			// Ukoliko se ne specifikuju opcije java radi:
            // * StandardOpenOption.CREATE 					- kreira datoteku 
            // * StandardOpenOption.TRUNCATE_EXISTING 		- brise prethodni sadrzaj ukoliko postoji
			// Files.write(izlaznaPutanja, linije);
			Files.write(izlaznaPutanja, linije, StandardOpenOption.APPEND); 	// dodaje sadrzaj na kraj datoteke
			System.out.println("Sadrzaj je uspesno upisan!");

		} catch (IOException e) {
			System.err.println("Neuspelo pisanje u datotekU!");
			e.printStackTrace();
		}
	}

}









