package primeri;

import java.util.Scanner;

public class Primer10Math {
	
	static double toDegrees(double radians) {
		return (radians * 180) / Math.PI;
	}
	
	static double toRadians(double degs) {
		return (degs * Math.PI) / 180;
	}

	public static void main(String[] args) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Klasa 'Math' sadrzi vist statickih funckija vezanih za matematiku. Sledi par primera.
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		Scanner sc = new Scanner(System.in);

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Primer 1
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		System.out.println("Unesite ugao u stepenima:");
		double fiiiii = sc.nextDouble();
		
		fiiiii = toRadians(fiiiii);
		// Postoji i ugradjena funkcija:
		// fiiiii = Math.toRadians(fiiiii);

		System.out.println("Uneti ugao u radijanima: " + fiiiii);
		System.out.printf("sin(%g)  = %g\n", fiiiii, Math.sin(fiiiii));
		System.out.printf("cos(%g)  = %g\n", fiiiii, Math.cos(fiiiii));
		System.out.printf("tan(%g)  = %g\n", fiiiii, Math.tan(fiiiii));
		System.out.printf("ctan(%g) = %g\n", fiiiii, 1/Math.tan(fiiiii));
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Primer 2
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		System.out.println("Unesite ugao u radijanima:");
		fiiiii = sc.nextDouble();
		System.out.println("Uneti ugao u stepenima: " + toDegrees(fiiiii));
		System.out.println("Uneti ugao u radijanima: " + fiiiii);
		System.out.printf("sin(%g) =  %g\n", fiiiii, Math.sin(fiiiii));
		System.out.printf("cos(%g) =  %g\n", fiiiii, Math.cos(fiiiii));
		System.out.printf("tan(%g) =  %g\n", fiiiii, Math.tan(fiiiii));
		System.out.printf("ctan(%g) = %g\n", fiiiii, 1/Math.tan(fiiiii));
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Primer 3
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		System.out.println("Unesite realan broj:");
		double x = sc.nextDouble();
		System.out.printf("sqrt(%g^3) = %g\n", x, Math.sqrt(Math.pow(x, 3)));

		sc.close();
	}

}
