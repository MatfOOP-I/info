package poruke;

import java.util.Scanner;

public class TestPoruka {

	public static void main(String[] args) {
		
		/* PRAG:
		Scanner sc = new Scanner(System.in);		 
		System.out.println("Unesite tajnu poruku:");
		String poruka = sc.nextLine();
		Poruka p = new Poruka(poruka);
		System.out.println(p);
		sc.close();
		*/
		Sifrar t;
		Scanner sc = new Scanner(System.in);		 
		System.out.println("Unesite tekst tajne poruke:");
		String poruka = sc.nextLine();
		Poruka p = new Poruka(poruka);
		System.out.println("Unesite tip sifrovanja (t - translacija, r - rotacija):");
		String tip = sc.next();
		if(tip.equalsIgnoreCase("t")) {
			System.out.println("Unesite pomeraj:");
			int pom = sc.nextInt();
			t = new SifrarTranslacija(p, pom);
		}
		else {
			System.out.println("Unesite smer i broj mesta:");
			String smer = sc.next();
			int bm = sc.nextInt();			
			t = new SifrarRotacija(p, smer, bm);
		}
		sc.close();
		
		System.out.println(t);
		Poruka sifrovana_poruka = t.sifruj();
		System.out.println("Nakon odgovarajuceg sifrovanja:\n" + sifrovana_poruka);
		
	}
}
