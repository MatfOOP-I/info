package rs.math.oop1.z080401.polimorfizam.z03.ljudiApstraktno;

class Nastavnik extends Covek 
{
  private String predmet;
  private int godinaStaza;
  
  public Nastavnik(String ime, String prezime, 
  		String predmet, int gs)
  {
  	super( ime, prezime );
  	this.predmet = predmet;
  	godinaStaza = gs;
  }

  @Override
  public String toString()
  {
    return getClass().getSimpleName() +  ": " 
      + getIme() + " " + getPrezime() + " " 
      + predmet +" " + godinaStaza + ".";
  }
  
	@Override
	public String opis()
	{
		return toString();
	}

}