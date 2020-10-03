package torta;

import java.util.Scanner;

public class TestTorta {

	public static void main(String[] args) {

		String naziv;
		double kolicina;
		String jedinicaMere;
		int brojSastojaka;
		int tezinaRecepta;
		String voce;
		
		Scanner sc = new Scanner (System.in);
/*		
		System.out.println("------------------ PRAG ------------------");
		System.out.print("Naziv sastojka: "); naziv = sc.next();
		System.out.print("Kolicina: "); kolicina = sc.nextDouble();
		System.out.print("Jedinica mere: "); jedinicaMere = sc.next();
		
		Sastojak s = new Sastojak(naziv, kolicina, jedinicaMere);
		System.out.println(s);
		System.out.println("-----------------------------------------");
*/
		
		System.out.print("Unesite broj sastojaka: "); brojSastojaka = sc.nextInt(); 
		Sastojak s[] = new Sastojak[brojSastojaka]; 
		for(int i = 0; i < brojSastojaka; i++) {
			System.out.print("Naziv sastojka: "); naziv = sc.next();
			if(!Sastojak.dozvoljenSastojak(naziv)) { 
				System.out.println("Nedozvoljen sastojak!");
				i--;
				continue;
			}
			
			System.out.print("Kolicina: "); kolicina = sc.nextDouble();
			System.out.print("Jedinica mere: "); jedinicaMere = sc.next();
			s[i] = new Sastojak(naziv, kolicina, jedinicaMere); 
		}
		
		
		System.out.print("Unesite tezinu recepta: "); tezinaRecepta = sc.nextInt();				
		System.out.print("Unesite voce koje ide u tortu: "); voce = sc.next(); 
		
		VocnaTorta v = new VocnaTorta(s, tezinaRecepta, voce); 
		
		System.out.println();
		System.out.println(v); 

		for(int i = 0; i < s.length; i++)
			s[i].setKolicina(s[i].getKolicina() / 2); 
		VocnaTorta polaMere = new VocnaTorta(s, tezinaRecepta, voce); 
		System.out.println("\nPola mere: ");
		System.out.println(polaMere);
		
		sc.close();
	}

}
