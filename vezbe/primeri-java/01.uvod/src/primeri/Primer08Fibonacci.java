package primeri;

import java.util.Scanner;

public class Primer08Fibonacci {

	static int fibonacciIter(int n) {
		// Rešenje: za n >= 1, F(1) = F(2) = 1.
        if (n < 1 || n > 46) {
            throw new IllegalArgumentException("Za int rezultat koristimo 1 <= n <= 46.");
        }
        int prethodni = 0, tekuci = 1;
        for (int i = 1; i < n; i++) {
            int sledeci = prethodni + tekuci;
            prethodni = tekuci;
            tekuci = sledeci;
        }
        return tekuci;
	}

	static int fibonacciRecursive(int n) {
        if (n < 1 || n > 30) {
            throw new IllegalArgumentException("Za spor rekurzivni primer koristimo 1 <= n <= 30.");
        }
		if (n == 1 || n == 2)
			return 1;
		else
			return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite n:");
		int n = sc.nextInt();
        if (n < 1 || n > 30) {
            System.out.println("Za poređenje obe verzije unesite broj od 1 do 30.");
            sc.close();
            return;
        }
		
		System.out.println("fib(" + n + ") = " + fibonacciIter(n));
		System.out.println("fib(" + n + ") = " + fibonacciRecursive(n));
		sc.close();
	}
}
