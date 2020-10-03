package rs.math.oop1.z070403.metodiKlasni.z02.geometrija;

class Duz {
   String oznaka;
   Tacka a;
   Tacka b;

   static int brojInicijalizacija = 0;
   
   void init(String o, Tacka t1, Tacka t2) {
      oznaka = o;
      a = new Tacka();
      a.init(t1.getOznaka(), t1.getX(), t1.getY());
      b = new Tacka();
      b.init(t2.getOznaka(), t2.getX(), t2.getY());
      brojInicijalizacija++;
   }

   String getOznaka() {
      return oznaka;
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe(false);
      System.out.print(";");
      b.prikaziSe(false);
      System.out.print("]");
   }

   double duzina() {
      return a.rastojanje(b);
   }

   boolean sadrzi(Tacka t) {
      boolean kolinearne = ((t.getY() - a.getY())
               * (b.getX() - a.getX()) == (b.getY()
                        - a.getY())
                        * (t.getX() - a.getX()));
      double xMin = a.getX()<b.getX()? a.getX(): b.getX(); 
      double xMax = a.getX()<b.getX()? b.getX(): a.getX();
      double yMin = a.getY()<b.getY()? a.getY(): b.getY(); 
      double yMax = a.getY()<b.getY()? b.getY(): a.getY();
           return kolinearne 
                    && (t.getX() >= xMin && t.getX() <= xMax) 
                    && (t.getY() >= yMin && t.getY() <= yMax);
   }
}
