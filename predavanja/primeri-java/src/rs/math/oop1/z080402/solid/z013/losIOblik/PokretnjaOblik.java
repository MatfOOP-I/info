package rs.math.oop1.z080402.solid.z013.losIOblik;

import static java.lang.System.out;

public class PokretnjaOblik {

   public static void main(String[] argumenti) {
      Oblik[] oblici = {
            new Kvadrat(),
            new Krug(),
            new Pravougaonik()};
      for (Oblik o : oblici) {
         out.println(o.getClass());
         o.iscrtajKrug();
         o.iscrtajKvadrat();
         o.iscrtajPravougaonik();
         out.println();
      }
   }
}
