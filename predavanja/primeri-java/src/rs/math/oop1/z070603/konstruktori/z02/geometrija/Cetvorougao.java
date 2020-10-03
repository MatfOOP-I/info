package rs.math.oop1.z070603.konstruktori.z02.geometrija;

public class Cetvorougao {
   private String oznaka;
   private Tacka a;
   private Tacka b;
   private Tacka c;
   private Tacka d;

   public Cetvorougao(String o, Tacka t1, Tacka t2,
            Tacka t3, Tacka t4) {
      oznaka = o;
      a = new Tacka(t1.getOznaka(), t1.getX(), t1.getY());
      b = new Tacka(t2.getOznaka(), t2.getX(), t2.getY());
      c = new Tacka(t3.getOznaka(), t3.getX(), t3.getY());
      d = new Tacka(t4.getOznaka(), t4.getX(), t4.getY());
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
      System.out.print(";");
      d.prikaziSe();
      System.out.print("]");
   }

   public double obim() {
      return a.rastojanje(b) + b.rastojanje(c)
               + c.rastojanje(d) + d.rastojanje(a);
   }

   public double povrsina() {
      Trougao t1 = new Trougao("", a, c, b);
      Trougao t2 = new Trougao("", a, c, d);
      double p1 = t1.povrsina() + t2.povrsina();
      t1 = new Trougao("", b, d, a);
      t2 = new Trougao("", b, d, c);
      double p2 = t1.povrsina() + t2.povrsina();
      return (p1 < p2) ? p1 : p2;
   }

   public boolean sadrzi(Tacka t) {
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
