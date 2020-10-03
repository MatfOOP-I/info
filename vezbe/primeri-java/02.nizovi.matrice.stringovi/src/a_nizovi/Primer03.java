package a_nizovi;

import java.util.Scanner;

public class Primer03 {

	// Evo primera kako mozemo napraviti globalnu promenljivu.
	// Primetimo da je mozemo inicijalizovati takodje.
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Program unosi niz, a potom mnozi svaki element niza
	 * konstanom c koju unese korisnik.
	 */
	public static void main(String[] args) {
		int[] a = unesi();
		
		System.out.println("Unesite celobrojnu konstantu kojom mnozite niz:");
		int c = sc.nextInt();
		
		System.out.println("Uneti niz:");
		ispisi(a);

		pomnoziKonstantnom(a, c);
		
		System.out.println("Promenjeni niz:");
		ispisi(a);
	}

	static void pomnoziKonstantnom(int[] a, int c) {
		// Ne mozemo koristiti obicnu foreach petlju jer ona
		// kopira primitivne tipove tako da nase mnozenje ne bi
		// menjalo elemente niza 'a'.
		// for (int e: a)
		//	e *= c;

		for (int i = 0; i < a.length; i++)
			a[i] *= c;
	}

	private static void ispisi(int[] a) {
		for (int e: a)
			System.out.print(e + " ");
		System.out.println();
	}

	static int[] unesi() {
		sc = new Scanner(System.in);
		System.out.println("Unesite velicinu niza:");
		int n = sc.nextInt();

		System.out.println("Unesite elemente niza:");
		int[] tmp = new int[n];
		for (int i = 0; i < n; i++)
			tmp[i] = sc.nextInt();
		return tmp;
	}

}
