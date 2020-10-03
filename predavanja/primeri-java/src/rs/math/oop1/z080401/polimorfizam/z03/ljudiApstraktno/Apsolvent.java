package rs.math.oop1.z080401.polimorfizam.z03.ljudiApstraktno;

public class Apsolvent extends Student 
{
  private int brojRokovaDoIstekaStaza;
 
  public Apsolvent (String ime, String prezime, String smer,
  		String brojIndeksa, int gs, int br)
  		{
  			super(ime, prezime, smer, 
  					brojIndeksa, gs );
  			brojRokovaDoIstekaStaza = br;
  		}

  @Override
  public String toString()
  {
    return "Apsolvent: " 
      + getIme() + " " + getPrezime() + " " 
      + getSmer() +" " + getBrojIndeksa() + " "
      + getGodinaStudija() 
      + brojRokovaDoIstekaStaza + ".";
  }
}
