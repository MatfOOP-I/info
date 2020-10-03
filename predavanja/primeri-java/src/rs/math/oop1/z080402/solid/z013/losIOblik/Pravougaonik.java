package rs.math.oop1.z080402.solid.z013.losIOblik;

import static java.lang.System.out;
import static java.lang.System.err;

public class Pravougaonik implements Oblik {

   @Override
   public void iscrtajKrug() {
      err.println("Nemoguce je nacrtati krug (klasa Pravougaonik)!");
   }

   @Override
   public void iscrtajKvadrat() {
      err.println("Nemoguce je nacrtati kvadrat (klasa Pravougaonik)!");
   }

   @Override
   public void iscrtajPravougaonik() {
      out.println("Crta se pravougaonik (klasa Pravougaonik)!");
   }
}
