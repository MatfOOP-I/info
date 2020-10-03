package predikcija;

import java.util.Scanner;

public class TestPredikcija {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite ime, tezinu i pol ('m', 'z') osobe:");
		Osoba o = new Osoba(sc.next(), sc.nextInt(), sc.next().charAt(0));
		
		System.out.println("Unesite pravu visinu osobe:");
		double pravaVisina = sc.nextDouble();

		System.out.println("Izaberite predikciju:");
		System.out.println("1) Naivna predikcija");
		System.out.println("2) Linearna regresija");
		int i = sc.nextInt();
		
		if (i == 1) {
			System.out.println("Unesite uvecanje:");
			int uvecanje = sc.nextInt();

			Predikcija p = new PredikcijaNaivna(o, uvecanje);
			System.out.println(p + "\n");
			
			System.out.println(o);
			System.out.printf("Dobijena visina: %.2fcm\n", p.visina());
			System.out.printf("Greska: %.2f\n", Predikcija.odrediGresku(pravaVisina, p.visina()));
		} else if (i == 2) {
			System.out.println("Unesite koeficijent a:");
			double a = sc.nextDouble();

			System.out.println("Unesite koeficijent b:");
			double b = sc.nextDouble();
			
			Predikcija p = new PredikcijaLinearnaRegresija(o, a, b);
			System.out.println(p + "\n");

			System.out.println(o);
			System.out.printf("Dobijena visina: %.2fcm\n", p.visina());
			System.out.printf("Greska: %.2f\n", Predikcija.odrediGresku(pravaVisina, p.visina()));
			//System.out.println(Predikcija.odrediGresku(pravaVisina, p.visina()));
		}
		
		sc.close();
	}
}
