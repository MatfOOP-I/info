package rs.math.oop1.z080402.solid.z06.dobarOPovrsine;

public class Pravougaonik implements Oblik{
   private double sirina;
   private double visina;

   public Pravougaonik(double sirina, double visina) {
      this.sirina = sirina;
      this.visina = visina;
   }

   public double getSirina() {
      return sirina;
   }

   public double getVisina() {
      return visina;
   }

   @Override
   public double povrsina() {
      return sirina * visina;
   }
}
