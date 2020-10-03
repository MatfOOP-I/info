package zivotinjskaFarma;

public class Direktiva
{
	private String ime;
	private String naredba;
    
	public Direktiva(String ime, String naredba) {
        this.ime = ime;
        this.naredba = naredba;
    }

    public Direktiva(final Direktiva direktiva) {
        this(direktiva.ime, direktiva.naredba);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getNaredba() {
        return naredba;
    }

    public void setNaredba(String naredba) {
        this.naredba = naredba;
    }

    public String toString() {
    	return ime + " je dobio naredbu:\n" + naredba;
    }
}

