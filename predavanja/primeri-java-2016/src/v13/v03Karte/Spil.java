package v13.v03Karte;

import java.util.*;
class Spil
{
	private Stack spil = new Stack();

	// Create a deck of 52 cards
	public Spil()
	{
		for (int boja = Karta.HERC; boja <= Karta.PIK; boja++)
			for (int vrednost = 2; vrednost <= Karta.KRALJ; vrednost++)
				spil.push(new Karta(vrednost, boja));
	}

	// Shuffle the deck
	public void promesaj()
	{
		Collections.shuffle(spil);
	}

	// Deal a hand
	public Ruka podeliRuku(int numCards)
	{
		Ruka hand = new Ruka();
		for (int i = 0; i < numCards; i++)
			hand.dodaj((Karta) spil.pop());
		return hand;
	}

}
