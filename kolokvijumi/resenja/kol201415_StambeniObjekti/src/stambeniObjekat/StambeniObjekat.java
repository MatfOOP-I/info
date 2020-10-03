package stambeniObjekat;

public abstract class StambeniObjekat {

	private String adresa;
	
	public StambeniObjekat(String adresa) {
		this.adresa = new String(adresa);
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = new String(adresa);
	}

	/* polimorfan apstraktan metod */
	public abstract double porez(double cena_po_kvadratu);
	/* ili: polimorfan metod koji nije apstraktan 
	 * (u tom slucaju ni klasa nece biti apstraktna) */
	/*
	public double porez(double cena_po_kvadratu) {
		return 0;
    }
	*/
	//public abstract String toString();
	public String toString() {
		return "Adresa: " + adresa;
	}
}
