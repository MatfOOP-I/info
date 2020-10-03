package primer02Geometrija;

public class Main {

	public static void main(String[] args) {
		Pravougaonik pravougaonik = new Pravougaonik();
		Kvadrat kvadrat = new Kvadrat(new Tacka(2, 3), 10);
		Krug krug = new Krug();
		
		// 												prouzrokovace gresku
		Povrsina[] povrsine = {pravougaonik, kvadrat, krug /*, Duz */};
		for (Povrsina p: povrsine) {
			System.out.println(p.toString() + ":");
			System.out.println("P = " + p.getPovrsina());
			if (p instanceof Obim) {
				System.out.println("O = " + ((Obim)p).getObim());
			}
			System.out.println();
		}
		
		Duz duz = new Duz(new Tacka(), new Tacka(2, 3));
		// Greska pri kompilaciji jer implicitno kastovanje
		// proverava da li moze da se izvrsi kastovanje.
		// Povrsina p = duz;
		
		// Nije greska u kompilaciji, ali jeste greska u fazi izvrsavanja (sto je losije od prethodnog).
		// Povrsina p = (Povrsina)duz;
		// System.out.println(p.getPovrsina());
	}
}
