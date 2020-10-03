package predikcija;

import java.util.Scanner;

public class TestPrag {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite ime, tezinu i pol coveka.");
		Osoba o = new Osoba(sc.next(), sc.nextDouble(), sc.next().charAt(0));
		System.out.println(o);
		sc.close();
	}
}
