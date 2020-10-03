package stambeniObjekat;

import java.util.Scanner;

public class TestStambeniObjekat {

	public static void main(String[] args) {

		// Prag:
		/*
		System.out.println("------------PRAG---------------");
		Scanner sc = new Scanner(System.in);		 
		System.out.println("Unesite povrsinu stana:");
		double p = sc.nextDouble();
		System.out.println("Unesite broj stanara u stanu:");
		int brs = sc.nextInt();
		Stan s = new Stan(p, brs);
		System.out.print(s);
		System.out.println("-------------------------------");
		sc.close();
		*/
		StambeniObjekat so;		 
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite adresu stambenog objekta:");
		String adresa = sc.nextLine();
		System.out.println("Unesite stambeni objekat koji zelite (k-kuca, z-zgrada):");
		String vrsta = sc.next();
		if(vrsta.equalsIgnoreCase("k")) {
			System.out.println("Unesite broj kvadrata i broj stanara kuce:");
			double pov = sc.nextDouble();
			int brs = sc.nextInt();
			Stan s = new Stan(pov, brs);
			so = new Kuca(adresa, s);
		}
		else {
			System.out.println("Unesite broj stanova zgrade:");
			int ns = sc.nextInt();
			Stan [] stanovi = new Stan[ns];
			for(int i = 0; i < ns; i++) {
				System.out.println("Unesite povrsinu " + (i+1) + ". stana:");
				double p = sc.nextDouble();
				System.out.println("Unesite broj stanara " + (i+1) + ". stana:");
				int bs = sc.nextInt();
				stanovi[i] = new Stan(p, bs);
			}
			so = new Zgrada(adresa,stanovi);
		}
		System.out.println("Unesite cenu poreza po kvadratu:");
		int cena_po_kvadratu = sc.nextInt();
		System.out.println(so);
		System.out.println("Ukupni porez koji treba da bude placen je "+so.porez(cena_po_kvadratu)+".");
		sc.close();
	}
}
