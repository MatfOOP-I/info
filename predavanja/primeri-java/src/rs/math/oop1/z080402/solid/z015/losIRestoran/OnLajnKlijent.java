package rs.math.oop1.z080402.solid.z015.losIRestoran;

public class OnLajnKlijent {
   private String ime;
   private String adresa;
   private String email;
   private Restoran hraniSe;

   public OnLajnKlijent(String ime, String adresa, String email, Restoran hraniSe) {
      this.ime = ime;
      this.adresa = adresa;
      this.email = email;
      this.hraniSe = hraniSe;
   }

   public Restoran getHraniSe() {
      return hraniSe;
   }

   public void setHraniSe(Restoran hraniSe) {
      this.hraniSe = hraniSe;
   }

}
