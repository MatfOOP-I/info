package primer01LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Primer02Iterator {
	public static void main(String[] args) {
		LinkedList<String> imena = new LinkedList<>();
		imena.add("Zdravo");
		imena.add("svete");
		imena.add("kako");
		imena.add("si");
		imena.add("?");
		
		// --------------------------------------------------------------------------------------------------
		// Kroz listu mozemo iterirati koristeci iterator.
		// Metod 'hasNext()' vraca true ako postoji sledeci element u kolekciji,
		//   false inace.
		// Metod 'next()' prelazi preko sledeceg elementa koji vraca, i pozicionira se "malo pre"
		// narednog elementa. Najcesce ovo zamisljamo tako sto iterator ne pokazuje direktno na element,
		// nego malo "pre" njega.
		// [1, 2, 3, 4, 5, 6]
		//       ^ iterator
		// Poziv 'next()' vraca 3 (prelazimo preko elementa 3) i pozicionira se malo pre elementa 4.
		// --------------------------------------------------------------------------------------------------
		
		// --------------------------------------------------------------------------------------------------
		// Konstruisemo iterator koji se krece po elementima ciji je tip 'String'.
		// Kolekcije u javi imaju metod 'iterator()' koji nam vraca iterator.
		// Ono sto je kljucna ideja sa iteratorima jeste da kod koji iterira kroz strukturu izgleda
		// isto bez obzira na to kroz koju strukturu iteriramo.
		// --------------------------------------------------------------------------------------------------
		Iterator<String> iter = imena.iterator();
		while (iter.hasNext()) {
			String e = iter.next();
			System.out.println(e);
		}
	}
}
