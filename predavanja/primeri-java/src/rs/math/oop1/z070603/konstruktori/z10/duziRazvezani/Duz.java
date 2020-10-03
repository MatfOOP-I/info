package rs.math.oop1.z070603.konstruktori.z10.duziRazvezani;

public class Duz {
  String oznaka;
  Tacka a;
  Tacka b;
  
  
  // Dobro, ali moze i bolje!
  // Duz( String o, Tacka t1, Tacka t2)
  // {
	//   oznaka = o;
	//   a = new Tacka(t1.x, t1.y, t1.oznaka);
	//   b = new Tacka(t2.x, t2.y, t2.oznaka);
  // }
	
  // Ovo je bolje
  Duz( String o, Tacka t1, Tacka t2)
  {
	  oznaka = o;
	  a = new Tacka(t1);
	  b = new Tacka(t2);
  }
  
  Duz( Duz d)
  {
	  oznaka = d.oznaka;
	  a = new Tacka(d.a);
	  b = new Tacka(d.b);
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
