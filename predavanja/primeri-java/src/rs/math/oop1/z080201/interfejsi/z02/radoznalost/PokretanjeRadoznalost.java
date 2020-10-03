package rs.math.oop1.z080201.interfejsi.z02.radoznalost;

public class PokretanjeRadoznalost {

   public static void main(String... args) {

      Radoznao r = new Naucnik("markovic");
      r.pita();
      r.interesujeSe();
      System.out.println();

      r = new Istrazivac("petrovic", "molekularna biologija");
      r.pita();
      r.interesujeSe();
      System.out.println();

   }

}
