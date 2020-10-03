package primer02NizIzuzeci;

public class Niz {
	private int[] a;
	
	public Niz(int n) {
		a = new int[n];
	}
	
	public Niz(int[] tmp) {
		a = new int[tmp.length];
		for (int i = 0; i < tmp.length; i++)
			a[i] = tmp[i];
	}
	
	public int length() {
		return a.length;
	}
	
	public int get(int i) {
		// Primer kako mozemo da "ispalimo" izuzetak kada
		// detektujemo odredjenu gresku u nasem kodu.
		if (i < 0 || i >= a.length)
			// throw new ArrayIndexOutOfBoundsException();
			// Ukoliko navedemo String u konstruktoru, taj string se
			// vraca kada se nad izuzetkom pozove metod 'getMessage'.
			throw new ArrayIndexOutOfBoundsException("Lose indeksiranje!");
			// Ispaljivanje ovog izuzetka prekida izvrsavanje funkcije.
		return a[i];
	}
	
	@Override
	public String toString() {
		return java.util.Arrays.toString(a);
	}
	
}

