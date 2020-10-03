package vektori;

import java.util.Scanner;

public class TestPrag {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Koordinate vektora: ");
		Vektor v = new Vektor(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		System.out.println(v);
		sc.close();
	}
}
