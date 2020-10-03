package rs.math.oop1.z080201.interfejsi.z06.radoznalost;

public class Istrazivac extends Naucnik implements Eksperimentator{
   String probojUOblasti;

   public Istrazivac(String ime, String probojUOblasti) {
      super(ime);
      this.probojUOblasti = probojUOblasti;
   }

   @Override
   public void interesujeSe() {
      System.out.println("'" + getIme() +"' je ostvario proboj u naucnoj oblasti " + probojUOblasti +".");
   }

   @Override
   public void realizujeEksperimente() {
      System.out.print("'" + getIme() +"' je pomocu brojnih eksperimenata ");
      System.out.println("izvrsio proboj u naucnoj oblasti " + probojUOblasti +".");
   }
}
