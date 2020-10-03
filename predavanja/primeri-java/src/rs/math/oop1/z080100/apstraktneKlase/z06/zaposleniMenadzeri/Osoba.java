package rs.math.oop1.z080100.apstraktneKlase.z06.zaposleniMenadzeri;

import java.time.LocalDate;

public abstract class Osoba {
   private String ime;
   private LocalDate datumRodjenja;

   public Osoba(String ime, int godina, int mesec, int dan) {
      this.ime = ime;
      datumRodjenja = LocalDate.of(godina, mesec, dan);
   }

   public String getIme() {
      return ime;
   }

   public LocalDate getDatumRodjenja() {
      return datumRodjenja;
   }

   @Override
   public String toString() {
      return "Osoba{" +
            "ime='" + ime + '\'' +
            ", datumRodjenja=" + datumRodjenja +
            '}';
   }
}
