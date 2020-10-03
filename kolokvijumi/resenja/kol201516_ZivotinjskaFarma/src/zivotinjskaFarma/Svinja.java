package zivotinjskaFarma;

public class Svinja extends Zivotinja
{
	private String parola;
	
	public Svinja(String ime, String parola) {
		super(ime);
		this.parola = parola;
	}

	public Svinja(String ime) {
		this(ime, "Sve su zivotinje jednake");
	}

	public String toString() {
		return "Svinja " + getIme() + " kaze: '" + parola + "'";
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
}
