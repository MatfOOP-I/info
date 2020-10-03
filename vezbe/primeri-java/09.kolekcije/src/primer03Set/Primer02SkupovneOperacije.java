package primer03Set;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Primer02SkupovneOperacije {
	// -------------------------------------------------------------------------------------------- 
	// Skupovi u Javi omogucavaju i skupovne operacije, no skupovne operacije
	// nisu date kao metodi eksplicitno.
	// Sledi nekoliko primera njihove upotrebe.
	// https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html
	// -------------------------------------------------------------------------------------------- 
	public static void main(String[] args) {
		Set<Integer> S1 = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> S2 = new TreeSet<>(Arrays.asList(4, 5, 6, 7, 8));
		
		System.out.println("S1:\t\t" + S1);
		System.out.println("S2:\t\t" + S2);

		Set<Integer> S1unionS2 = new TreeSet<>(S1);
		S1unionS2.addAll(S2);
		System.out.println("S1 ∪ S2:\t" + S1unionS2);
		
		Set<Integer> S1intersecS2 = new TreeSet<>(S1);
		S1intersecS2.retainAll(S2);
		System.out.println("S1 ∩ S2:\t" + S1intersecS2);
		
		Set<Integer> S1diffS2 = new TreeSet<>(S1);
		S1diffS2.removeAll(S2);
		System.out.println("S1 \\ S2:\t" + S1diffS2);
	}
}
