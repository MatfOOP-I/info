package rs.math.oop1.z070601.inicijalizacioniBlokPrimerka.z04.geometrija;

public class Tacka {
   public static int brojKreiranih = 0;

   private String oznaka;
   private double x;
   private double y;

   // inicijalizacioni blok primerka
   {
      Tacka.brojKreiranih++;
   }

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

   public void prikaziSe() {
      System.out.printf(oznaka + "(" + x + "," + y + ")");
   }

   public double rastojanje(Tacka t) {
      return (Math.sqrt(Math.pow(t.x - x, 2) + Math.pow(t.y - y, 2)));
   }

}
