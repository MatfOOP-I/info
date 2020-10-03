package rs.math.oop1.z070402.pozivMetoda.z10.geometrija;

class Trougao {
   String oznaka;
   Tacka a;
   Tacka b;
   Tacka c;

   void init(String o, Tacka t1, Tacka t2, Tacka t3) {
      oznaka = o;
      a = new Tacka();
      a.init(t1.oznaka, t1.x, t1.y);
      b = new Tacka();
      b.init(t2.oznaka, t2.x, t2.y);
      c = new Tacka();
      c.init(t3.oznaka, t3.x, t3.y);
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe(false);
      System.out.print(";");
      b.prikaziSe(false);
      System.out.print(";");
      c.prikaziSe(false);
      System.out.print("]");
   }

}
