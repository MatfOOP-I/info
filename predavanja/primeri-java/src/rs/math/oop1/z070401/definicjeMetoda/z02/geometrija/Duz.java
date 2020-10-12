package rs.math.oop1.z070401.definicjeMetoda.z02.geometrija;

class Duz {
   String oznaka;
   Tacka a;
   Tacka b;

   // ovako ne valja!
   void init(String o, Tacka t1, Tacka t2) {
      oznaka = o;
      a = t1;
      b = t2;
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe(true);
      System.out.print(";");
      b.prikaziSe(true);
      System.out.print("]");
   }

}
