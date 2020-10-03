package stambeniObjekat;

public class Zgrada extends StambeniObjekat{
	
	private Stan [] stanovi;
	
	public Zgrada(String adresa, Stan [] stanovi) {
		super(adresa);
		this.stanovi = new Stan[stanovi.length];
		for(int i = 0; i < stanovi.length; i++)
			this.stanovi[i] = new Stan(stanovi[i]);
	}
		
	public double porez(double cena_po_kvadratu) {
		double porez = 0;
		for(int i = 0; i < stanovi.length; i++)
			porez += stanovi[i].porez(cena_po_kvadratu);
		return porez;
	}
	
	public String toString() {
		StringBuffer s = new StringBuffer("Zgrada:\n" + super.toString() + "\n");
		for(int i = 0; i < stanovi.length; i++) {
			s.append((i+1) + ". stan:\n");
			s.append(stanovi[i]);
		}
		s.append("\n");
		return s.toString();
	}
}
