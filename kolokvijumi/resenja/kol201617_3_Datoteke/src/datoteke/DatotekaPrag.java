package datoteke;

public class DatotekaPrag {
	private String ime;         
	private String pravaPristupa;  
	
	public DatotekaPrag(String ime, String pravaPristupa) {
		this.ime = ime;
		this.pravaPristupa = pravaPristupa;
	}

	public DatotekaPrag(final DatotekaPrag d) {
		this(d.ime, d.pravaPristupa);
	}
	
	public String getIme() {
		return ime;
	}

	public String getPravaPristupa() {
		return pravaPristupa;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public void setPravaPristupa(String pravaPristupa) {
		this.pravaPristupa = pravaPristupa;
	}
	
	public String toString() {
		return "Datoteka " + ime + " sa pravima pristupa " + pravaPristupa;
	}
}
