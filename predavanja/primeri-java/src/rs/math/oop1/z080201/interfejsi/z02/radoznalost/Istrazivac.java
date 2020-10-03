package rs.math.oop1.z080201.interfejsi.z02.radoznalost;

public class Istrazivac extends Naucnik {
   private String probojUOblasti;

   public Istrazivac(String ime, String probojUOblasti) {
      super(ime);
      this.probojUOblasti = probojUOblasti;
   }

   @Override
   public void interesujeSe() {
      System.out.println("'" + getIme() +"' je ostvario proboj u naucnoj oblasti " + probojUOblasti +".");
   }
}
