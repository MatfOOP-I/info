package posiljke;

public abstract class Posiljka implements Comparable<Posiljka> {
	private int id;
	private String primalac;
	private int brojPoste;
	private boolean status; // 'false' oznacava status 'PRIJEM' koji je i inicijalni status posiljke
	                        // 'true' oznacava status 'OTPREMA'
	
	private static int tekuci_id = 1;
	
	public static int vratiSledeciId() {
		return tekuci_id++;
	}
	 
	// Konstruktor za pravljenje posiljke:
	// Posto su sve posiljke inicijalno u istom statusu 'PRIJEM' (false),
	// treci argument konstruktora nije neophodan. 
	public Posiljka(String primalac, int brojPoste) {
		this.id = vratiSledeciId();
		this.primalac = primalac;
		this.brojPoste = brojPoste;
		this.status = false; // nije neophodno
		                     // status je implicitno vec postavljen na false
	}
	
	public int getId() {
		return id;
	}
	
	public String getPrimalac() {
		return primalac;
	}

	public int getBrojPoste() {
		return brojPoste;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int compareTo(Posiljka p) {
		int rez = Integer.compare(getBrojPoste(), p.getBrojPoste());
		if(rez == 0) 
			return getPrimalac().compareTo(p.getPrimalac());
		return rez;
	}
	
	public String toString() {
		String str = id + " [";
		str += status ? "OTPREMA" // status == true  =>  'OTPREMA'
				: "PRIJEM";  // status == false  =>  'PRIJEM'
		return str + "] " + primalac + " " + brojPoste;
	}
}