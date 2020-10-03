package rs.math.oop1.z080402.solid.z016.dobarIRestoran;

public class TelefonskiKlijent {
   private String ime;
   private String adresa;
   private String brojTelefona;
   private Porudzbina porudzbina;
   private Placanje placanje;

   public TelefonskiKlijent(String ime, String adresa, String brojTelefona,
                            Porudzbina porudzbina, Placanje placanje) {
      this.ime = ime;
      this.adresa = adresa;
      this.brojTelefona = brojTelefona;
      this.porudzbina = porudzbina;
      this.placanje = placanje;
   }
}
