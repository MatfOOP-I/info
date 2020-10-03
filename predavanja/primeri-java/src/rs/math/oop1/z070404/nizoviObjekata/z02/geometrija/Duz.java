package rs.math.oop1.z070404.nizoviObjekata.z02.geometrija;

class Duz {
   String oznaka;
   Tacka a;
   Tacka b;

   void init(String o, Tacka t1, Tacka t2) {
      oznaka = o;
      a = t1;
      b = t2;
   }

   void init2(String o, Tacka t1, Tacka t2) {
      oznaka = o;
      a = new Tacka();
      a.init(t1.oznaka, t1.x, t1.y);
      b = new Tacka();
      b.init(t2.oznaka, t2.x, t2.y);
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe(true);
      System.out.print(";");
      b.prikaziSe(true);
      System.out.print("]");
   }

   double duzina() {
      return a.rastojanje(b);
   }

}
