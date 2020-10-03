package datoteke;

public abstract class ElementFajlSistema {
	private String ime;         
	private String pravaPristupa;  
	
	public ElementFajlSistema(String ime, String pravaPristupa) {
		this.ime = ime;
		this.pravaPristupa = pravaPristupa;
	}

	public String getIme() {
		return ime;
	}

	public String getPravaPristupa() {
		return pravaPristupa;
	}

	// set metod za pravaPristupa
	public void promeniPrava(String pravaPristupa) {
		this.pravaPristupa = pravaPristupa;
	}
	
	// public abstract metodi
	
	public abstract boolean jeDatoteka() ;
	public abstract boolean jeDirektorijum() ;
	public abstract void ispisiSadrzaj();
	
	// svi elementi fajl sistema imaju istu String-reprezentaciju
	public String toString() {
		return ime + " " + pravaPristupa;
	}
	
}
