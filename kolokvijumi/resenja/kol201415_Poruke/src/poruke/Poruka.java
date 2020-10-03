package poruke;

public class Poruka {

	private String tekst_poruke;
	
	public Poruka(String tekst_poruke) {
		// kako je objekat klase String nepromenljiv, moze da stoji samo
		this.tekst_poruke = tekst_poruke;
	}
	
	public Poruka(final Poruka p) {
		this(p.tekst_poruke);
	}
	
	public String getTekstPoruke() {
		return tekst_poruke;
	}
	
	public void setTekstPoruke(String tekst_poruke) {
		this.tekst_poruke = tekst_poruke;
	}
	
	public String toString() {
		return "Tajna poruka: " + tekst_poruke;
	}
}
