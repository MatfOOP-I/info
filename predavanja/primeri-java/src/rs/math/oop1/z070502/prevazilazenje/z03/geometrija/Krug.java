package rs.math.oop1.z070502.prevazilazenje.z03.geometrija;

import static java.lang.Math.*;

public class Krug extends GeometrijskiObjekat {
   private Tacka o;
   private double r;

   public Krug(String oznaka, Tacka o, double r) {
      super(oznaka);
      this.o = new Tacka(o);
      this.r = r;
   }

   public Krug(Tacka o, double r) {
      this("", o, r);
   }

   public Krug(final Krug kr) {
      this(kr.getOznaka(), kr.o, kr.r);
   }

   public void prikaziSe() {
      super.prikaziSe();
      System.out.print(":[");
      o.prikaziSe();
      System.out.print(";" + r + "]");
   }

   public double obim() {
      return 2 * r * PI;
   }

   public double povrsina() {
      return pow(r, 2) * PI;
   }

   public boolean sadrzi(Tacka t) {
      return t.rastojanje(o) <= r;
   }

   public boolean jeKonveksan() {
      return true;
   }

   public boolean jeOgranicen() {
      return true;
   }

}
