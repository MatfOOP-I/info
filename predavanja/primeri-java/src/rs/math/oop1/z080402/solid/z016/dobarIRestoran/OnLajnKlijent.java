package rs.math.oop1.z080402.solid.z016.dobarIRestoran;

public class OnLajnKlijent {
   private String ime;
   private String adresa;
   private String email;
   private Porudzbina porudzbina;
   private Placanje placanje;


   public OnLajnKlijent(String ime, String adresa, String email,
                        Porudzbina porudzbina, Placanje placanje) {
      this.ime = ime;
      this.adresa = adresa;
      this.email = email;
      this.porudzbina = porudzbina;
      this.placanje = placanje;
   }

   public Porudzbina getPorudzbina() {
      return porudzbina;
   }

   public void setPorudzbina(Porudzbina porudzbina) {
      this.porudzbina = porudzbina;
   }

   public Placanje getPlacanje() {
      return placanje;
   }

   public void setPlacanje(Placanje placanje) {
      this.placanje = placanje;
   }

}
