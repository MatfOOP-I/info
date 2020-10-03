package primer01Geometrija;

public class Main {

	public static void main(String[] args) {
		Kvadrat kvadrat = new Kvadrat(new Tacka(), 10);
		Pravougaonik pravougaonik = new Pravougaonik(new Tacka(10, 20), 100, 20);
		Trougao trougao = new Trougao(new Tacka(), new Tacka(20, 20), new Tacka(30, 30), new Tacka(10, 100));
		
		Elipsa elipsa = new Elipsa(new Tacka(10, 20), 10, 20);
		Krug krug = new Krug(new Tacka(1, 2), 16);
		
		// Vrsi se implicitno kastovanje u tip 'Oblik'. Ovo je bezbedno kastovanje
		// jer kvadrat, pravougaonik, trougao, elipsa i krug JESU oblici.
		
		// Moguca je i sintaksa:
		// Oblik elipsa = new Elipsa(new Tacka(10, 20), 10, 20);
		// -> Na ovaj nacin, instancira se objekat tipa 'Elipsa', potom
		// se vraca referenca tipa 'Oblik' na njega.
		
		// Deklarisemo niz oblika i inicijalizujemo.
		Oblik[] oblici = {kvadrat, pravougaonik, trougao, elipsa, krug, new Pravougaonik(new Tacka(), 5, 7)};
		
		// Iteriramo kroz niz
		for (Oblik o: oblici) {
			System.out.println(o);
			// Polimorfno se izvrsavaju metodi 'getObim()' i 'getPovrsina()'.
			System.out.println("O = " + o.getObim());
			System.out.println("P = " + o.getPovrsina() + "\n");
		}
		
		// Kako da prebrojimo instance klase pravougaonik? (Pravougaonik i Kvadrat)
		// Koristimo binarni operator 'instanceof' koji vraca 'true' ako je prvi argument
		// instanca klase koja predstavlja drugi argument.
		int brojacPravougaonika = 0;
		for (int i = 0; i < oblici.length; i++) { 	// alternativni nacin da iteriramo
			Oblik o = oblici[i];
			if (o instanceof Pravougaonik)
				brojacPravougaonika++;
		}
		
		System.out.println("Pronadjeno pravougaonika: " + brojacPravougaonika);
		
		// Kako traziti samo instance klase pravougaonik (bez kvadrata)?
		// Za objasnjenje konsultovati materijal okacen na stranici.
		brojacPravougaonika = 0;
		for (Oblik o: oblici)
			if (o.getClass() == Pravougaonik.class)
				brojacPravougaonika++;
		System.out.println("Pronadjeno pravougaonika: " + brojacPravougaonika);
		
	}

}
