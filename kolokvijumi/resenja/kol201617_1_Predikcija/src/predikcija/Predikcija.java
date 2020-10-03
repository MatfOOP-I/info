package predikcija;

// 3 poena
public abstract class Predikcija {
	private Osoba osoba;  //0.5
	
	public Predikcija(Osoba osoba) {   // 1  (-0.5 ako nema kopiranja)
		this.osoba = new Osoba(osoba);
	}
	
	public static double odrediGresku(double pravaVisina, double pVisina) {
		return Math.abs(pravaVisina - pVisina);
	}
	
	public abstract double visina();  // 1
	
	public Osoba getOsoba() {  // 0.5
		return osoba;
	}
}
