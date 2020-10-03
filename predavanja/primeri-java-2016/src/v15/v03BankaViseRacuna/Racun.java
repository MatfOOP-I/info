package v15.v03BankaViseRacuna;
// Defines a customer account
public class Racun
{
	private int balans;                             // The current account balance
	private int brojRacuna;                       // Identifies this account

	// Constructor
	public Racun(int brojRacuna, int balans)
	{
		this.brojRacuna = brojRacuna;            // Set the account number
		this.balans = balans;                        // Set the initial balance
	}

	// Return the current balance
	public int getBalans()
	{  return balans;  }

	// Set the current balance
	public void setBalans(int balance)
	{  this.balans = balance;  }

	public int getBrojRacuna()
	{  return brojRacuna;  }

	public String toString()
	{
		return "Racun broj: "+brojRacuna+" , balans: "+balans;
	}

}
