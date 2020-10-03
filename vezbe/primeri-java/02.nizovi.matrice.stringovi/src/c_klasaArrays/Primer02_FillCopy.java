package c_klasaArrays;

public class Primer02_FillCopy {

	/**
	 * Program prikazuje koriscenje funkcija Arrays.Fill i Arrays.copyRange
	 */
	public static void main(String[] args) {
		// Kako da napravimo niz duzine 50 koji ima sve brojeve jednake 42?
		int[] a = new int[50];
		java.util.Arrays.fill(a, 42);
		show("a", a);
		
		// Kako iskopirati vrednosti nekog niza za date indekse?
		int[] b = java.util.Arrays.copyOfRange(a, 20, 30);
		show("b", b);
		
		// Kako iskopirati ceo niz?
		int[] c = java.util.Arrays.copyOf(a, a.length);
		show("c", c);
		
	}

	static void show(String name, int[] a) {
		System.out.println(name + ": " + java.util.Arrays.toString(a));
		
	}

}
