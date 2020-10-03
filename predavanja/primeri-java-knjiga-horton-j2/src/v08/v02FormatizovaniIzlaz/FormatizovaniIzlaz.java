package v08.v02FormatizovaniIzlaz;

import java.io.PrintWriter;
import java.io.Writer;

public class FormatizovaniIzlaz extends PrintWriter
{
	public final static int LEVO_PORAVNAT = 1;
	public final static int DESNO_PORAVNAT = 2;
	private int poravnanje = DESNO_PORAVNAT;
	private int sirina = 0; // Field width required for output

	// Constructor with a specified field width, autoflush, and justification 
	public FormatizovaniIzlaz(
		Writer izlaz,
		boolean autoflush,
		int sirina,
		int poravnanje)
	{
		super(izlaz, autoflush); // Call PrintWriter constructor
		if (sirina > 0)
			this.sirina = sirina; // Store the field width
		if (poravnanje == LEVO_PORAVNAT || poravnanje == DESNO_PORAVNAT)
			this.poravnanje = poravnanje;
	}

	// Constructor with a specified field width
	public FormatizovaniIzlaz(Writer izlaz, int sirina)
	{
		this(izlaz, true, sirina, DESNO_PORAVNAT);
	}

	// Constructor with a specified field width and justification
	public FormatizovaniIzlaz(Writer izlaz, int sirina, int poravnanje)
	{
		this(izlaz, true, sirina, poravnanje);
	}

	// Constructor with a specified field width and autoflush option 
	public FormatizovaniIzlaz(Writer izlaz, boolean autoflush, int sirina)
	{
		this(izlaz, autoflush, sirina, DESNO_PORAVNAT);
	}

	// Helper method to form string
	private String pad( String argument )
	{
		if (sirina == 0)
		{
			return argument;
		}
		int brojBlankova = sirina - argument.length(); // Number of blanks needed
		StringBuffer rezultat = new StringBuffer(); // Will hold the output
		if (brojBlankova < 0)
		{ // Data does not fit
			for (int i = 0; i < sirina; i++)
				rezultat.append('X'); // so append X's
			return rezultat.toString(); // and return the result       
		}
		if (brojBlankova > 0) // If we need some blanks
			for (int i = 0; i < brojBlankova; i++)
				rezultat.append(' '); // append them
		// Insert the value string at the beginning or the end
		rezultat.insert( poravnanje == LEVO_PORAVNAT ? 0 : rezultat.length(), argument );
		return rezultat.toString();
	}

	// Output type int formatted in a given width
	public void print(int value)
	{
		super.print(pad(String.valueOf(value))); // Pad to width and output
	}

	// Output type long formatted in a given width
	public void print(long value)
	{
		super.print(pad(String.valueOf(value))); // Pad to width and output
	}

	// Output type double formatted in a given width
	public void print(double value)
	{
		super.print(pad(String.valueOf(value))); // Pad to width and output
	}

	// Output type String formatted in a given width
	public void print(String str)
	{
		super.print(pad(str)); // Pad to width and output
	}

	// Output type long formatted in a given width on a line
	public void println(int value)
	{
		super.println(pad(String.valueOf(value))); // Pad to width and output
	}

	// Output type long formatted in a given width on a line
	public void println(long value)
	{
		super.println(pad(String.valueOf(value))); // Pad to width and output
	}

	// Output type double formatted in a given width on a line
	public void println(double value)
	{
		super.println(pad(String.valueOf(value))); // Pad to width and output
	}

	// Output type String formatted in a given width on a line
	public void println(String str)
	{
		super.println(pad(str)); // Pad to width and output
	}

	public void setSirina(int width)
	{
		if (width >= 0)
			this.sirina = width;
	}
}
