package b_matrice;

import java.util.Arrays;
import java.util.Scanner;

public class Primer02_Matrica {

	public static void main(String[] args) {
		int[][] a = unesi();
				
		System.out.println("ispisi1(a):");
		ispisi1(a);
		
		System.out.println("\nispis2(a):");
		ispisi2(a);
		
		System.out.println("\nispis3(a):");
		ispisi3(a);
		
	}

	private static int[][] unesi() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite dimenzije matrice (broj vrsti pa broj kolona)");
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] tmp = new int[n][m];
		System.out.printf("Unesite matricu dimenzija %dx%d\n", n, m);
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				tmp[i][j] = sc.nextInt();

		return tmp;
	}

	static void ispisi1(int[][] a) {
		// a.length -> broj vrsti
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) 		// a[i] -> niz, a[i].length -> duzina niza, tj. broj kolona matrice kod nas
				System.out.printf("%d ", a[i][j]);
			System.out.println();
		}
	}

	static void ispisi2(int[][] a) {
		// Imamo niz nizova, tako da su elementi niza nizovi.
		// Iteracija kroz ovakvu strukturu nam daje NIZOVE kroz koje potom iteriramo.
		for (int[] tmp: a) { 		// tmp je u stvari i-ta vrsta matrica a
			for (int e: tmp)
				System.out.print(e + " ");
			System.out.println();
		}
	}

	static void ispisi3(int[][] a) {
		System.out.println(Arrays.deepToString(a));
	}
}
