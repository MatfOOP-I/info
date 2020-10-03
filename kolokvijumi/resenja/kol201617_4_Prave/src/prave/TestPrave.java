package prave;

import java.util.Scanner;

public class TestPrave {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Koeficijenti jednacine prave p: ");
		Prava p = new Prava(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		
		System.out.println("Izaberite operaciju (t - prava i tacka, p - prava i prava): ");
		char c = sc.next().charAt(0);
		
		if (c == 't') {
			System.out.print("Unesite koordinate tacke T: ");
			double x = sc.nextDouble();
			double y = sc.nextDouble();

			RelacijaIncidencije po = new PravaITacka(p, x, y);
			System.out.println(po + "\n");
			if(po.odnos()) 
				System.out.println("Tacka T pripada pravoj p.");
			else {
				System.out.println("Tacka T ne pripada pravoj p.");
				System.out.printf("d(T,p) = %.2f\n", po.izracunaj());
			}
		} 
		else if (c == 'p') {
			System.out.print("Koeficijenti jednacine prave q: ");	
			Prava q = new Prava(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
			RelacijaIncidencije po = new PravaIPrava(p, q);
			System.out.println(po + "\n");
			if(po.odnos()) {
				System.out.println("Prave p i q se seku.");
				System.out.printf("<(p,q) = %.2f\n", po.izracunaj()); 
			}
			else 
				System.out.println("p || q");
				
		}
		else {
			System.out.println("Greska: neispravna operacija!");
			System.exit(1);
		}
		sc.close();

	}

}
