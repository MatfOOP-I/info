package rs.math.oop1.z140500.ispitivanjeZabeleski.z02.geometrija;

import java.awt.Graphics;

@PreambulaKlase (
	   author = "Vladimir Filipovic",
	   date = "3/17/2002",
	   currentRevision = 1,
	   lastModified = "4/12/2014",
	   lastModifiedBy = "Marija Milanovic",
	   // Note array notation
	   reviewers = {"Marko Markovic", "Janko Jankovic", "Janko Jankovic"}
	)
public class Duz extends GeometrijskiObjekat implements Prikaz
{
  private Tacka a;
  private Tacka b;
  
  public Duz( String o, Tacka t1, Tacka t2)
  {
	  setOznaka(o);
	  a = new Tacka(t1);
	  b = new Tacka(t2);
  }
	
  public Duz( final Duz d)
  {
	  this( d.getOznaka(), d.a, d.b );
  }
  
  public void prikaziSe()
  {
	   System.out.print(getOznaka() + ":[" );
	   a.prikaziSe();
	   System.out.print(";");
	   b.prikaziSe();	  
	   System.out.print("]");
  }
  
  public void prikaziSe(Graphics zaslon)
  {
	  a.prikaziSe(zaslon);
	  b.prikaziSe(zaslon);
	  zaslon.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
  }

  public double duzina()
  {
	  return a.rastojanje(b);
  }

}
