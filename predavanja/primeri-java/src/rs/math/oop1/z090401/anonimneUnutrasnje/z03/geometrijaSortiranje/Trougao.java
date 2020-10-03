package rs.math.oop1.z090401.anonimneUnutrasnje.z03.geometrijaSortiranje;

import java.awt.Graphics;

public class Trougao extends GeometrijskiObjekat implements Prikaz, Mera
{
  private Tacka a;
  private Tacka b;
  private Tacka c;
  
  public Trougao( String o, Tacka t1, Tacka t2, Tacka t3)
  {
	  setOznaka( o );
	  a = new Tacka(t1);
	  b = new Tacka(t2);
	  c = new Tacka(t3);
  }
	
  public Trougao( final Trougao tr)
  {
	  this( tr.getOznaka(), tr.a, tr.b, tr.c );
  }
  
  public void prikaziSe()
  {
	   System.out.print(getOznaka() + ":[" );
	   a.prikaziSe();
	   System.out.print(";");
	   b.prikaziSe();	  
	   System.out.print(";");
	   c.prikaziSe();	  
	   System.out.print("]");
  }
  
  public void prikaziSe(Graphics zaslon)
  {
	  a.prikaziSe(zaslon);
	  b.prikaziSe(zaslon);
	  c.prikaziSe(zaslon);
	  zaslon.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
	  zaslon.drawLine(b.getX(), b.getY(), c.getX(), c.getY());
	  zaslon.drawLine(c.getX(), c.getY(), a.getX(), a.getY());
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
