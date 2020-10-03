package v05.v05Geometrija;

public class TestGeometrija
{
	public static void main(String[] args)
	{
		Tacka pocetak = new Tacka(0.0, 1.0);
		Tacka kraj = new Tacka(5.0, 6.0);
		System.out.println("Kreirane su tacke " + pocetak + " i " + kraj);

		Linija prava1 = new Linija(pocetak, kraj);
		Linija prava2 = new Linija(0.0, 3.0, 3.0, 0.0);
		System.out.println("Kreirane su prave " + prava1 + " i " + prava2);

		System.out.println("Presek je " + prava2.presek(prava1));

		kraj.pomeri(1.0, -5.0);
		System.out.println("Posle pomeranja imamo prave " + prava1 + " i " + prava2);
		System.out.println("Novi presek je " + prava1.presek(prava2));
	}
}
