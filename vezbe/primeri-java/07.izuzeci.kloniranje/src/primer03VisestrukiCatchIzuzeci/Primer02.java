package primer03VisestrukiCatchIzuzeci;

import java.util.Scanner;

public class Primer02 {
	public static void main(String[] args) {
		int x = 10;
		int[] a = {1, 2, 3, 4, 5};
		Scanner sc = null;

		try {
			sc.nextLine(); 	// izbacuje izuzetak 'NullPointerException'
			x = 10/0; 		// izbacuje izuzetak 'ArithmeticException'
			x = a[20]; 		// izbacuje izuzetak 'ArrayIndexOutOfBoundsException
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Desila se ili greska 'ArithmeticException ili ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			// Ukoliko zelimo da uhvatimo sve ostale izuzetke koji nisu navedeni
			// u prethodnim catch konstrukcijama, mozemo da navedemo 'Exception'
			// koji hvata sve izuzetke.
			// Blok catch u sustini radi poredjenje koristeci operator 'instanceof'
			// (pogledati primer pod komentarom kako bi se to vestacki imitirali).
			System.out.println("Doslo je do neke greske koju ne znamo...");
			System.out.println("Greska: " + e.getMessage());
			
			// Metod 'printStackStrace()' prikazuje trag steka od trenutka
			// kada je detektovana greska.
			e.printStackTrace();
		} finally {
			// Finally blok se uvek izvrsava i sluzi da zatvori koriscenje resurse
			// koji se mozda nisu zatvorili u try bloku (jer je izvrsavanje stalo
			// 	usled prouzrokovane greske).
			if (sc != null)
				sc.close();
		}
	}
	
	
//	private void imitiranjeCatchKonstrukcije(Exception e) {
//		if (e instanceof ArithmeticException) {
//			System.out.println("Greska pri racunanju.");
//		} else if (e instanceof ArrayIndexOutOfBoundsException) {
//			System.out.println("Lose indeksiranje niza!");
//		} else /* if (e instanceof Exception */ {
//			System.out.println("Ispaljen je nepoznat izuzetak");
//		}
//	}
	
}
