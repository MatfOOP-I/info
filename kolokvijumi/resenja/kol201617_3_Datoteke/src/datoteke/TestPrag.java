package datoteke;

import java.util.Scanner;

public class TestPrag {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Naziv datoteke: ");
		String naziv = sc.next();
		System.out.print("Prava pristupa: ");
		String prava = sc.next();
		DatotekaPrag d = new DatotekaPrag(naziv, prava);
		System.out.println(d);
		sc.close();
	}

}
