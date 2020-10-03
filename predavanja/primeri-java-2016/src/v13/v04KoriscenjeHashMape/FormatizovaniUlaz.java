package v13.v04KoriscenjeHashMape;

import java.io.*;

public class FormatizovaniUlaz
{
	// Object to tokenize input from the standard input stream
	private StreamTokenizer tokenizator =
		new StreamTokenizer(new InputStreamReader(System.in));

	// Method to read an int value LISTED BELOW
	// Method to read an int value
	public int citajCeoBroj()
	{
		try
		{
			for (int i = 0; i < 5; i++)
			{
				if (tokenizator.nextToken() == tokenizator.TT_NUMBER
					&& tokenizator.nval == (double) ((long) tokenizator.nval))
					return (int) tokenizator.nval; // Value is numeric, so return as int 
				else
				{
					System.out.println(
						"Nekorektan unos: " + tokenizator.sval + ". Unesite ceo broj.");
					continue; // Retry the read operation
				}
			}
			System.out.println(
				"Pet puta je unesena pogresna vrednost" + " - program zavrsava sa radom.");
			System.exit(1); // End the program
			return 0;
		}
		catch (IOException e)
		{ // Error reading in nextToken()
			{
				System.out.println(e); // Output the error
				System.exit(1); // End the program
				return 0;
			}
		}
	}

	// plus methods to read various other data types

	// Read a  string
	public String citajString()
	{
		try
		{
			for (int i = 0; i < 5; i++)
			{
				int tokenType = tokenizator.nextToken(); // Read a token
				if (tokenType == tokenizator.TT_WORD
					|| tokenType == '\"') // Type is a string
					return tokenizator.sval; // so return it 
				else if (tokenType == '!') // Non-alpha returned as type
					return "!"; // so return end string
				else
				{
					System.out.println(
						"Nekorektan unos. Unesite string izmedju navodnika.");
					continue; // Retry the read operation
				}
			}
			System.out.println(
				"Pet puta je unesena pogresna vrednost" + " - program zavrsava sa radom.");
			System.exit(1); // End the program
			return null;
		}
		catch (IOException e)
		{ // Error reading in nextToken()
			System.out.println(e); // Output the error
			System.exit(1); // End the program
			return null;
		}
	}

}
