package a_nizovi;

import java.util.Scanner;

public class Primer01 {

	/**
	 * Primer prikazuje pravljenje niza duzine n, unos elemenata
	 * i njihov ispis.
	 */
	public static void main(String[] args) {
		// Kada Scanner vezujemo na standardni ulaz,
		// necemo ga zatvarati (jer ce to zatvarati standardni ulaz,
		// tako da nas program ne moze da ga koristi na dalje).
		// Eventualno, mozemo ga zatvoriti na samom kraju programa
		// kada smo sigurni da nam vise nece trebati standardni ulaz.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite duzinu niza:");
		int n = sc.nextInt();
		
		// Pravimo niz duzine n
		int[] a = new int[n];
		
		System.out.println("Unesite " + n + " brojeva:");
		for (int i = 0; i < n;  i++)
			a[i] = sc.nextInt();

		System.out.println("Uneti brojevi (for petlja):");
		for (int i = 0; i < n;  i++)
			System.out.print(a[i] + " ");

        System.out.println();
		System.out.println("Uneti brojevi (foreach petlja):");
		for (int e: a)
			System.out.print(e + " ");
		
		// NE ZATVARAMO SCANNER
		// sc.close();
	}

}
