package d_stringovi;

import java.util.Scanner;

/// Program demonstrira koriscenje klase StringBuilder.
public class Primer08StringBuilder {

	// Nekada zelimo da cesto vrsimo modifikaciju stringa.
	// Usled imutabilnosti, to moze biti neefikasno,
	// tako da mozemo koristiti specijalizovan klasu za to
	// cije je ime StringBuilder.
	public static void main(String[] args) {
		// Pretpostavimo da zelimo da sa standardnog ulaza unosimo rec po rec,
		// i da od svih unetih reci napravimo veliki string koji ih sve sadrzi.
		// Unos staje kada korisnik unese rec exit.

		// Konstruisemo objekat klase StringBuilder u koji cemo dodavati reci.
		StringBuilder sb = new StringBuilder();

		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		while (! input.equals("exit")) {
			// Ako smo usli u petlju, znamo da je korisnik
			// uneo nesto sto NIJE exit, tako da tu reci dodajemo u StringBuilder objekat.
			sb.append(input + " ");
			// Alternativno, mozemo ULANCAVATI pozive metoda append
			// sb.append(input).append(" ");

			// Citamo sledecu rec
			input = sc.next();
		}

		// Na kraju, na standardni izlaz ispisujemo uneto.
		String output = sb.toString();
		System.out.println(output);
		// Alternativno, sadrzaj StringBuilder objekta mozemo ispisati i sa:
		// System.out.println(sb); // java sama zove toString()

		sc.close();
	}

}
