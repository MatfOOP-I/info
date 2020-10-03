package rs.math.oop1.z070603.konstruktori.z01.geometrija;

class Duz {
   String oznaka;
   Tacka a;
   Tacka b;

   Duz(String o, Tacka t1, Tacka t2) {
      oznaka = o;
      a = new Tacka(t1.oznaka, t1.x, t1.y);
      b = new Tacka(t2.oznaka, t2.x, t2.y);
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe();
      System.out.print(";");
      b.prikaziSe();
      System.out.print("]");
   }

   double duzina() {
      return a.rastojanje(b);
   }

   boolean sadrzi(Tacka t) {
      boolean kolinearne = ((t.y - a.y)
               * (b.x - a.x) == (b.y - a.y) * (t.x - a.x));
      return kolinearne && 
               ((t.x >= a.x && t.x <= b.x)|| (t.x >= b.x && t.x <= a.x));
   }
}
