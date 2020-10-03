package rs.math.oop1.z070603.konstruktori.z13.geometrija;

public class Cetvorougao extends GeometrijskiObjekat
{
  private Tacka a;
  private Tacka b;
  private Tacka c;
  private Tacka d;
  
  public Cetvorougao( String o, Tacka t1, Tacka t2, Tacka t3, Tacka t4)
  {
	  super(o);
	  a = new Tacka(t1);
	  b = new Tacka(t2);
	  c = new Tacka(t3);
	  d = new Tacka(t4);
  }
	
  public Cetvorougao( final Cetvorougao cet)
  {
	  this( cet.getOznaka(), cet.a, cet.b, cet.c, cet.d );
  }
  
  @Override
  public String toString()
  {
	   return getOznaka() + ":[" + a + ";"+ b + ";"+ c+ ";"+ d + "]";
  }
  
  public double obim()
  {
	  return (a.rastojanje(b) + b.rastojanje(c) 
			  + c.rastojanje(d) + d.rastojanje(a));
  }
  
  public boolean jeRomb()
  {
	  if( a.rastojanje(b) == a.rastojanje(c)
			  && b.rastojanje(c) == c.rastojanje(d) 
			  && c.rastojanje(d) == d.rastojanje(a)
		)
		  return true;
	  return false;
  }
  
  public double povrsina()
  {
     Trougao t1 = new Trougao("t1", a,c, b);
     Trougao t2 = new Trougao("t2", a,c, d);
     double p1 =  t1.povrsina() + t2.povrsina();
     t1 = new Trougao("t1", b,d, a);
     t2 = new Trougao("t2", b,d, c);
     double p2 =  t1.povrsina() + t2.povrsina();
     return (p1<p2)?p1:p2;
  }

}
