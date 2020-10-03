package v13.v03Karte;

class Karta implements Comparable
{
	// Suit values
	public static final int HERC = 0;
	public static final int TREF = 1;
	public static final int KARO = 2;
	public static final int PIK = 3;

	// Card face values
	public static final int KEC = 11;
	public static final int ZANDAR = 12;
	public static final int DAMA = 13;
	public static final int KRALJ = 14;

	private int boja;
	private int vrednost;

	public Karta(int vrednost, int boja) throws IllegalArgumentException
	{
		if (vrednost >= 2 && vrednost <= KRALJ)
			this.vrednost = vrednost;
		else
			throw new IllegalArgumentException("Nekorektna vrednost");
		if (boja >= HERC && boja <= PIK)
			this.boja = boja;
		else
			throw new IllegalArgumentException("Nekorektna boja");
	}

	// Compare two cards
	public int compareTo(Object card)
	{
		if (boja != ((Karta) card).boja)
			return boja < ((Karta) card).boja ? -1 : 1;
		else if (vrednost == ((Karta) card).vrednost)
			return 0;
		else
			return vrednost < ((Karta) card).vrednost ? -1 : 1;
	}

	public String toString()
	{
		String karta;
		switch (vrednost)
		{
			case KEC :
				karta = "A";
				break;
			case ZANDAR :
				karta = "J";
				break;
			case DAMA:
				karta = "Q";
				break;
			case KRALJ :
				karta = "K";
				break;
			default :
				karta = Integer.toString(vrednost);
				break;
		}

		switch (boja)
		{
			case TREF :
				karta += "T";
				break;
			case KARO :
				karta += "K";
				break;
			case HERC :
				karta += "H";
				break;
			case PIK :
				karta += "P";
				break;
		}
		return karta;
	}

}
