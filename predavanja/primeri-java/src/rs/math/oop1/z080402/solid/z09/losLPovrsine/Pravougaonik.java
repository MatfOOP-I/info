package rs.math.oop1.z080402.solid.z09.losLPovrsine;

public class Pravougaonik {
   private double sirina;
   private double visina;

   public Pravougaonik(double sirina, double visina) {
      this.sirina = sirina;
      this.visina = visina;
   }

   public Pravougaonik() {
      this(2,1);
   }

   public double getSirina() {
      return sirina;
   }

   public void setSirina(double sirina) {
      this.sirina = sirina;
   }

   public double getVisina() {
      return visina;
   }

   public void setVisina(double visina) {
      this.visina = visina;
   }

   public double povrsina(){
      return sirina * visina;
   }
}
