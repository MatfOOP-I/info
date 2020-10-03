package dosije;

import java.util.Scanner;

public class TestDosije {

	public static void main(String[] args) {
		/*
		System.out.println("------------------ PRAG ------------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("ime osobe: ");
		String ime = sc.next();
		System.out.print("prezime osobe: ");
		String prezime = sc.next();
		System.out.print("jmbg: ");
		String jmbg = sc.next();
		sc.close();
		System.out.println();
		Dosije dosije = new Dosije(ime + " " + prezime, jmbg);
		System.out.println(dosije);
		System.out.println("------------------------------------------");
		*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaci o studentu:");
		System.out.println("---------------------");
		System.out.print("Ime_Prezime: ");
		String osoba = sc.next(); 
		osoba = osoba.replace('_', ' ');
		
		System.out.print("jmbg: ");
		String jmbg = sc.next();
		while(!Dosije.jesteJmbg(jmbg)) {
			System.out.print("jmbg: ");
			jmbg = sc.next();
		}
		
		System.out.print("broj indeksa: ");
		int brIndeksa = sc.nextInt();
		System.out.print("godina upisa: ");
		int godina = sc.nextInt();
		System.out.print("studije (0-'Osnovne',1-'MSc',2-'PhD'): ");
		int studije = sc.nextInt();  
		Student student = new Student(osoba, jmbg, brIndeksa, godina, studije); 
				
		System.out.println("\nPodaci o nastavniku:");
		System.out.println("-------------------------");
		System.out.print("Ime_Prezime: ");
		osoba = sc.next();
		osoba = osoba.replace('_', ' ');
		System.out.print("jmbg: ");
		jmbg = sc.next();
		while(Nastavnik.jmbgUDatum(jmbg) == null) {
			System.out.print("jmbg: ");
			jmbg = sc.next();
		}
		
		System.out.print("radni odnos: ");
		int ugovor = sc.nextInt();
		System.out.println("zvanje ('docent','vanredni','redovni'):");
		String zvanje = sc.next(); 
		while(!Nastavnik.ispravnoZvanje(zvanje)) {
			System.out.println("Neispravno zvanje, pokusaj ponovo!");
			zvanje = sc.next();
		} 
		Nastavnik nastavnik = new Nastavnik(osoba, jmbg, ugovor, zvanje); 
		
		System.out.println();
		System.out.println(student);
		System.out.println("\n" + nastavnik); 
				
		System.out.println("\nBroj studenata: " + Student.brStudenata()); 
		
		System.out.print("\nstudije (0-'Osnovne',1-'MSc',2-'PhD'): ");
		studije = sc.nextInt(); 
		Student studentK = new Student(student);  
		studentK.setStudije(studije); 
		System.out.println();
		System.out.println(studentK);
		
		System.out.println("\nBroj studenata: " + Student.brStudenata());
		sc.close();
	}
}
