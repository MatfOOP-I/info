package rs.math.oop1.z080402.solid.z09.losLPovrsine;

public class Kvadrat extends Pravougaonik {

   public Kvadrat(double ivica) {
      super(ivica, ivica);
   }

   public Kvadrat() {
      this(1);
   }

   @Override
   public void setSirina(double sirina) {
      super.setSirina(sirina);
      super.setVisina(sirina);
   }

   @Override
   public void setVisina(double visina) {
      super.setSirina(visina);
      super.setVisina(visina);
   }

}
