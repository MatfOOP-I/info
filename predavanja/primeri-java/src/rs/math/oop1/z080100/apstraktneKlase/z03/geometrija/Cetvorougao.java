package rs.math.oop1.z080100.apstraktneKlase.z03.geometrija;

import java.util.Objects;

public class Cetvorougao extends GeometrijskiObjekat {
   private Tacka a;
   private Tacka b;
   private Tacka c;
   private Tacka d;

   public Cetvorougao(String oznaka, Tacka a, Tacka b,
                      Tacka c, Tacka d) {
      super(oznaka);
      this.a = new Tacka(a);
      this.b = new Tacka(b);
      this.c = new Tacka(c);
      this.d = new Tacka(d);
   }

   public Cetvorougao(Tacka a, Tacka b, Tacka c, Tacka d) {
      this("", a, b, c, d);
   }

   public Cetvorougao(final Cetvorougao cetv) {
      this(cetv.getOznaka(), cetv.a, cetv.b, cetv.c,
            cetv.d);
   }


   public boolean sadrzi(Tacka t) {
      Prava p = new Prava(a, c);
      if (p.suSaRaznihStranaPrave(b, d)) {
         Trougao t1 = new Trougao(a, c, b);
         Trougao t2 = new Trougao(a, c, d);
         return t1.sadrzi(t) || t2.sadrzi(t);
      } else {
         Trougao t1 = new Trougao(b, d, a);
         Trougao t2 = new Trougao(b, d, c);
         return t1.sadrzi(t) || t2.sadrzi(t);
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Cetvorougao that = (Cetvorougao) o;
      return (a.equals(that.a) &&
            b.equals(that.b) &&
            c.equals(that.c) &&
            d.equals(that.d))
            || (a.equals(that.b) &&
            b.equals(that.c) &&
            c.equals(that.d) &&
            d.equals(that.a))
            || (a.equals(that.c) &&
            b.equals(that.d) &&
            c.equals(that.a) &&
            d.equals(that.b))
            ||(a.equals(that.d) &&
            b.equals(that.a) &&
            c.equals(that.b) &&
            d.equals(that.c));
   }

   @Override
   public int hashCode() {
      return Objects.hash(a, b, c, d);
   }

   @Override
   public String toString() {
     return getOznaka() + ":[" + a + ";" + b + ";" + c + ";" + d + "]";
   }

   @Override
   public void prikaziSe() {
      System.out.printf("%s\n", this);
   }

   @Override
   public boolean jeKonveksan() {
      Prava p = new Prava(a, b);
      if (p.suSaRaznihStranaPrave(c, d))
         return false;
      p = new Prava(b, c);
      if (p.suSaRaznihStranaPrave(a, d))
         return false;
      p = new Prava(c, d);
      if (p.suSaRaznihStranaPrave(a, b))
         return false;
      p = new Prava(d, a);
      if (p.suSaRaznihStranaPrave(b, c))
         return false;
      return true;
   }

   @Override
   public boolean jeOgranicen() {
      return true;
   }

   @Override
   public double obim() {
      return a.rastojanje(b) + b.rastojanje(c) + c.rastojanje(d) + d.rastojanje(a);
   }

   @Override
   public double povrsina() {
      Prava p = new Prava(a, c);
      if (p.suSaRaznihStranaPrave(b, d)) {
         Trougao t1 = new Trougao(a, c, b);
         Trougao t2 = new Trougao(a, c, d);
         return t1.povrsina() + t2.povrsina();
      } else {
         Trougao t1 = new Trougao(b, d, a);
         Trougao t2 = new Trougao(b, d, c);
         return t1.povrsina() + t2.povrsina();
      }
   }


}
