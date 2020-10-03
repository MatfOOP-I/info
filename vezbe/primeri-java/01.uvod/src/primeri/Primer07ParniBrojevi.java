package primeri;

import java.util.Scanner;

/**
 * Program prikazuje sve parne brojeve iz intervala [2, n]
 */
public class Primer07ParniBrojevi {
	
	static void prikaziParne(int n) {
		for (int i = 2; i <= n; i += 2)
			System.out.print(i + " "); 	// ispisujemo brojeve sa razmacima izmedju
		System.out.println(); 			// ispisujemo novi red nakon brojeva
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		prikaziParne(n);
		sc.close();
	}

}
