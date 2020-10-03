package rs.math.oop1.z070402.pozivMetoda.z05.geometrijaPreopterecenje;

class Duz {
   String oznaka;
   Tacka a;
   Tacka b;

   void initNeValja(String o, Tacka t1, Tacka t2) {
      oznaka = o;
      a = t1;
      b = t2;
   }

   void init(String o, Tacka t1, Tacka t2) {
      oznaka = o;
      a = new Tacka();
      a.init(t1.oznaka, t1.x, t1.y);
      b = new Tacka();
      b.init(t2.oznaka, t2.x, t2.y);
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe(false);
      System.out.print(";");
      b.prikaziSe(false);
      System.out.print("]");
   }

}
