package funkcijeSinusoida;

public class Sinusoida extends Funkcija{
	
	private Clan clan;

	public Sinusoida(double x, Clan clan) {
		super(x);
		this.clan = new Clan(clan);
	}
	
	public String toString() {
		return clan.getA() + "*sin(" + clan.getB() + "*x*PI)";
	}

	public double vrednost() {
		return clan.getA() * Math.sin(clan.getB() * super.getX() * Math.PI);
	}
}
