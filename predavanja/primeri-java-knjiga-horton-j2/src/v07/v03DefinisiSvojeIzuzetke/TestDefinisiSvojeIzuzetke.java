package v07.v03DefinisiSvojeIzuzetke;

import java.io.IOException;

public class TestDefinisiSvojeIzuzetke
{
	// Divide method
	public static int podeli(int[] niz, int indeks) throws DeljenjeNulomException
	{
		try
		{
			System.out.println("\nUsli smo u prvi try blok unutar podeli()");
			niz[indeks + 2] = niz[indeks] / niz[indeks + 1];
			System.out.println("Zavrsavamo prvi try blok unutar podeli()");
			return niz[indeks + 2];
		}
		catch (ArithmeticException e)
		{
			System.err.println("Arithmetcki izuzetak uhvacen u podeli()\n");
			throw new DeljenjeNulomException(indeks + 1); // Throw new exception
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println(
				"Izuzetak indeksa van granica uhvacen u podeli()()\n"
					+ "\nPoruka kod objekta izuzetka:\n\t"
					+ e.getMessage());
			System.err.println("\nIzlaz sa steka poziva:\n");
			e.printStackTrace();
			System.out.println("\nKraj izlaza sa testa poziva\n");
		}
		finally
		{
			System.out.println("Usli smo u finally blok kod podeli()");
		}
		System.out.println("Izvrsavamo kod posle try bloka u podeli()");
		return niz[indeks + 2];
	}

	public static void main(String[] args)
	{
		int[] x = { 10, 5, 0 }; // Array of three integers

		// This block only throws an exception if method divide() does
		try
		{
			System.out.println("Uslis smo u prvi try blok u funkciji main()");
			System.out.println("rezultat = " + podeli(x, 0)); // No error
			x[1] = 0; // Will cause a divide by zero
			System.out.println("rezultat = " + podeli(x, 0)); // Arithmetic error
			x[1] = 1; // Reset to prevent divide by zero
			System.out.println("rezultat = " + podeli(x, 1)); // Index error
		}
		catch (DeljenjeNulomException e)
		{
			int index = e.getIndeks(); // Get the index for the error
			if (index > 0)
			{ // Verify it is valid and now fix the array
				x[index] = 1; // ...set the divisor to 1...
				x[index + 1] = x[index - 1]; // ...and set the result
				System.out.println("Delilac koji je bio nula ispravljen na " + x[index]);
			}
		}
		catch (ArithmeticException e)
		{
			System.out.println("Arithmetcki izuzetak uhvacen u main()");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Izuzetak indeksa van granica uhvacen u main()");
		}
		System.out.println("Izasli smo iz prvog try bloka u main()");
		System.out.println("\nPritisni Enter za izlazak");
		// This try block is just to pause the program before returning
		try
		{
			System.out.println("Usli smo unutar drugog try bloka u main()");
			System.in.read(); // Pauses waiting for input...
			return;
		}
		catch (IOException e)
		{ // The read() method can throw exceptions
			System.out.println("I/O izuzetak uhvacen u main()");
		}
		finally
		{ // This will always be executed
			System.out.println("Usli smo u finally blok kod main()");
		}
		System.out.println("Izvrsavamo kod posle drugog try bloka u main()");
	}

}
