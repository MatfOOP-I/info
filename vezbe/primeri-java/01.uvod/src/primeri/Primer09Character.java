package primeri;

import java.util.Scanner;

public class Primer09Character {

	public static void main(String[] args) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Karakteri su jedan od primitivnih tipova koji postoje u Javi.
		// Kodirani su koriscenjem Unicode kodiranja (da mozemo i cirilicu da koristimo :) )
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Scanner nema metod koji ucitava karakter tako da se mozemo dovijati
		// koristeci metod 'next' koji vraca ucitanu rec, a onda od nje
		// mozemo izdvojiti nulti karakter.
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Klasa 'Character' sadrzi vise statickih funkcija koje
		// mozemo koristiti za rad sa karakterima.
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		Scanner sc = new Scanner(System.in);
		char x = 'x';
		if (sc.hasNext()) {
			String tmp = sc.next();
			x = tmp.charAt(0); 			// charAt(i) vraca karakter na poziciji 'i'
		} else {
			System.out.println("Greska, nije uneta rec ili karakter!");
			System.exit(1);
		}
		
		System.out.println("Unet karakter: " + x);
		if (Character.isUpperCase(x)) {
			System.out.println(x + " je veliko slovo.");
			System.out.println("Mozemo ga zapisati i kao malo slovo: " + Character.toLowerCase(x));
		} else if (Character.isLowerCase(x)) {
			System.out.println(x + " je malo slovo.");
			System.out.println("Mozemo ga zapisati i kao veliko slovo: " + Character.toUpperCase(x));
		} else if (Character.isDigit(x)) {
			System.out.println(x + " je cifra.");
			int y = Character.getNumericValue(x);
			System.out.println("Numericka vrednost cifre: " + y);
		}
		
		sc.close();
	}

}
