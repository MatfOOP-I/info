package rs.math.oop1.z080402.solid.z015.losIRestoran;

import static java.lang.System.err;
import static java.lang.System.out;

public class TelefonskiKlijentOpsluzivanje implements Restoran {

   @Override
   public void prihvatiOnLajnPorudzbinu() {
      err.println("Nemoguce prihvatiti on lajn porudzbinu za telefonskog klijenta!");
   }

   @Override
   public void prihvatiTelefonskuPorudzbinu() {
      out.println("Realizuje se prihvatanje poruzbine za za telefonskog klijenta!");
   }

   @Override
   public void platiOnLajn() {
      err.println("Nemoguce realizovati on lajn placanje za telefonskog klijenta!");
   }

   @Override
   public void staniURedZaLicnuPorudzbinu() {
      err.println("Nemoguce stati u red za telefonskog klijenta!");
   }

   @Override
   public void platiLicno() {
      out.println("Realizuje se placanje!");
   }
}
