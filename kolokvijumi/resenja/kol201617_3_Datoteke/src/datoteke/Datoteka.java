package datoteke;

public class Datoteka extends ElementFajlSistema {

	private String sadrzaj;  // private sadrzaj
	
	public Datoteka(String ime, String pravaPristupa, String sadrzaj) {
		super(ime, pravaPristupa);
		this.sadrzaj = sadrzaj;
	}
	
	@Override
	public boolean jeDatoteka() {
		return true;
	}

	@Override
	public boolean jeDirektorijum() {
		return false;
	}

	@Override
	public void ispisiSadrzaj() {
		System.out.println(sadrzaj);
	}
}
