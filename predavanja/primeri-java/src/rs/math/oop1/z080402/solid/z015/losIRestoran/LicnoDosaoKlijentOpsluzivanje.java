package rs.math.oop1.z080402.solid.z015.losIRestoran;

import static java.lang.System.err;
import static java.lang.System.out;

public class LicnoDosaoKlijentOpsluzivanje implements Restoran {

   @Override
   public void prihvatiOnLajnPorudzbinu() {
      err.println("Nemoguce prihvatiti on lajn porudzbinu za klijenta koji je licno dosao!");
   }

   @Override
   public void prihvatiTelefonskuPorudzbinu() {
      err.println("Nemoguce prihvatiti telefonsku porudzbinu za klijenta koji je licno dosao!");
   }

   @Override
   public void platiOnLajn() {
      err.println("Nemoguce platiti on lajn za za klijenta koji je licno dosao!");
   }

   @Override
   public void staniURedZaLicnuPorudzbinu() {
      out.println("Realizuje se stajanje u red klijenta koji je licno dosao!");
   }

   @Override
   public void platiLicno() {
      out.println("Realizuje se placanje za klijenta koji je licno dosao!");
   }
}
