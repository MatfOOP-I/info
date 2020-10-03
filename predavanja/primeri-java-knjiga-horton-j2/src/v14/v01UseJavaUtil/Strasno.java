// Try out observers
package v14.v01UseJavaUtil;
import java.util.Observer;

public class Strasno
{
	public static void main(String[] args)
	{
		DzekilHajd covek = new DzekilHajd(); // Create Dr. Jekyll

		Observer[] gomila =
			{
				new Osoba("Sef Vigam", "Sta se ovde desava? Treba mi pojacanje."),
				new Osoba("Mardz Simpson", "Oh ne, on je stasan – pogledajte ove zube!"),
				new Osoba("Nik Holivud", "Ako vam treba doktor, evo moje vizit karte."),
				new Osoba("Pomocnik Bob", "Gde bih mogao da nabavim tu stvar?")};
		// Add the observers
		for (int i = 0; i < gomila.length; i++)
			covek.addObserver(gomila[i]);
		covek.popijNapitak(); // Dr. Jekyll drinks up
		covek.prestaloDejstvoNapitka();
		covek.popijNapitak();
	}
}
