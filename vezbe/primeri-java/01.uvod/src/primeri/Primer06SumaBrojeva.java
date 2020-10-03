package primeri;

import java.util.Scanner;

/**
 * Program sumira unete brojeve sve dok se ne unese nula.
 */
public class Primer06SumaBrojeva {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int suma = 0, x = sc.nextInt();
		while (x != 0) {
			suma += x;
			x = sc.nextInt();
		}
		sc.close();
		
		System.out.println("Suma brojeva: " + suma);
	}

}
