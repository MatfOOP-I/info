package prave;

import java.util.Scanner;

public class TestPrag {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Koeficijenti jednacine prave: ");
		Prava p = new Prava(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		System.out.println(p);
		sc.close();
	}

}
