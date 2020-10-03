package rs.math.oop1.z080402.solid.z015.losIRestoran;

import static java.lang.System.err;
import static java.lang.System.out;

public class OnLajnKlijentOpsluzivanje implements Restoran {
   @Override
   public void prihvatiOnLajnPorudzbinu() {
      out.println("Realizuje se postavljanje on-lajn poruzbine!");
   }

   @Override
   public void prihvatiTelefonskuPorudzbinu() {
      err.println("Nemoguce prihvatiti telefonsku porudzbinu za on-lajn klijenta!");
   }

   @Override
   public void platiOnLajn() {
      out.println("Realizuje se on-lajn placanje za on-lajn klijenta!");
   }

   @Override
   public void staniURedZaLicnuPorudzbinu() {
      err.println("Nemoguce stati u red za licnu porudzbinu za on-lajn klijenta!");
   }

   @Override
   public void platiLicno() {
      err.println("Nemoguce licno plattiti za on-lajn klijenta!");
   }
}
