package primer03Set;

public class Primer03PoligonalnaLinija {
	public static void main(String[] args) {
		double[][] ts = {
			{1, 2}, {3, 4.5}, {9, 1.1},
			{11.2, 13.1}, {1, 2}, {1, 2},
			{1, 2}, {1, 2}, {3, 4.5}
		};
		
		PoligonalnaLinija pline = new PoligonalnaLinija(ts);
		System.out.println(pline);
		
	}
}
