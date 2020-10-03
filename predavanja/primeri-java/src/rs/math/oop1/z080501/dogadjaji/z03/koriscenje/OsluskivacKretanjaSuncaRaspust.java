package rs.math.oop1.z080501.dogadjaji.z03.koriscenje;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OsluskivacKretanjaSuncaRaspust implements SunceKretanjeDogadjajOsluskivac {

   public static String skracenica = "SStRas";

   private Student meta;

   public OsluskivacKretanjaSuncaRaspust(Student meta) {
      this.meta = meta;
   }

   @Override
   public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
      LocalDateTime datumVreme = e.getDatumVreme();
      DateTimeFormatter formatDatum = DateTimeFormatter.ofPattern("dd.MM.YYYY.");
      DateTimeFormatter formatVreme = DateTimeFormatter.ofPattern("HH:mm:ss");
      System.out.printf("%s kaže: Sunce je dana %s %s u vreme %s. ",
            meta, datumVreme.format(formatDatum),
            e.isIzaslo() ? "izaslo" : "zaslo",
            datumVreme.format(formatVreme));
      if (meta.isNaRaspustu()) {
         if (e.isIzaslo()) {
            meta.setStatus(Status.SPAVANJE);
            System.out.printf("Zavrsen provod, idem na spavanje. Moj novi status: %s\n",
                  Status.opis(meta.getStatus()));
         } else {
            meta.setStatus(Status.PROVOD);
            System.out.printf("Gde cemo nocas u provod? Moj novi status: %s.\n",
                  Status.opis(meta.getStatus()));
         }
      } else {
         if (e.isIzaslo()) {
            meta.setStatus(Status.UCENJE);
            System.out.printf("Pocinje novi dan, moram da ucim. Moj novi status: %s.\n",
                  Status.opis(meta.getStatus()));
         } else {
            meta.setStatus(Status.SPAVANJE);
            System.out.printf("Vredno sam ucio, jos malo pa na spavanje. Moj novi status: %s.\n",
                  Status.opis(meta.getStatus()));
         }
      }

   }
}
