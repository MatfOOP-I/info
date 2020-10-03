package rs.math.oop1.z070603.konstruktori.z13.geometrija;

public class Trougao extends GeometrijskiObjekat
{
  private Tacka a;
  private Tacka b;
  private Tacka c;
  
  
  public Trougao( String o, Tacka t1, Tacka t2, Tacka t3)
  {
	  super( o );
	  a = new Tacka(t1);
	  b = new Tacka(t2);
	  c = new Tacka(t3);
  }
	
  public Trougao( final Trougao tr)
  {
	  this( tr.getOznaka(), tr.a, tr.b, tr.c );
  }
  
  @Override
  public String toString()
  {
	   return getOznaka() + ":[" + a + ";"+ b + ";"+ c+ "]";
  }
  
  public double obim()
  {
	  return (a.rastojanje(b) + b.rastojanje(c) + c.rastojanje(a));
  }
  
  public boolean jeJednakokraki()
  {
	  if( a.rastojanje(b) == a.rastojanje(c) )
		  return true;
	  if( b.rastojanje(c) == b.rastojanje(a) )
		  return true;
	  if( c.rastojanje(b) == c.rastojanje(a) )
		  return true;
	  return false;
  }

  public boolean jeJednakostrnican()
  {
	  if( a.rastojanje(b) == a.rastojanje(c)
			  && b.rastojanje(c) == b.rastojanje(a) )
		  return true;
	  return false;
  }
  
  public double povrsina()
  {
	  double s = obim()/2;
	  return Math.sqrt(s * (s-b.rastojanje(c)) 
			  * (s- a.rastojanje(c)) 
			  * (s-a.rastojanje(b)));
  }

}
