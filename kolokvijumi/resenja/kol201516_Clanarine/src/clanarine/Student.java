package clanarine;

import java.util.Scanner;

public class Student extends Clan {
	private int prosek;

	// Konstruktor na osnovu zadatih kompletnih podataka kojim se opisuje student
	public Student(String ime, int tezina, int visina, int prosek) {
		// Poziv konstruktora bazne klase Clan
		super(ime, tezina, visina);
		this.prosek = prosek;
	}
	
	public String toString() {
		return "\n" + super.toString() + "\nProsek: " + prosek + 
			   "\nIndeks telesne mase: " + itm() + "\nProgram: "
				+ program();
	}

	public double clanarina() {
		Scanner sc = new Scanner(System.in); 
		double clanarina = 0; 
		
		if (program().equals("Kardio")) { 
			System.out.println(getIme() + ", preporucujemo Vam program Kardio."); 
			System.out.println("Unesite broj zeljenih termina (8 ili 12)");
			int term = sc.nextInt(); 
			clanarina = term * 700; 
		} else {
			System.out.println(getIme() + ", preporucujemo Vam individualni program.");
			System.out.println("Unesite zeljeni deo dana: ceo - C, pre_podne - PR.");
			String deo_dana = sc.next().trim(); 

			double koef = prosek > 8 ? 0.85 : 1;  
			clanarina = deo_dana.equals("C") ? 4000 * koef : 2000 * koef;
		}
		sc.close();
		return clanarina;
	}
}
