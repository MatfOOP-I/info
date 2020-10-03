package rs.math.oop1.z080201.interfejsi.z03.dvaInterfejsa;

public class Proba implements Prvi, Drugi {

   public String pitanje2(){
      return "Realizacija metoda pitanje2() definisnaog u klasi Proba";
   }

   @Override
   public void prikaziPitanje() {
      System.out.println("Realizacija metoda prikaziPitanje() u intrefejsu Prvi");
   }

   @Override
   public String pitanje() {
      return "Realizacija metoda pitanje() u intrefejsu Prvi";
   }

   @Override
   public void prikaziOdgovor() {
      System.out.println("Realizacija metoda prikaziOdgovor() u intrefejsu Drugi");
   }

   @Override
   public String odgovor() {
      return "Realizacija metoda odgovor() u intrefejsu Drugi";
   }

}
