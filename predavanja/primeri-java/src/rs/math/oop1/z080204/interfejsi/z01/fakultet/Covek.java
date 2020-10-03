package rs.math.oop1.z080204.interfejsi.z01.fakultet;

public class Covek {

   private String ime = "";
   private String prezime = "";

   public Covek(String ime, String prezime) {
      this.ime = ime;
      this.prezime = prezime;
   }

   public Covek(){
   }

   public void prikazi() {
      System.out.printf("%s %s", ime, prezime);
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

}