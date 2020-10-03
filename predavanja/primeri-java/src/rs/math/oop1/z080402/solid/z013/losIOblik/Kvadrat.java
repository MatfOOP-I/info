package rs.math.oop1.z080402.solid.z013.losIOblik;

import static java.lang.System.err;
import static java.lang.System.out;

public class Kvadrat implements Oblik {

   @Override
   public void iscrtajKrug() {
      err.println("Nemoguce je nacrtati krug (klasa Kvadrat)!");
   }

   @Override
   public void iscrtajKvadrat() {
      out.println("Crta se kvadrat (klasa Kvadrat)!");
   }

   @Override
   public void iscrtajPravougaonik() {
      err.println("Nemoguce je nacrtati pravougaonik (klasa Krug)!");
   }
}
