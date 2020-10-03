package rs.math.oop1.z080501.dogadjaji.z02.koriscenje;

public class Suncokret implements SunceKretanjeDogadjajOsluskivac {
   @Override
   public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
      if(e.isIzaslo())
         System.out.println("Suncokret je rasirio svoj cvet");
      if(e.isZaslo())
         System.out.println("Suncokret je sakupio svoj cvet");
   }
}
