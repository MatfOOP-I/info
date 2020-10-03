package rs.math.oop1.z070603.konstruktori.z01.geometrija;

import static java.lang.Math.*;

class Trougao {
   String oznaka;
   Tacka a;
   Tacka b;
   Tacka c;

   Trougao(String o, Tacka t1, Tacka t2, Tacka t3) {
      oznaka = o;
      a = new Tacka(t1.oznaka, t1.x, t1.y);
      b = new Tacka(t2.oznaka, t2.x, t2.y);
      c = new Tacka(t3.oznaka, t3.x, t3.y);
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe();
      System.out.print(";");
      b.prikaziSe();
      System.out.print(";");
      c.prikaziSe();
      System.out.print("]");
   }

   double obim() {
      return a.rastojanje(b) + b.rastojanje(c)
               + c.rastojanje(a);
   }

   double povrsina() {
      double ab = a.rastojanje(b);
      double bc = b.rastojanje(c);
      double ca = c.rastojanje(a);
      double s = (ab + bc + ca) / 2;
      return sqrt(s * (s - ab) * (s - bc) * (s - ca));
   }

   boolean sadrzi(Tacka t) {
      double p1 = new Trougao("", a, b, t).povrsina();
      double p2 = new Trougao("", b, c, t).povrsina();
      double p3 = new Trougao("", c, a, t).povrsina();
      return p1 + p2 + p3 == povrsina();
   }
}
