package rs.math.oop1.z070603.konstruktori.z05.geometrijaPreopterecenje;

import static java.lang.Math.*;

public class Trougao {
   private String oznaka;
   private Tacka a;
   private Tacka b;
   private Tacka c;

   public Trougao(String o, Tacka t1, Tacka t2, Tacka t3) {
      oznaka = o;
      a = new Tacka(t1.getOznaka(), t1.getX(), t1.getY());
      b = new Tacka(t2.getOznaka(), t2.getX(), t2.getY());
      c = new Tacka(t3.getOznaka(), t3.getX(), t3.getY());
   }

   public String getOznaka() {
      return oznaka;
   }

   public void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe();
      System.out.print(";");
      b.prikaziSe();
      System.out.print(";");
      c.prikaziSe();
      System.out.print("]");
   }

   public double obim() {
      return a.rastojanje(b) + b.rastojanje(c)
               + c.rastojanje(a);
   }

   public double povrsina() {
      double ab = a.rastojanje(b);
      double bc = b.rastojanje(c);
      double ca = c.rastojanje(a);
      double s = (ab + bc + ca) / 2;
      return sqrt(s * (s - ab) * (s - bc) * (s - ca));
   }

   public boolean sadrzi(Tacka t) {
      Trougao t1 = new Trougao("", a, b, t);
      double p1 = t1.povrsina();
      Trougao t2 = new Trougao("", b, c, t);
      double p2 = t2.povrsina();
      Trougao t3 = new Trougao("", c, a, t);
      double p3 = t3.povrsina();
      return p1 + p2 + p3 == povrsina();
   }
}
