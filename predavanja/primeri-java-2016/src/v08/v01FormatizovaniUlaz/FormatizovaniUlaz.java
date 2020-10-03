package v08.v01FormatizovaniUlaz;

import java.io.StreamTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FormatizovaniUlaz
{
	// Object to tokenize input from the standard input stream
	private StreamTokenizer tokenizator =
		new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	private int tipTokena; // Stores the token type code

	// Helper method to read the next token
	private int citajToken()
	{
		try
		{
			tipTokena = tokenizator.nextToken();
			return tipTokena;

		}
		catch (IOException e)
		{ // Error reading in nextToken()
			e.printStackTrace(System.err);
			System.exit(1); // End the program
		}
		return 0;
	}

	// Method to read an int value
	public int citajInt() throws NekorektanUnosException
	{
		if (citajToken() != tokenizator.TT_NUMBER)
		{
			throw new NekorektanUnosException(
				" Problem sa citajInt(). " + "Ulazni podatak nije broj.");
		}

		if (tokenizator.nval > (double) Integer.MAX_VALUE
			|| tokenizator.nval < (double) Integer.MIN_VALUE)
		{
			throw new NekorektanUnosException(
				" Problem sa citajInt(). " + "Ulazni podatak van opsega.");
		}

		if (tokenizator.nval != (double) (int) tokenizator.nval)
		{
			throw new NekorektanUnosException(
				" Problem sa citajInt(). " + "Ulazni podatak nije ceo broj.");
		}
		return (int) tokenizator.nval;
	}

	// Method to read a double value...
	public double citajDouble() throws NekorektanUnosException
	{
		if (citajToken() != tokenizator.TT_NUMBER)
		{
			throw new NekorektanUnosException(
				" Problem sa citajDouble(). " + "Ulazni podatak nije broj.");
		}
		return tokenizator.nval;
	}

	// Plus methods to read various other data types...
	public String citajString() throws NekorektanUnosException
	{
		if (citajToken() == tokenizator.TT_WORD
			|| tipTokena == '\"'
			|| tipTokena == '\'')
		{
			return tokenizator.sval;
		}
		else
		{
			throw new NekorektanUnosException(
				" Problem sa citajString(). " + "Ulazni podatak nije string.");
		}
	}

}
