package rs.math.oop1.z080501.dogadjaji.z02.koriscenje;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student extends Covek implements SunceKretanjeDogadjajOsluskivac {
   private boolean naRaspustu;

   public Student(String ime, boolean naRaspustu, int status) {
      super( ime, status);
      this.naRaspustu = naRaspustu;
   }

   public Student(String ime, boolean naRaspustu) {
      this(ime, naRaspustu, Status.SPAVANJE);
   }

   public Student(String ime) {
      this(ime, false, Status.SPAVANJE);
   }

    @Override
   public String toString() {
      return String.format("Student '%s' (%s)", getIme(), naRaspustu ? "na raspustu" : "studira");
   }

   @Override
   public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
      LocalDateTime datumVreme = e.getDatumVreme();
      DateTimeFormatter formatDatum = DateTimeFormatter.ofPattern("dd.MM.YYYY.");
      DateTimeFormatter formatVreme = DateTimeFormatter.ofPattern("HH:mm:ss");
      System.out.printf("%s kaže: Sunce je dana %s %s u vreme %s. ",
            this, datumVreme.format(formatDatum),
            e.isIzaslo() ? "izaslo" : "zaslo",
            datumVreme.format(formatVreme));
      if (naRaspustu) {
         if (e.isIzaslo()) {
            setStatus( Status.SPAVANJE);
            System.out.printf("Zavrsen provod, idem na spavanje. Moj novi status: %s\n",
                  Status.opis(getStatus()));
         } else {
            setStatus( Status.PROVOD);
            System.out.printf("Gde cemo nocas u provod? Moj novi status: %s.\n",
                  Status.opis(getStatus()));
         }
      } else {
         if (e.isIzaslo()) {
            setStatus( Status.UCENJE);
            System.out.printf("Pocinje novi dan, moram da ucim. Moj novi status: %s.\n",
                  Status.opis(getStatus()));
         }
         else {
            setStatus( Status.SPAVANJE);
            System.out.printf("Vredno sam ucio, jos malo pa na spavanje. Moj novi status: %s.\n",
                  Status.opis(getStatus()));
         }
      }
   }
}