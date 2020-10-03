package rs.math.oop1.z070702.modifikatoriPristupa.z03.geometrija;

public class Tacka {
   private String oznaka;
   private double x;
   private double y;

   public void init(String o, double xKoord, double yKoord) {
      x = xKoord;
      y = yKoord;
      oznaka = o;
   }

   public String getOznaka() {
      return oznaka;
   }

   public double getX() {
      return x;
   }

   public double getY() {
      return y;
   }

   public void prikaziSe(boolean bezOznake) {
      System.out.print((bezOznake ? "" : oznaka) + "(" + x
               + "," + y + ")");
   }

   public double rastojanje(Tacka t) {
      return (Math.sqrt(Math.pow(t.x - x, 2)
               + Math.pow(t.y - y, 2)));
   }

}
