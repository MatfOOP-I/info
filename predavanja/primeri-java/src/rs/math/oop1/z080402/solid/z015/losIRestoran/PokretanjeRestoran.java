package rs.math.oop1.z080402.solid.z015.losIRestoran;

public class PokretanjeRestoran {

   public static void main(String[] argumenti){
      Restoran onLineObrada = new OnLajnKlijentOpsluzivanje();
      Restoran telefonskObrada = new TelefonskiKlijentOpsluzivanje();
      Restoran naLicuMestaObrada = new LicnoDosaoKlijentOpsluzivanje();

      OnLajnKlijent klijent = new OnLajnKlijent("vlado", "Njegoseva 48",
            "vladaf@math.rs", onLineObrada);
      klijent.getHraniSe().prihvatiOnLajnPorudzbinu();
      klijent.getHraniSe().platiLicno();
      klijent.getHraniSe().platiOnLajn();

      klijent.setHraniSe(telefonskObrada);
      klijent.getHraniSe().prihvatiOnLajnPorudzbinu();
      klijent.getHraniSe().prihvatiTelefonskuPorudzbinu();
      klijent.getHraniSe().platiOnLajn();
      klijent.getHraniSe().platiLicno();
   }
}
