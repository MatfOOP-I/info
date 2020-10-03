package rs.math.oop1.z070801.konstantnaPolja.z02.geometrija;

import static java.lang.Math.*;

class Trougao {

   String oznaka;
   Tacka a;
   Tacka b;
   Tacka c;

   void init(String o, Tacka t1, Tacka t2, Tacka t3) {
      oznaka = o;
      a = new Tacka();
      a.init(t1.getOznaka(), t1.getX(), t1.getY());
      b = new Tacka();
      b.init(t2.getOznaka(), t2.getX(), t2.getY());
      c = new Tacka();
      c.init(t3.getOznaka(), t3.getX(), t3.getY());
   }

   String getOznaka() {
      return oznaka;
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

   double obim() {
      return a.rastojanje(b) + b.rastojanje(c) + c.rastojanje(a);
   }

   double povrsina() {
      double ab = a.rastojanje(b);
      double bc = b.rastojanje(c);
      double ca = c.rastojanje(a);
      double s = (ab + bc + ca) / 2;
      return sqrt(s * (s - ab) * (s - bc) * (s - ca));
   }

   boolean sadrzi(Tacka t) {
      Trougao t1 = new Trougao();
      t1.init("", a, b, t);
      double p1 = t1.povrsina();
      Trougao t2 = new Trougao();
      t2.init("", b, c, t);
      double p2 = t2.povrsina();
      Trougao t3 = new Trougao();
      t3.init("", c, a, t);
      double p3 = t3.povrsina();
      return p1 + p2 + p3 == povrsina();
   }
}
