package primer02Geometrija;

public class Tacka {
	private double x, y;
	
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Tacka() {
		this(0, 0);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
