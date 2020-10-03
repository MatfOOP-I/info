package v05.v08ZecIzSesira;

import java.util.Random; // Import Random class

public class MagicniSesir
{
	static int maksimumZeceva = 5; // Maximuum rabbits in a hat
	static Random izbor = new Random(); // Random number generator
	static private String[] imenaZeceva =
		{ "Lupko", "Traputalo", "Sarenko", "Garavko", "Dugousko" };
	static private int[] brojImenaZeceva = new int[imenaZeceva.length];

	private String imeSesira; // Name of the hat
	private Zec zecevi[]; // Rabbits in the hat

	// Constructor for a hat
	public MagicniSesir(final String imeSesira)
	{
		this.imeSesira = imeSesira; // Store the hat name
		zecevi = new Zec[1 + izbor.nextInt(maksimumZeceva)]; // Random rabbits

		for (int i = 0; i < zecevi.length; i++)
			zecevi[i] = new Zec(); // Create the rabbits
	}

	// String representation of a hat
	public String toString()
	{
		// Hat name first...
		String hatString = "\n" + imeSesira + " sadrzi:\n";

		for (int i = 0; i < zecevi.length; i++)
			hatString += "\t" + zecevi[i] + " "; // Add the rabbits strings
		return hatString;
	}

	// Nested class to define a rabbit
	class Zec
	{
		// A name is a rabbit name from rabbitNames followed by an integer
		private String ime; // Name of the rabbit

		// Constructor for a rabbit
		public Zec()
		{
			int indeks = izbor.nextInt(imenaZeceva.length); // Get random name
			// index
			ime = imenaZeceva[indeks] + (++brojImenaZeceva[indeks]);
		}

		// String representation of a rabbit
		public String toString()
		{
			return ime;
		}
	}
}
