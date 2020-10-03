package rs.math.oop1.z080201.interfejsi.z01.interfejs;

public class Proba implements Prvi {

   public String pitanje2(){
         return "Realizacija metoda pitanje2() definisanog u klasi Proba";
   }

   @Override
   public void prikaziPitanje() {
      System.out.println("Realizacija metoda prikaziPitanje() u interfejsu Prvi");
   }

   @Override
   public String pitanje() {
      return "Realizacija metoda pitanje() u interfejsu Prvi";
   }

}
