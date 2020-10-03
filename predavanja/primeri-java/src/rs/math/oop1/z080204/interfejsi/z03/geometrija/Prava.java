package rs.math.oop1.z080204.interfejsi.z03.geometrija;

import static java.lang.Math.abs;

public class Prava extends GeometrijskiObjekat implements  Oblik, Prikaz, Sadrzavanje{

   private double a;
   private double b;
   private double c;

   public Prava(String oznaka, double a, double b,
                double c) {
      super(oznaka);
      this.a = a;
      this.b = b;
      this.c = c;
   }

   public Prava(double a, double b, double c) {
      this("", a, b, c);
   }

   public Prava(String oznaka, Tacka t1, Tacka t2) {
      super(oznaka);
      a = t2.getY() - t1.getY();
      b = t1.getX() - t2.getX();
      c = t1.getY() * (t2.getX() - t1.getX()) - t1.getX() * (t2.getY() - t1.getY());
   }

   public Prava(Tacka t1, Tacka t2) {
      this("", t1, t2);
   }

   private double uvrstiKoordinate(Tacka t) {
      return a * t.getX() + b * t.getY() + c;
   }

   public boolean suSaIsteStranePrave(Tacka t1, Tacka t2) {
      return uvrstiKoordinate(t1) * uvrstiKoordinate(t2) > 0;
   }

   public boolean suSaRaznihStranaPrave(Tacka t1, Tacka t2) {
      return !suSaIsteStranePrave(t1, t2);
   }

   @Override
   public boolean equals(Object drugi) {
      if (this == drugi)
         return true;
      if (drugi == null)
         return false;
      if (getClass() != drugi.getClass())
         return false;
      Prava q = (Prava) drugi;
      if (a / q.a == b / q.b && a / q.a == c / q.c)
         return true;
      return false;
   }

   @Override
   public int hashCode() {
      double m = a;
      if (abs(b) > abs(m))
         m = b;
      if (abs(c) > abs(m))
         m = c;
      return 3 * (new Double(a / m)).hashCode()
            + 5 * (new Double(b / m)).hashCode()
            + 7 * (new Double(c / m)).hashCode();
   }

   @Override
   public String toString() {
      return getOznaka() + ":[a=" + a + ";b=" + b + ";c=" + c + "]";
   }

   @Override
   public void prikaziNaKonzoli() {
      System.out.printf("%s", this);
   }

   @Override
   public boolean jeKonveksan() {
      return true;
   }

   @Override
   public boolean jeOgranicen() {
      return false;
   }

   @Override
   public boolean sadrzi(Tacka t) {
      return (uvrstiKoordinate(t) == 0);
   }



}
