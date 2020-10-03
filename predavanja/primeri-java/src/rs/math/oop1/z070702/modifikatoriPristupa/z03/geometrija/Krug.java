package rs.math.oop1.z070702.modifikatoriPristupa.z03.geometrija;

public class Krug {
   private String oznaka;
   private Tacka o;
   private double r;
 
   private final double PI = Math.PI;
   
   public void init(String ozn, Tacka centar,
            double poluprecnik) {
      oznaka = ozn;
      o = new Tacka();
      o.init(centar.getOznaka(), centar.getX(),
               centar.getY());
      r = poluprecnik;
    }

   public void prikaziSe() {
      System.out.print(oznaka + ":[");
      o.prikaziSe(false);
      System.out.print(";" + r + "]");
   }

   public double obim() {
      return 2 * r * PI;
   }

   public double povrsina() {
      return Math.pow(r, 2) * PI;
   }

   public boolean sadrzi(Tacka t) {
      return t.rastojanje(o) <= r;
   }
}
