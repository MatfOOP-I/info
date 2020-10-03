package primeri;

import java.util.Scanner;

public class Primer08Fibonacci {

	static int fibonacciIter(int n) {
		// DOMACI TODO: Isprogramirati.
		return 1;
	}

	static int fibonacciRecursive(int n) {
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
