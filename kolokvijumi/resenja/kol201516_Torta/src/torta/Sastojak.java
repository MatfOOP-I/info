package torta;

public class Sastojak {

	private String naziv;
	private double kolicina;
	private String jedinicaMere;
	
	private static String[] sastojci = {"jaje", "brasno", "secer", "puter"};
	
	public Sastojak(String naziv, double kolicina, String jedinicaMere) {
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.jedinicaMere = jedinicaMere;
	}
	
	public Sastojak(final Sastojak s) {
		this(s.naziv, s.kolicina, s.jedinicaMere);
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}
	
	public static boolean dozvoljenSastojak(String naziv) {
		for(int i = 0; i < sastojci.length; i++)
			if(naziv.equalsIgnoreCase(sastojci[i]))
				return true;
		return false;
	}

	@Override
	public String toString() {
		return "Sastojak: " + naziv + " (kolicina: " + kolicina + " " + jedinicaMere + ")";
	}
	
	
}
