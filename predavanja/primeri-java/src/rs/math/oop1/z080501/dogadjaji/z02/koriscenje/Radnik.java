package rs.math.oop1.z080501.dogadjaji.z02.koriscenje;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Radnik extends Covek implements SunceKretanjeDogadjajOsluskivac {

   public Radnik(String ime, int status) {
      super(ime, status);
   }

   public Radnik(String ime) {
      this(ime, Status.SPAVANJE);
   }

   @Override
   public String toString() {
      return String.format("Radnik '%s' (%s)", getIme(), Status.opis(getStatus()));
   }

   @Override
   public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
      LocalDateTime datumVreme = e.getDatumVreme();
      DateTimeFormatter formatDatum = DateTimeFormatter.ofPattern("dd.MM.YYYY.");
      DateTimeFormatter formatVreme = DateTimeFormatter.ofPattern("HH:mm:ss");
      System.out.printf("%s kaže: Sunce je dana %s %s u vreme %s. ",
            this, datumVreme.format(formatDatum),
            e.isIzaslo() ? "izaslo" : "zaslo", datumVreme.format(formatVreme));
      int danUNedelji = datumVreme.getDayOfWeek().getValue();
      System.out.printf(" %s - ", DanUNedelji.opis(danUNedelji));
      switch (danUNedelji) {
         case DanUNedelji.PONEDELJAK:
            if (e.isIzaslo()) {
               setStatus(Status.RAD);
               System.out.printf("Pcinje rad u novoj radnoj nedelji :( Moj novi status: %s. \n",
                     Status.opis(getStatus()));
            }
            if (e.isZaslo()) {
               setStatus(Status.SPAVANJE);
               System.out.printf("Nekako sam pregurao prvi radni dan... Moj novi status: %s. \n",
                     Status.opis(getStatus()));
            }
            break;
         case DanUNedelji.UTORAK:
         case DanUNedelji.SREDA:
         case DanUNedelji.CETVRTAK:
            if (e.isIzaslo()) {
               setStatus(Status.RAD);
               System.out.printf("I danas treba uskoro da se pocne sa radom. Moj novi status: %s. \n",
                     Status.opis(getStatus()));
            }
            if (e.isZaslo()) {
               setStatus(Status.SPAVANJE);
               System.out.printf("Za danas sam zavrsio sa poslom... Moj novi status: %s. \n",
                     Status.opis(getStatus()));
            }
            break;
         case DanUNedelji.PETAK:
            if (e.isIzaslo()) {
               setStatus(Status.RAD);
               System.out.printf("Sto bi petak bio lepsi da sutra nije subota radna. Moj novi status: %s. \n",
                     Status.opis(getStatus()));
            }
            if (e.isZaslo()) {
               setStatus(Status.SPAVANJE);
               System.out.printf("Kraj dansenjeg posla. Jos sutra pa gotovo. Moj novi status: %s. \n",
                     Status.opis(getStatus()));
            }
            break;
         case DanUNedelji.SUBOTA:
            if (e.isIzaslo()) {
               setStatus(Status.RAD);
               System.out.printf("Mrzim radne subote! Moj novi status: %s. \n",
                     Status.opis(getStatus()));
            }
            if (e.isZaslo()) {
               setStatus(Status.SPAVANJE);
               System.out.printf("Kraj subotnjeg posla. Slobodan sam!  Moj novi status: %s. \n",
                     Status.opis(getStatus()));
            }
            break;
         case DanUNedelji.NEDELJA:
            if (e.isIzaslo()) {
               setStatus(Status.ODMOR);
               System.out.printf("Sloboda!!! Moj novi status: %s. \n",
                     Status.opis(getStatus()));
            }
            if (e.isZaslo()) {
               setStatus(Status.SPAVANJE);
               System.out.printf("Jos malo, pa ponovo na posao :(  Moj novi status: %s. \n",
                     Status.opis(getStatus()));
            }
            break;
         default:
            System.out.printf("Ovo nikad ne bi smelo da se pojavi");
      }
   }
}