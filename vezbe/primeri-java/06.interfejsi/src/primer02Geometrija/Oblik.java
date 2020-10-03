package primer02Geometrija;

public abstract class Oblik {
	private Tacka centar;
	
	public Oblik(Tacka centar) {
		this.centar = centar;
	}
	
	public Tacka getCentar() {
		return centar;
	}
}
