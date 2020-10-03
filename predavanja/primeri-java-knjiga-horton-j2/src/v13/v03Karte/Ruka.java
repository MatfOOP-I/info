// Class defining a hand of cards
package v13.v03Karte;

import java.util.*;

class Ruka
{
	private Stack ruka = new Stack(); // Stores the cards in the hand

	public void dodaj(Karta card)
	{
		ruka.push(card);
	}

	public String toString()
	{
		Iterator cards = ruka.iterator();

		StringBuffer str = new StringBuffer();
		while (cards.hasNext())
			str.append(" " + (Karta) cards.next());
		return str.toString();
	}

}
