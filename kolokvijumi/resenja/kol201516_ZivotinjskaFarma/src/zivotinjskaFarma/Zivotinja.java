package zivotinjskaFarma;

public class Zivotinja
{
	private String ime;
	  
	public Zivotinja(String ime) {
        this.ime = ime;
    }
	
	public Zivotinja(final Zivotinja z) {
		this(z.ime);
	}

	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String toString() {
		return "";
	}
}
