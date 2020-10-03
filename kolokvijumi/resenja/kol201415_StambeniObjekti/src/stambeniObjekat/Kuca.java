package stambeniObjekat;

public class Kuca extends StambeniObjekat {
	
	private Stan stan;

	public Kuca(String adresa, Stan stan) {
		super(adresa);
		this.stan = new Stan(stan);
	}
	
	public Kuca(String adresa, double povrsina, int br_stanara) {
		super(adresa);
		stan = new Stan(povrsina, br_stanara);
	}
	
	public double porez(double cena_po_kvadratu) {
		return stan.porez(cena_po_kvadratu);
	}
	
	public String toString() {
		return "Kuca:\n" + super.toString() + stan;
	}
}
