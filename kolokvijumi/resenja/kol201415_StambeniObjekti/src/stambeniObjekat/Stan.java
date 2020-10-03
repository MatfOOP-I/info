package stambeniObjekat;

public class Stan {

	private double povrsina;
	private int br_stanara;
	
	public Stan(double povrsina, int br_stanara) {
		this.povrsina=povrsina;
		this.br_stanara = br_stanara;
	}
	
	public Stan(final Stan s) {
		povrsina = s.povrsina;
		br_stanara = s.br_stanara;
	}
	
	public double getPovrsina() {
		return povrsina;
	}
	
	public int getBrStanara() {
		return br_stanara;
	}
	
	public void setPovrsina(double povrsina) {
		this.povrsina = povrsina;
	}
	
	public void setBrStanara(int brStanara) {
		this.br_stanara = brStanara;
	}
	
	/* van dela za prag */
	public double porez(double cena_po_kvadratu) {
		if(br_stanara <= 2)
			return povrsina * cena_po_kvadratu;
		else
			return povrsina * cena_po_kvadratu * (1-(br_stanara-2)*0.05);
	}
	
	public String toString() {
		return "Povrsina stana je " + povrsina + " m^2." + "\nBroj stanara je " + br_stanara + ".\n";
	}
}
