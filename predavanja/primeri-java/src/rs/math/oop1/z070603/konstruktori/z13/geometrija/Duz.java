package rs.math.oop1.z070603.konstruktori.z13.geometrija;

public class Duz extends GeometrijskiObjekat
{
  private Tacka a;
  private Tacka b;
  
  public Duz( String o, Tacka t1, Tacka t2)
  {
	  super(o);
	  a = new Tacka(t1);
	  b = new Tacka(t2);
  }
	
  public Duz( final Duz d)
  {
	  this( d.getOznaka(), d.a, d.b );
  }
  
  @Override
  public String toString()
  {
	   return getOznaka() + ":[" + a + ";" + b+ "]";
  }
  
  public double duzina()
  {
	  return a.rastojanje(b);
  }
}
