package datoteke;

public class Direktorijum extends ElementFajlSistema {

	private ElementFajlSistema[] sadrzaj;
	
	public Direktorijum(String ime, String pravaPristupa, ElementFajlSistema[] fajlovi) {
		super(ime, pravaPristupa);
		sadrzaj = fajlovi;
	}
	
	// pravi prazan direktorijum
	public Direktorijum(String ime, String pravaPristupa) {
		super(ime, pravaPristupa);
		sadrzaj = null;   // sadrzaj se postavlja na null 
	}
	
	@Override
	public boolean jeDatoteka() {
		return false;
	}

	@Override
	public boolean jeDirektorijum() {
		return true;
	}

	@Override
	public void ispisiSadrzaj() {
		if(sadrzaj == null)
			return;
		for(ElementFajlSistema x : sadrzaj)
			if(x != null)
				System.out.println(x);
		
	}
}
