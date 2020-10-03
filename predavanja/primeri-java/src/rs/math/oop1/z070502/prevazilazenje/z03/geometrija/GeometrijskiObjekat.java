package rs.math.oop1.z070502.prevazilazenje.z03.geometrija;

public class GeometrijskiObjekat {
   public static int brojKreiranih = 0;

   private String oznaka;

   {
      brojKreiranih++;
   }

   public GeometrijskiObjekat(String oznaka) {
      this.oznaka = oznaka;
   }

   public String getOznaka() {
      return oznaka;
   }

   public void setOznaka(String oznaka) {
      this.oznaka = oznaka;
   }

   public void prikaziSe() {
      System.out.printf(oznaka);
   }

   boolean jeKonveksan() {
      return false; // ovo nikad ne treba da bude izvrseno
   }

   public boolean jeOgranicen() {
      return false; // ovo nikad ne treba da bude izvrseno
   }

}
