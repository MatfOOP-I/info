package rs.math.oop1.z080100.apstraktneKlase.z03.geometrija;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Trougao extends GeometrijskiObjekat {
   private Tacka a;
   private Tacka b;
   private Tacka c;

   public Trougao(String o, Tacka a, Tacka b, Tacka c) {
      super(o);
      this.a = new Tacka(a);
      this.b = new Tacka(b);
      this.c = new Tacka(c);
   }

   public Trougao(Tacka a, Tacka b, Tacka c) {
      this("", a, b, c);
   }

   public Trougao(final Trougao tr) {
      this(tr.getOznaka(), tr.a, tr.b, tr.c);
   }

   public boolean sadrzi(Tacka t) {
      Duz ivica = new Duz(a, b);
      if (ivica.sadrzi(t))
         return true;
      ivica = new Duz(b, c);
      if (ivica.sadrzi(t))
         return true;
      ivica = new Duz(c, a);
      if (ivica.sadrzi(t))
         return true;
      Prava p = new Prava(a, b);
      if (p.suSaRaznihStranaPrave(c, t))
         return false;
      p = new Prava(b, c);
      if (p.suSaRaznihStranaPrave(a, t))
         return false;
      p = new Prava(c, a);
      if (p.suSaRaznihStranaPrave(b, t))
         return false;
      return true;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Trougao trougao = (Trougao) o;
      return (a.equals(trougao.a) &&
            b.equals(trougao.b) &&
            c.equals(trougao.c))
            || (a.equals(trougao.b) &&
            b.equals(trougao.c) &&
            c.equals(trougao.a))
            || (a.equals(trougao.c) &&
            b.equals(trougao.a) &&
            c.equals(trougao.b));
   }

   @Override
   public int hashCode() {
      Tacka o = new Tacka(0, 0);
      return Objects.hash(a, b, c);
   }

   @Override
   public String toString() {
      return getOznaka() + ":[" + a + ";" + b + ";" + c + "]";
   }

   @Override
   public void prikaziSe() {
      System.out.printf("%s\n", this);
   }

   @Override
   public boolean jeKonveksan() {
      return true;
   }

   @Override
   public boolean jeOgranicen() {
      return true;
   }

   @Override
   public double obim() {
      return a.rastojanje(b) + b.rastojanje(c) + c.rastojanje(a);
   }

   @Override
   public double povrsina() {
      double ab = a.rastojanje(b);
      double bc = b.rastojanje(c);
      double ca = c.rastojanje(a);
      double s = (ab + bc + ca) / 2;
      return sqrt(s * (s - ab) * (s - bc) * (s - ca));
   }

}
