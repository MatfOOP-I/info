package v06.v06Interface;

public class Pas implements Oglasavanje
{
	private String ime; 
	private String rasa; 

	public Pas(String ime)
	{
		this.ime = ime; 
		this.rasa = "Nepoznata"; 
	}

	public Pas(String ime, String rasa)
	{
		this.ime = ime; 
		this.rasa = rasa; 
	}

	public String toString()
	{
		return super.toString() + "\nPas. Ime je " + ime + " , rasa je " + rasa + ".";
	}

	public void oglasiSe()
	{
		System.out.println("Av, Av, Av!");
	}

}
