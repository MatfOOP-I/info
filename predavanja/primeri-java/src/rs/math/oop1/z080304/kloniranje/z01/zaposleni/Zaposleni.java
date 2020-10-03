package rs.math.oop1.z080304.kloniranje.z01.zaposleni;

public class Zaposleni implements Cloneable {
   private String ime;
   private String prezime;
   private String opisPosla;
   private double plata;

   public Zaposleni(String ime, String prezime, String opisPosla, double plata) {
      this.ime = ime;
      this.prezime = prezime;
      this.opisPosla = opisPosla;
      this.plata = plata;
   }

   public Zaposleni(){
      this("","", "", 0);
   }

   public void setPrezime(String prezime) {
      this.prezime = prezime;
   }


   public void povecajPlatu(double zaProcenat) {
      double iznosPovisice = plata * zaProcenat / 100;
      this.plata += iznosPovisice;
   }

   @Override
   public String toString() {
      return "Zaposleni [ime=" + ime + " " + prezime
            + ", opis posla = '" + opisPosla
            + "', plata=" + plata + "]";
   }

   @Override
   public Zaposleni clone() throws CloneNotSupportedException {
      Zaposleni cloned = (Zaposleni) super.clone();
      return cloned;
   }
}
