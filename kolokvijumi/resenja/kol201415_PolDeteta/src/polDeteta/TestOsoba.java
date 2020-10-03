package polDeteta;

import java.util.Scanner;

public class TestOsoba {

	public static void main(String[] args) {

		System.out.println("--------------------PRAG---------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite dan, mesec i godinu danasnjeg datuma:");
		int dan = sc.nextInt();
		int mesec = sc.nextInt();
		int godina = sc.nextInt();
		Datum d = new Datum(dan, mesec, godina);
		System.out.println(d);
		System.out.println("---------------------------------------------");
		
		Osoba zena, muz;
		
		System.out.println("Unesite podatke o zeni:\nIme i prezime:\n");
		sc.nextLine();
		String ime = sc.nextLine();
		System.out.println("Unesite 'datum' ako je poznat datum rodjenja osobe, 'jmbg' ako je poznat jmbg:");
		String tip = sc.next();
		if(tip.equals("datum")) {
			System.out.println("Unestie dan, mesec i godinu rodjenja:");
			int dan_r = sc.nextInt();
			int mesec_r = sc.nextInt();
			int godina_r = sc.nextInt();
			Datum d_r = new Datum(dan_r, mesec_r,godina_r);
			zena=new OsobaDatum(ime,'z',d_r);
		}
		else {
			System.out.println("Unesite JMBG osobe:");
			String jmbg = sc.next();			
			zena=new OsobaJMBG(ime,'z',jmbg);
		}
		
		System.out.println("Unesite podatke o muzu:\nIme i prezime:\n");
		sc.nextLine();
		ime = sc.nextLine();
		System.out.println("Unesite 'datum' ako je poznat datum rodjenja osobe, 'jmbg' ako je poznat jmbg:");
		 tip = sc.next();
		if(tip.equals("datum")) {
			System.out.println("Unestie dan, mesec i godinu rodjenja:");
			int dan_r = sc.nextInt();
			int mesec_r = sc.nextInt();
			int godina_r = sc.nextInt();
			Datum d_r = new Datum(dan_r, mesec_r,godina_r);
			muz=new OsobaDatum(ime,'m',d_r);
		}
		else {
			System.out.println("Unestie JMBG osobe:");
			String jmbg = sc.next();			
			muz=new OsobaJMBG(ime,'m',jmbg);
		}
		
		System.out.println(zena);
		System.out.println(muz);
		System.out.println(zena.getImePrezime()+" danas ima "+zena.brojGodinaOsobe(d)+" god.");
		System.out.println(muz.getImePrezime()+" danas ima "+muz.brojGodinaOsobe(d)+" god.");
		
		if(zena.brojGodinaOsobe(d)%7 < muz.brojGodinaOsobe(d)%7 )
			System.out.println("Ako danas naprave bebu ona ce verovatno biti devojcica.");
		else
			System.out.println("Ako danas naprave bebu ona ce verovatno biti decak.");
		
			sc.close();
	}

}
