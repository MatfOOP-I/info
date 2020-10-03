package rs.math.oop1.z080401.polimorfizam.z01.fakultet;

public class Covek {

   private String ime = "";
   private String prezime = "";

   public Covek(String ime, String prezime) {
      super();
      this.ime = ime;
      this.prezime = prezime;
   }

   public Covek() {
      super();
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
      return ime + " " + prezime;
   }

}