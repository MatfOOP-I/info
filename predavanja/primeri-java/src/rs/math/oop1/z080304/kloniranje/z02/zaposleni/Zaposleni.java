package rs.math.oop1.z080304.kloniranje.z02.zaposleni;

import java.time.LocalDate;

public class Zaposleni implements Cloneable {
   private Generalije generalije;
   private RadniOdnos radniOdnos;

   public Zaposleni(String ime, String prezime, String opisPosla, double plata) {
      generalije = new Generalije(ime, prezime);
      radniOdnos = new RadniOdnos(opisPosla, plata);
   }

   public void setPrezime(String prezime){
      generalije.setPrezime(prezime);
   }

   public void setDatumZaposlenja(int godina, int mesec, int dan) {
      LocalDate noviDatumZaposlenja = LocalDate.of(godina, mesec, dan);
      // Example of instance field mutation
      radniOdnos.setDatumZaposlenja(noviDatumZaposlenja);
   }

   public void povecajPlatu(double zaProcenat) {
      double iznosPovisice = radniOdnos.getPlata() * zaProcenat / 100;
      radniOdnos.setPlata( radniOdnos.getPlata() + iznosPovisice);
   }

   @Override
   public String toString() {
      return "Zaposleni[ime=" + generalije.getIme() + " " + generalije.getPrezime()
            + ", plata=" + radniOdnos.getPlata()
            + ", opis posla = '" + radniOdnos.getOpisPosla()
            + "', datum zaposljenja=" + radniOdnos.getDatumZaposlenja() + "]";
   }

   @Override
   public Zaposleni clone() throws CloneNotSupportedException {
      Zaposleni cloned = (Zaposleni) super.clone();
      return cloned;
   }

}
