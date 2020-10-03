package rs.math.oop1.z070903.prevazilazenje.z01.niskaReprezentacijaGeometrija;

import static java.lang.Math.*;

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
   public String toString() {
      return super.toString() + ":[" + a + ";" + b + ";" + c
               + "]";
   }

   @Override
   public boolean jeKonveksan() {
      return true;
   }

   @Override
   public boolean jeOgranicen() {
      return true;
   }

}
