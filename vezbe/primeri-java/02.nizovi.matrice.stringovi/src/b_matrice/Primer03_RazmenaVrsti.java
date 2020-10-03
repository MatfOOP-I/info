package b_matrice;

import java.util.Scanner;

public class Primer03_RazmenaVrsti {
	
	static Scanner sc = new Scanner(System.in);

	/**
	 * Program unosi matricu, a potom vrsi obrtanje i-te i j-te vrste.
	 */
	public static void main(String[] args) {
		int[][] a = unesi();

		System.out.println("Unesite indekse vrsti koje zelite da razmenite:");
		int i = unesiSiguranInt();
		int j = unesiSiguranInt();
		
		// Proveravamo da li su uneti indeksi validnih vrsti
		if (i < 0 || i >= a.length || j < 0 || j > a.length) {
			System.out.println("Indeks vrste more biti izmedju 0 i " + (a.length-1));
			System.exit(1);
		}
		System.out.println("Pre razmene vrsta: " + i + " i " + j);
		ispisi(a);
		
		System.out.println("\nPosle razmene:");
		//razmeniStandardno(a, i, j);
		razmeniEfikasno(a, i, j);
		ispisi(a);
	}
	
	static void ispisi(int[][] a) {
		for (int[] row: a) {
			for (int e: row)
				System.out.print(e + " ");
			System.out.println();
		}
	}

	/**
	 * Algoritam je sledeci:
	 * Neka matrica ima vrste duzine n (dakle n kolona)
	 * Idemo paralelno kroz vrste 'i' i 'j' i razmenjujemo im elemente.
	 * Vremenska slozenost: O(n)
	 * Memorijska slozenost: O(1)
	 */
	static void razmeniStandardno(int[][] a, int i, int j) {
		for (int k = 0; k < a[i].length; k++) {
			int tmp = a[i][k];
			a[i][k] = a[j][k];
			a[j][k] = tmp;
		}
	}

	/**
	 * Posto je matrica niz nizova, a mi na niz imamo referencu,
	 * nista nas ne sprecava da jednostavno "prevezemo" reference
	 * odgovarajucih vrsti u nasoj matrici.
	 * Vremenska slozenost: O(1)
	 * Memorijska slozenost: O(1)
	 */
	static void razmeniEfikasno(int[][] a, int i, int j) {
		int[] tmp = a[i]; 		// cuvamo referencu na i-tu vrstu
		a[i] = a[j];
		a[j] = tmp;
	}

	static int[][] unesi() {
		System.out.println("Unesite dimenzije matrice:");
		int n = unesiSiguranInt();
		int m = unesiSiguranInt();
		
		// Pravimo matricu
		int[][] tmp = new int[n][m];
		
		// Unosimo matricu
		for (int i = 0; i < tmp.length; i++)
			for (int j = 0; j < tmp[i].length; j++) 		// a[i] -> niz, a[i].length -> duzina niza, tj. broj kolona matrice kod nas
				tmp[i][j] = unesiSiguranInt();

		return tmp;
	}

	public static int unesiSiguranInt() {
		if (sc.hasNextInt())
			return sc.nextInt();
		else {
			System.out.println("Niste uneli ceo broj...");
			System.exit(1);
			return 1; // nije neophodno, ali java zahteva da ipak vratimo nesto
		}
	}
	

}
