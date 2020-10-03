package pakovanje;

public class Valjak extends Paket {
	private double a;
	private double h;

	public Valjak(double a, double h) {
		this.a = a;
		this.h = h;
	}

	public double zapremina() {
		return a * a * Math.PI * h;
	}

	public char vrsta() {
		return 'V';
	}

	public String toString() {
		return super.toString() + '(' + a + ", "+ h +')' + ", V = " + String.format( "%.2f", zapremina() );
	}
}
