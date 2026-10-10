package primeri;

import java.util.Scanner;

public class Primer08Fibonacci {

	static int fibonacciIter(int n) {
		// Rešenje: za n >= 1, F(1) = F(2) = 1.
        if (n < 1 || n > 46) {
            System.err.println("Za int rezultat koristimo 1 <= n <= 46.");
            System.exit(1);
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
            System.err.println("Za spor rekurzivni primer koristimo 1 <= n <= 30.");
            System.exit(1);
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
        
		System.out.println("fib(" + n + ") = " + fibonacciIter(n));
		System.out.println("fib(" + n + ") = " + fibonacciRecursive(n));
		sc.close();
	}
}
