package clanarine;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 /*System.out.println("------------------ PRAG ------------------");
		 System.out.println("Unesite podatke o clanu:");
		 System.out.print("Unesite ime:"); String imeP = sc.next();
		 System.out.print("Unesite tezinu:"); int tezinaP = sc.nextInt();
		 System.out.print("Unesite visinu:"); int visinaP = sc.nextInt();
		 Clan c = new Clan(imeP, tezinaP, visinaP); System.out.println(c);
		 System.out.println("------------------------------------------");
		 */

		System.out.println("Unesite podatke o novom clanu:");

		System.out.println("Unesite ime:");
		String ime = sc.next();

		System.out.println("Unesite tezinu:");
		int tezina = sc.nextInt();

		System.out.println("Unesite visinu:");
		int visina = sc.nextInt();

		System.out.println("\nDa li je novi clan Student - S ili Regularan - R?");
		char opis = sc.next().charAt(0);

		if (opis == 'S') {  
			System.out.println("Unesite prosek:");
			int prosek = sc.nextInt(); 
			Student student = new Student(ime, tezina, visina, prosek); 
			System.out.println("\nCena clanarine: " + student.clanarina());

		} else if (opis == 'R') {
			System.out.println("Da li je clan \"Zaposlen\"-Z ili \"Nezaposlen\"-NZ?");
			String kategorija = sc.next(); 

			if (kategorija.equals("NZ")) { 
				System.out.println("Da li nezaposleni ima privilegije (D/N)?");
				kategorija = sc.next();  
				if (kategorija.equals("D")) { 
					System.out.println("Unesite koliki popust treba obracunati privilegovanom clanu.");
					double popust = sc.nextDouble(); 
					RegularniSaPrivilegijama regpri = new RegularniSaPrivilegijama(ime, tezina, visina, kategorija,
							popust); 
					System.out.println("\nCena clanarine: " + regpri.clanarinaPrivilegovanog()); 
				} else {
					
					Regularni reg = new Regularni(ime, tezina, visina, kategorija);  
					System.out.println("\nCena clanarine: " + reg.clanarinaRegularnog()); 

				}
			} else if (kategorija.equals("Z")) {  
				Regularni regularni = new Regularni(ime, tezina, visina, kategorija); 
				System.out.println("\nCena clanarine: " + regularni.clanarinaRegularnog());

			}
		} else {
			System.out.println("Opis nije korektno unesen, pokusajte ponovo!"); 
			System.out.println("Uclanjeno je " + Clan.br + " clanova, od toga " + 
                    RegularniSaPrivilegijama.getBrRP() + " regularnih sa privilegijama.");  
		}
		
		System.out.println("Uclanjeno je " + Clan.br + " clanova, od toga " + 
		                    RegularniSaPrivilegijama.getBrRP() + " regularnih sa privilegijama.");
		sc.close();

	}

}
