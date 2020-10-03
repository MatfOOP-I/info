package rs.math.oop1.z070603.konstruktori.z11.duziKopirajuci;

public class Duz {
  String oznaka;
  Tacka a;
  Tacka b;
  
  Duz( String o, Tacka t1, Tacka t2)
  {
	  oznaka = o;
	  a = new Tacka(t1);
	  b = new Tacka(t2);
  }
  
  Duz( final Duz d)
  {
  	this(d.oznaka, d.a, d.b );
  }
  
  void prikaziSe()
  {
	   System.out.print(oznaka + ":[" );
	   a.prikaziSe();
	   System.out.print(";");
	   b.prikaziSe();	  
	   System.out.print("]");
  }
}
