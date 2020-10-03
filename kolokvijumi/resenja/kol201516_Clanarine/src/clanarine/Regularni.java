package clanarine;

import java.util.Scanner;

public class Regularni extends Clan {
	private String kategorija;

	// Konstruktor na osnovu zadatih kompletnih podataka kojim se opisuje
	// regularni clan
	public Regularni(String ime, int tezina, int visina, String kategorija) {
		// Poziv konstruktora bazne klase
		super(ime, tezina, visina);
		this.kategorija = kategorija;
	}

	public String toString() {
		return "\n" + super.toString() + "\nKategorija: " + kategorija + 
				"\nIndeks telesne mase: " + itm()
				+ "\nProgram: " + program();
	}

	public double clanarinaRegularnog() {
		
		Scanner sc = new Scanner(System.in); 
		double clanarina = 0;
		if (program().equals("Kardio")) { 
			System.out.println(getIme() + ", preporucujemo Vam program Kardio.");  
			System.out.println("Unesite broj zeljenih termina (8 ili 16)");
			int term = sc.nextInt();
			clanarina = term * 700;  
		} else {
			System.out.println(getIme() + ", preporucujemo Vam individualni program.");
			clanarina = kategorija.equals("Z") ? 6000 : 4000;
		}
		sc.close();
		return clanarina;
	}
}
