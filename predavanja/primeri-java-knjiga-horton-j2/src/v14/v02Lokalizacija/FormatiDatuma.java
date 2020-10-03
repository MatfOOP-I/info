// Trying date formatting
package v14.v02Lokalizacija;
import java.util.Locale;
import java.util.Date;
import java.text.DateFormat;

public class FormatiDatuma
{
	public static void main(String[] args)
	{
		Date danas = new Date();
		Locale[] lokali = { Locale.US, Locale.UK, Locale.GERMANY, Locale.FRANCE };
		int[] stilovi =
			{ DateFormat.FULL, DateFormat.LONG, DateFormat.MEDIUM, DateFormat.SHORT };
		DateFormat fmt;
		String[] stilTekst = { "FULL", "LONG", "MEDIUM", "SHORT" };

		// Output the date for each local in four styles
		for (int i = 0; i < lokali.length; i++)
		{
			System.out.println(
				"\nZapis datuma za " + lokali[i].getDisplayCountry() + ":");
			for (int j = 0; j < stilovi.length; j++)
			{
				fmt = DateFormat.getDateInstance(stilovi[j], lokali[i]);
				System.out.println("\tu " + stilTekst[j] + " je " + fmt.format(danas));
			}
		}
	}
}
