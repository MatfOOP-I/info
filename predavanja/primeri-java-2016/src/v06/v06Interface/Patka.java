package v06.v06Interface;

public class Patka implements Oglasavanje
{
	private String ime; 
	private String vrsta; 

	public Patka(String ime)
	{
		this.ime = ime; 
		this.vrsta = "Nepoznata"; 
	}

	public Patka(String ime, String vrsta)
	{
		this.ime = ime; 
		this.vrsta = vrsta; 
	}

	public String toString()
	{
		return super.toString() + "\nPatka. Ime je " + ime + " , vrsta je " + vrsta + ".";
	}

	public void oglasiSe()
	{
		System.out.println("Kvak kvak kavak");
	}

}
