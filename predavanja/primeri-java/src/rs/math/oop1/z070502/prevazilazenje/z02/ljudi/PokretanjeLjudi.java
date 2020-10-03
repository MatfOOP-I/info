package rs.math.oop1.z070502.prevazilazenje.z02.ljudi;

/**
 * 
 * Program ilustruje koncept enkapsulacije tj. učaurivanja podataka.
 *
 */
public class PokretanjeLjudi
{
	
	public static void main( String[] komandnaLinija )
	{
		Covek neko = null;
		neko = new Covek();
		neko.ime = "Marko";
		neko.prezime = "Markovic";
		
		Student janko;
		janko = new Student();
		janko.ime = "Janko";
		janko.prezime = "Jankovic";
		janko.smer = "R smer";
		janko.brojIndeksa = "12/2010";
		janko.godinaStudija = 3;
		
		Nastavnik milica = new Nastavnik();
		milica.ime = "Milica";
		milica.prezime = "Jankovic";
		milica.predmet = "OOP";
		milica.godinaStaza = 12;
		
		Apsolvent dragana = new Apsolvent();
		dragana.ime = "Suzana";
		dragana.prezime = "Markovic";
		dragana.smer = "R smer";
		dragana.brojIndeksa = "12/2011";
		dragana.godinaStudija = 5;
		dragana.brojRokovaDoIstekaStaza = 2;
		
		neko.predstaviSe();
		janko.predstaviSe();
		milica.predstaviSe();
		dragana.predstaviSe();
	}
	
}
