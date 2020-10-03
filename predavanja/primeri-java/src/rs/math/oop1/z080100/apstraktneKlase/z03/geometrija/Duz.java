package rs.math.oop1.z080100.apstraktneKlase.z03.geometrija;

import java.util.Objects;

public class Duz extends GeometrijskiObjekat {
   private Tacka a;
   private Tacka b;

   public Duz(String oznaka, Tacka a, Tacka b) {
      super(oznaka);
      this.a = new Tacka(a);
      this.b = new Tacka(b);
   }

   public Duz(Tacka a, Tacka b) {
      this("", a, b);
   }

   public Duz(final Duz d) {
      this(d.getOznaka(), d.a, d.b);
   }

   public double duzina() {
      return a.rastojanje(b);
   }

   public boolean sadrzi(Tacka t) {
      boolean kolinearne = ((t.getY() - a.getY())
               * (b.getX() - a.getX()) == (b.getY()
                        - a.getY())
                        * (t.getX() - a.getX()));
      return kolinearne && t.getX() >= a.getX()
               && t.getX() <= b.getX()
               && t.getY() >= a.getY()
               && t.getY() <= b.getY();
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Duz duz = (Duz) o;
      return (a.equals(duz.a) &&
            b.equals(duz.b))
            || (a.equals(duz.b) &&
            b.equals(duz.a));
   }

   @Override
   public int hashCode() {
      Tacka o = new Tacka(0,0);
      if( o.rastojanje(a) <= o.rastojanje(b) )
         return Objects.hash(a, b);
      else
         return Objects.hash(b, a);
   }

   @Override
   public String toString() {
     return getOznaka() + ":[" + a + ";" + b + "]";
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
      return a.rastojanje(b);
   }

   @Override
   public double povrsina() {
      return 0;
   }

}
