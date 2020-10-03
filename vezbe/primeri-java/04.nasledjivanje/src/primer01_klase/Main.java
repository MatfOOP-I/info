package primer01_klase;

public class Main {

	public static void main(String[] args) {
		// Pravimo tacku u (0, 0)
		Tacka t = new Tacka();
		
		// Pozivamo konstruktor kopija kako bi napravili novu tacku
		// takodje u (0, 0)
		Tacka p = new Tacka(t);

		// Pravimo tacku u (6, 9)
		Tacka s = new Tacka(6, 9);
		
		// Pravimo referencu na tacku koju povezujemo da pokazuje
		// na VEC POSTOJECU tacku (ne pravimo novi objekat)
		Tacka q = s;
		
		System.out.println("Ukupno instancirano tacaka: " + Tacka.getBrojacTacaka());
		System.out.println("distance(t, s) = " + Tacka.distance(t, s));
		System.out.println("t.distance(s) = " + t.distance(s));

		System.out.println("t = " + t.toString());
		System.out.println("p = " + p.toString());
		System.out.println("s = " + s.toString());
		System.out.println("g = " + s.toString());
	}

}
