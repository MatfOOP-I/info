package rs.math.oop1.z070403.metodiKlasni.z02.geometrija;

class Cetvorougao {
   String oznaka;
   Tacka a;
   Tacka b;
   Tacka c;
   Tacka d;
   
   static int brojInicijalizacija = 0;

   void init(String o, Tacka t1, Tacka t2, Tacka t3,
            Tacka t4) {
      oznaka = o;
      a = new Tacka();
      a.init(t1.getOznaka(), t1.getX(), t1.getY());
      b = new Tacka();
      b.init(t2.getOznaka(), t2.getX(), t2.getY());
      c = new Tacka();
      c.init(t3.getOznaka(), t3.getX(), t3.getY());
      d = new Tacka();
      d.init(t4.getOznaka(), t4.getX(), t4.getY());   
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
      System.out.print(";");
      c.prikaziSe(false);
      System.out.print(";");
      d.prikaziSe(false);
      System.out.print("]");
   }

   double obim() {
      return a.rastojanje(b) + b.rastojanje(c)
               + c.rastojanje(d) + d.rastojanje(a);
   }

   double povrsina() {
      Trougao t1 = new Trougao();
      t1.init("", a, c, b);
      Trougao t2 = new Trougao();
      t2.init("", a, c, d);
      double p1 = t1.povrsina() + t2.povrsina();
      t1.init("", b, d, a);
      t2.init("", b, d, c);
      double p2 = t1.povrsina() + t2.povrsina();
      return (p1 < p2) ? p1 : p2;
   }

   boolean sadrzi(Tacka t) {
      Trougao t1 = new Trougao();
      t1.init("", a, c, b);
      Trougao t2 = new Trougao();
      t2.init("", a, c, d);
      Trougao t3 = new Trougao();
      t3.init("", b, d, a);
      Trougao t4 = new Trougao();
      t4.init("", b, d, c);
      if (t1.povrsina() + t2.povrsina() <= t3.povrsina()
               + t4.povrsina())
         return t1.sadrzi(t) || t2.sadrzi(t);
      else
         return t3.sadrzi(t) || t4.sadrzi(t);

   }
}
