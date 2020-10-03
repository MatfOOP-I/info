package rs.math.oop1.z080402.solid.z016.dobarIRestoran;

public class PokretanjeRestoran {

   public static void main(String[] argumenti){
      Porudzbina onLinePorudzbina = new OnLajnPorudzbina();
      Porudzbina telefonskPorudzbina = new TelefonskaPorudzbina();
      Porudzbina naLicuMestaPorudzbina = new LicnoNapravljenaPorudzbina();

      Placanje onLajnPlacanje = new OnLajnPlacanje();
      Placanje licnoPlacanje = new LicnoPlacanje();

      OnLajnKlijent klijent = new OnLajnKlijent("vlado", "Njegoseva 48",
            "vladaf@math.rs", onLinePorudzbina, onLajnPlacanje);
      klijent.getPorudzbina().prihvatiPorudzbinu();
      klijent.getPlacanje().platiPorudzbinu();

      klijent.setPorudzbina(telefonskPorudzbina);
      klijent.setPlacanje(licnoPlacanje);
      klijent.getPorudzbina().prihvatiPorudzbinu();
      klijent.getPlacanje().platiPorudzbinu();
   }
}
