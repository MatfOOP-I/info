package v06.v06Interface;

public class Macka implements Oglasavanje
{
	private String ime;
	private String rasa; 

	public Macka(String ime)
	{
		this.ime = ime; 
		rasa = "Nepoznata"; 
	}

	public Macka(String ime, String rasa)
	{
		this.ime = ime; 
		this.rasa = rasa; 
	}

	public String toString()
	{
		return super.toString() + "\nMacka. Ime je " + ime + " , a rasa je " + rasa + ".";
	}

	public void oglasiSe()
	{
		System.out.println("Mjauuuu...");
	}

}
