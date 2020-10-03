package v08.v02FormatizovaniIzlaz;

import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class TestFormatizovaniIzlaz
{
	public static void main(String[] args)
	{

		// Some arbitrary data to output
		int[] brojevi = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377 };

		double[] vrednosti =
			{
				1.0,
				1.0,
				1.414,
				1.732,
				2.236,
				2.828,
				3.606,
				4.582,
				5.831,
				-123456789.23456 };
		String[] stringovi =
			{ "one", "one", "two", "three", "five", "eight", "thirteen" };

		// Create a formatted writer for a buffered output to the command line
		FormatizovaniIzlaz out =
			new FormatizovaniIzlaz(
				new BufferedWriter(new OutputStreamWriter(System.out)),
				true,
				12,
				FormatizovaniIzlaz.DESNO_PORAVNAT);
		for (int i = 0; i < brojevi.length; i++)
		{
			if (i % 6 == 0)
			{ // New line before each line of five values 
				out.println();
			}
			out.print(brojevi[i]);
		}
		out.setSirina(10);
		for (int i = 0; i < vrednosti.length; i++)
		{
			if (i % 5 == 0)
			{ // New line before each line of four values
				out.println();
			}
			out.print(vrednosti[i]);
		}
		out.setSirina(14);
		for (int i = 0; i < stringovi.length; i++)
		{
			if (i % 4 == 0)
			{ // New line before each line of four 
				out.println();
			}
			out.print(stringovi[i]);
		}
		out.flush();
	}
	
}
