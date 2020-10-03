package vektori;

import java.util.Scanner;

public class TestVektori {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Uneti koordinate prvog vektora: ");
		Vektor u = new Vektor(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		System.out.print("Uneti koordinate drugog vektora: ");
		Vektor v = new Vektor(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		System.out.print("Uneti koordinate treceg vektora: ");
		Vektor t = new Vektor(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		sc.close();
		SkalarniProizvod sp = new SkalarniProizvod(u, v);
		MesovitiProizvod mp = new MesovitiProizvod(u, v, t);
		
		System.out.println(sp);
		System.out.println(mp);
	}
}
