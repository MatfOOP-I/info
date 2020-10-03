package rs.math.oop1.z080402.solid.z013.losIOblik;

import static java.lang.System.out;
import static java.lang.System.err;

public class Krug implements Oblik {

   @Override
   public void iscrtajKrug() {
      out.println("Crta se krug (klasa Krug)!");
   }

   @Override
   public void iscrtajKvadrat() {
      err.println("Nemoguce je nacrtati kvadrat (klasa Krug)!");
   }

   @Override
   public void iscrtajPravougaonik() {
      err.println("Nemoguce je nacrtati pravougaonik (klasa Krug)!");
   }
}
