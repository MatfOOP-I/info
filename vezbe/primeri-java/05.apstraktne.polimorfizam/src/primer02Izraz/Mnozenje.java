package primer02Izraz;

public class Mnozenje extends BinarnaOperacija {

	public Mnozenje(Izraz levi, Izraz desni) {
		super(levi, desni);
	}

	@Override
	public char karakterOperacije() {
		return '*';
	}

	@Override
	public double izracunaj() {
		return getLevi().izracunaj() * getDesni().izracunaj();
	}
	
}
