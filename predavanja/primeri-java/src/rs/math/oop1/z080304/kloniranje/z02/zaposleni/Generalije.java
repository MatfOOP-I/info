package rs.math.oop1.z080304.kloniranje.z02.zaposleni;

import java.time.LocalDate;

public class Generalije {

   private String ime;
   private String prezime;
   private String nadimak;
   private LocalDate datumRodjenja;

   public Generalije(String ime, String prezime, String nadimak, LocalDate datumRodjenja) {
      this.ime = ime;
      this.prezime = prezime;
      this.nadimak = nadimak;
      this.datumRodjenja = datumRodjenja;
   }

   public Generalije(String ime, String prezime) {
      this(ime, prezime, "", LocalDate.of(1970, 1, 1));
   }

   public String getIme() {
      return ime;
   }

   public void setIme(String ime) {
      this.ime = ime;
   }

   public String getPrezime() {
      return prezime;
   }

   public void setPrezime(String prezime) {
      this.prezime = prezime;
   }

   public String getNadimak() {
      return nadimak;
   }

   public void setNadimak(String nadimak) {
      this.nadimak = nadimak;
   }

   public LocalDate getDatumRodjenja() {
      return datumRodjenja;
   }

   public void setDatumRodjenja(LocalDate datumRodjenja) {
      this.datumRodjenja = datumRodjenja;
   }
}