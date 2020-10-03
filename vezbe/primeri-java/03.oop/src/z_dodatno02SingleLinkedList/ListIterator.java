package z_dodatno02SingleLinkedList;

/*	ITERATOR PATTERN

	Procitati vise ovde: https://en.wikipedia.org/wiki/Iterator_pattern
	
	Osnovna ideja je da napravimo klasu koja apstrahuje proces iteriranja kroz strukturu podataka.
	Iteriranje kroz strukture podataka mozemo opisati najcesce sa sledeca dva metoda:
	* Da li postoji sledeci element? 	- hasNext
	* Daj mi sledeci element 			- next
	
	Time dobijamo vrlo elegantan kod za iteriranje.
	
	Struktura s = ...;
	IteratorStrukture iter = new IteratorStrukture(s);
	
	while (iter.hasNext()) {
		TipPodatkaStrukture data = iter.next();
		// ...
	}
	
	Poziv metoda next() nas vraca trenutni element i pomera se na sledeci.
	Sigurni smo da smemo da zovemo next jer smo usli u petlju ciji je uslov da struktura ima sledeci element.
	
 */

public class ListIterator {
	private Node currentNode;
	
	public ListIterator(LinkedList list) {
		if (list != null)
			currentNode = list.getHead();
		else
			currentNode = null;
	}
	
	public boolean hasNext() {
		return currentNode != null;
	}
	
	public int next() {
		if (currentNode != null) {
			int tmp = currentNode.getData();
			currentNode = currentNode.getNext();
			return tmp;
		} else {
			// Ovaj slucaj ne bi ni trebalo da se desi ako korisnik koristi
			// currentNode adekvatno (poziva hasNext()), no implementirajmo za svaki slucaj
			System.out.println("Potential error, check your code! Make sure to call hasNext before calling next.");
			return 0;
		}
	}
}
