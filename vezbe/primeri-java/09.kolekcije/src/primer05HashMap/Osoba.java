package primer05HashMap;

public class Osoba
{
	private String ime;
	private String prezime;

	public Osoba(String ime, String prezime)
	{
		this.ime = ime;
		this.prezime = prezime;
	}

	public String toString()
	{
		return ime + " " + prezime;
	}
	
	/*
		Da bismo postigli zeljenu funkcionalnost, moramo predefinisati
		metod equals iz klase Object. Ako metod vrati true za dva
		objekta, njihovi hes kodovi moraju biti jednaki.
 	*/
	public boolean equals(Object osoba)
	{
		return prezime.compareTo(((Osoba) osoba).prezime) == 0 &&
				ime.compareTo(((Osoba) osoba).ime) == 0;
	}
	
	/*
		Predefinisemo i metod hashCode(). Hes kod svakog polja
		pomnozicemo razlicitim prostim brojevima.
 	*/
	public int hashCode()
	{
		return 7*ime.hashCode() + 13*prezime.hashCode();
	}
}
