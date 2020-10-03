package rs.math.oop1.z070603.konstruktori.z01.geometrija;

import static java.lang.Math.*;

class Krug {
   String oznaka;
   Tacka o;
   double r;

   void init(String ozn, Tacka centar, double poluprecnik) {
      oznaka = ozn;
      o = new Tacka(centar.oznaka, centar.x, centar.y);
      r = poluprecnik;
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      o.prikaziSe();
      System.out.print(";" + r + "]");
   }

   double obim() {
      return 2 * r * PI;
   }

   double povrsina() {
      return pow(r, 2) * PI;
   }

   boolean sadrzi(Tacka t) {
      return t.rastojanje(o) <= r;
   }
}
