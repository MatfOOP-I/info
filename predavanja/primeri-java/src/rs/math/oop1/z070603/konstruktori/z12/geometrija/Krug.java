package rs.math.oop1.z070603.konstruktori.z12.geometrija;

import static java.lang.Math.*;

public class Krug {
   private String oznaka;
   private Tacka o;
   private double r;

   public Krug(String ozn, Tacka centar, double poluprecnik) {
      oznaka = ozn;
      o = new Tacka(centar);
      r = poluprecnik;
   }

   // kopirajuci konstruktor
   public Krug(final Krug kr) {
      this(kr.oznaka, kr.o, kr.r);
   }

   public String getOznaka() {
      return oznaka;
   }

   public void prikaziSe() {
      System.out.print(oznaka + ":[");
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
}
