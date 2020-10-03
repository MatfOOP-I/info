package e_dodatno_nizovi;

import java.util.Scanner;

public class JaggedArray {

	/**
	 * Testerasti niz predstavlja niz nizova, pri cemu glavni niz
	 * sadrzi nizove RAZLICITIH duzina, odnosno to nije matrica.
	 * 
	 * Primer prikazujemo kako se moze uneti testerasti niz sa standardnog ulaza.
	 */
	public static void main(String[] args) {
		int[][] testerastiNiz = {
			{1, 2, 3},
			{4},
			{5, 6}
		};
		showMe(testerastiNiz);
		
		System.out.println("Unesite broj nizova:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] testerica = new int[n][];
		for (int i = 0; i < n; i++) {
			System.out.println("Unesitu duzinu niza br " + i);
			int m = sc.nextInt();
			testerica[i] = new int[m];
			System.out.println("Unesite elemente:");
			for (int j = 0; j < m; j++)
				testerica[i][j] = sc.nextInt();
		}
		
		showMe(testerica);
	}

	static void showMe(int[][] testerastiNiz) {
		for (int[] row: testerastiNiz) { 
			for (int e: row)
				System.out.print(e + " ");
			System.out.println();
		}
	}

}
