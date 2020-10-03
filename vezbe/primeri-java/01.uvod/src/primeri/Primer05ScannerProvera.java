package primeri;

import java.util.Scanner;

public class Primer05ScannerProvera {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
		// Ukoliko zelimo da proverimo da li je korisnik uneo
		// podatak koji je tipa koji zelimo da unesemo,
		// mozemo koristiti metode klase Scanner koji pocinju sa 'has'.
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
		int x = 0;
		if (sc.hasNextInt()) {
			x = sc.nextInt();
			System.out.println("Uneli ste: " + x);
		} else {
			System.out.println("Niste uneli ceo broj. Zbogom...");
			System.exit(1);
		}
		
		double y = 0.0;
		System.out.println("Unesite realan broj.");
		if (sc.hasNextDouble()) {
			y = sc.nextDouble();
			System.out.println("Uneli ste: " + y);
		} else {
			System.out.println("Niste uneli realan broj. Zbogom...");
		}
		
		sc.close();
	}

}
