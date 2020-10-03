package primer03Set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PoligonalnaLinija {
	private Set<Tacka> temena;
	
	private Set<Tacka> napraviSkup() {
		// Posto postoji vise implementacija skupa,
		// mozemo apstrahovati proces pravljenja skupa tako da ukoliko promenimo
		// implementaciju skupa, to menjamo samo u funkciji umesto u citavoj klasi.
		// Na primer, jos jedna implementacija skupa (mnogi u Java svetu kazu i "bolja") je HashSet
		return new TreeSet<>();
	}
	
	public PoligonalnaLinija() {
		temena = napraviSkup();
	}
	
	public PoligonalnaLinija(Tacka teme) {
		temena = napraviSkup();
		temena.add(new Tacka(teme));
	}
	
	public PoligonalnaLinija(double[][] koordinate) {
		temena = napraviSkup();
		for (double[] teme: koordinate)
			temena.add(new Tacka(teme[0], teme[1]));
	}
	
	public int getBrojTemena() {
		return temena.size();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Tacka> i = temena.iterator();
		while (i.hasNext())
			sb.append(i.next() + " ");
		return sb.toString();
	}
}
