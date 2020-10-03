package rs.math.oop1.z080204.interfejsi.z02.ljudi;

public class Covek {
   private String ime = "";
   private String prezime = "";

   public Covek(String ime, String prezime) {
      this.ime = ime;
      this.prezime = prezime;
   }

   public Covek() {
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

   @Override
   public String toString() {
      return "" +
            "ime: '" + ime + '\'' +
            ", prezime: '" + prezime + '\'';
   }
}