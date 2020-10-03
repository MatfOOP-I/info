package primer03Stek;

import java.util.Scanner;

public class Main {

	public static void prikaziInstrukcije() {
		System.out.println("Unesite operaciju (0 - push, 1 - pop, 2 - top, 3 - size, 4 - exit)");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stek s = new Niz();
		
		prikaziInstrukcije();
		int i = sc.nextInt();

		// Vraca sve vrednosti enuma
		// Mora se takodje proveriti indeks, probati sa nevalidnim
		Operacija opcija = Operacija.values()[i];

		while (opcija != Operacija.EXIT_OPERACIJA) {
			if (opcija == Operacija.PUSH_OPERACIJA) {
				System.out.println("Unesite element:");
				s.push(sc.nextInt());
			} else if (opcija == Operacija.POP_OPERACIJA)
				System.out.println("Sa steka je skinut element: " + s.pop());
			else if (opcija == Operacija.TOP_OPERACIJA)
				System.out.println("Va vrhu steka je element: " + s.top());
			else if (opcija == Operacija.SIZE_OPERACIJA)
				System.out.println("Broj elemenata steka: " + s.size());
			s.show();
			prikaziInstrukcije();

			// Napomena: skupo je stalno pozivati .values() metod, u ozbiljnoj implementaciji bi se kesirao rezultat
			// Videti naredni primer
			opcija = Operacija.values()[sc.nextInt()];
		}
		sc.close();
	}

}