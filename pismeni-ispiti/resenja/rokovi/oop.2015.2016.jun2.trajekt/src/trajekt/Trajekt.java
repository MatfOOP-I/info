package trajekt;

public class Trajekt {
	private Vozilo[] mesta;
	private double maxTez;
	private double jedCena;

	public Trajekt(int n, double t, double c) {
		mesta = new Vozilo[n];
		maxTez = t;
		jedCena = c;
	}

	public boolean uvezi(Vozilo a, int i) {
		if (a.getTezina() > maxTez) {
			System.out.println("Vozilo " + a + " ima vecu tezinu od dozvoljene!");
			return false;
		}
		if (i < 0 || i >= mesta.length) {
			System.out.println("Vozilo " + a + " ne moze da bude uparkirano na nepostojece mesto " + i + "!");
			return false;
		}
		if (mesta[i] != null) {
			System.out.println("Mesto " + i + " zauzeto! Pa vozilo " + a + " nije uparkirano.");
			return false;
		}
		mesta[i] = a;
		return true;
	}

	public boolean izvezi(int mesto) {
		int i = mesto - 1;
		if (i < 0 || i >= mesta.length)
			return false;
		if (mesta[i] == null)
			return false;
		mesta[i] = null;
		return true;
	}

	public double prihod() {
		double prihod = 0;
		for (int i = 0; i < mesta.length; i++)
			if (mesta[i] != null)
				prihod += mesta[i].getTezina() * jedCena;
		return prihod;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < mesta.length; i++)
			str.append((mesta[i] != null) ? mesta[i] : "-- slobodno --").append('\n');
		return str.toString();
	}
}
