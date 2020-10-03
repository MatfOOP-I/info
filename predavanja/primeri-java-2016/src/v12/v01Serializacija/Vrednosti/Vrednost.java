package v12.v01Serializacija.Vrednosti;

import java.io.Serializable;
import java.util.Random;

public class Vrednost implements Serializable
{
	private static Random generator = new Random();
	private int odgovor; // The answer
	private double[] brojevi; // Valuable data
	private String vrednost;

	public Vrednost(String vrednost)
	{
		this.vrednost = vrednost;
		odgovor = 42; // Answer always 42
		brojevi = new double[3 + generator.nextInt(4)]; // Array size 3 to 6 
		for (int i = 0; i < brojevi.length; i++) // Populate with
			brojevi[i] = generator.nextDouble(); // random values 	
	}

	public String toString()
	{
		StringBuffer bafer = new StringBuffer(vrednost);
		bafer.append('\n').append(String.valueOf(odgovor));
		for (int i = 0; i < brojevi.length; i++)
			bafer.append("\nnumbers[").append(String.valueOf(i)).append(
				"] = ").append(
				brojevi[i]);
		return bafer.toString();
	}
}
