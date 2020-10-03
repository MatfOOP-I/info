package rs.math.oop1.z080100.apstraktneKlase.z02.ljudi;

abstract class Covek {
   private String ime;
   private String prezime;
   private String jmbg;

   public Covek(String ime, String prezime, String jmbg) {
      this.ime = ime;
      this.prezime = prezime;
      this.jmbg = jmbg;
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

   public String getJmbg() {
      return jmbg;
   }

   public void setJmbg(String jmbg) {
      this.jmbg = jmbg;
   }

   public boolean jmbgJeOK(){
      // ovde bi isla logika za kontrolu jmbg
      return true;
   }

   public abstract void predstaviSe();

   public abstract void leciSe();
}