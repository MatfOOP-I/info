package rs.math.oop1.z070603.konstruktori.z09.duziVezani;

public class Duz {
  String oznaka;
  Tacka a;
  Tacka b;
  
  Duz( String o, Tacka t1, Tacka t2)
  {
	  oznaka = o;
	  a = t1;
	  b = t2;
  }
	
  
  void prikaziSe()
  {
	   System.out.print(oznaka + ":[" );
	   a.prikaziSe();
	   System.out.print(";");
	   b.prikaziSe();	  
	   System.out.print("]");
  }
  
  double duzina()
  {
  	return a.rastojanje( b );
  }
}
