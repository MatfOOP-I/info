package rs.math.oop1.z070603.konstruktori.z01.geometrija;

class Cetvorougao {
   String oznaka;
   Tacka a;
   Tacka b;
   Tacka c;
   Tacka d;

   Cetvorougao(String o, Tacka t1, Tacka t2, Tacka t3,
            Tacka t4) {
      oznaka = o;
      a = new Tacka(t1.oznaka, t1.x, t1.y);
      b = new Tacka(t2.oznaka, t2.x, t2.y);
      c = new Tacka(t3.oznaka, t3.x, t3.y);
      d = new Tacka(t4.oznaka, t4.x, t4.y);
   }

   void prikaziSe() {
      System.out.print(oznaka + ":[");
      a.prikaziSe();
      System.out.print(";");
      b.prikaziSe();
      System.out.print(";");
      c.prikaziSe();
      System.out.print(";");
      d.prikaziSe();
      System.out.print("]");
   }

   double obim() {
      return a.rastojanje(b) + b.rastojanje(c)
               + c.rastojanje(d) + d.rastojanje(a);
   }

   double povrsina() {
      Trougao t1 = new Trougao("", a, c, b);
      Trougao t2 = new Trougao("", a, c, d);
      double p1 = t1.povrsina() + t2.povrsina();
      t1 = new Trougao("", b, d, a);
      t2 = new Trougao("", b, d, c);
      double p2 = t1.povrsina() + t2.povrsina();
      return (p1 < p2) ? p1 : p2;
   }

   boolean sadrzi(Tacka t) {
      Trougao t1 = new Trougao("", a, c, b);
      Trougao t2 = new Trougao("", a, c, d);
      Trougao t3 = new Trougao("", b, d, a);
      Trougao t4 = new Trougao("", b, d, c);
      if (t1.povrsina() + t2.povrsina() <= t3.povrsina()
               + t4.povrsina())
         return t1.sadrzi(t) || t2.sadrzi(t);
      else
         return t3.sadrzi(t) || t4.sadrzi(t);

   }

}
