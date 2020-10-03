package rs.math.oop1.z080201.interfejsi.z06.radoznalost;

public class PokretanjeRadoznalost {

   public static void main(String... args) {

      Eksperimentator eksp = new Istrazivac("petrovic", "molekularna biologija");
      eksp.pita();
      eksp.interesujeSe();
      eksp.realizujeEksperimente();
      System.out.println();

      Radoznao r = new Naucnik("markovic");
      r.pita();
      r.interesujeSe();
      System.out.println();

      r = eksp;
      r.pita();
      r.interesujeSe();
      System.out.println();

   }

}
