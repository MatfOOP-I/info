package funkcijeSinusoida;

import java.util.Scanner;

public class TestFunkcije {

		public static void main(String[] args) {

		// Prag:
		/*
		System.out.println("------------PRAG---------------");
		Scanner sc = new Scanner(System.in);		 
		System.out.println("Unesite a:");
		int a = sc.nextInt();
		System.out.println("Unesite b:");
		int b = sc.nextInt();
		Clan clan = new Clan(a,b);
		System.out.print(s);
		System.out.println("-------------------------------");
		sc.close();
		*/
		
		Funkcija funk;		 
		Scanner sc = new Scanner(System.in);

		System.out.println("Unesite vrednost x između 0 i 2:");
		double x = sc.nextDouble();
		System.out.println("Unesite funkciju (s-sinusoida, z-zbir):");
		String vrsta = sc.next();
		if(vrsta.equalsIgnoreCase("s")) {
			System.out.println("Unesite a:");
			int a = sc.nextInt();
			System.out.println("Unesite b:");
			int b = sc.nextInt();
			funk = new Sinusoida(x, new Clan(a,b));
		}
		else {
			System.out.println("Unesite broj clanova zbira:");
			int br = sc.nextInt();
				
			// Unos clanova
			Clan[] clanovi = new Clan[br];
			for(int i =0; i<br; i++) {
			    System.out.println("Unesite a za "+(i+1)+". clan:");
				int a = sc.nextInt();
				System.out.println("Unesite b za "+(i+1)+". clan:");
				int b = sc.nextInt();
				clanovi[i] = new Clan(a,b);
			}
			funk = new ZbirSinusoida(x, clanovi);
		}	
		sc.close();
		System.out.println("Funkcija:\n" + funk);
		System.out.printf("Vrednost: %.2f.",funk.vrednost());
		//System.out.println(funk.vrednost());
	}
}
