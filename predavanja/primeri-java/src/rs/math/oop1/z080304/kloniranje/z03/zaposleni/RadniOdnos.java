package rs.math.oop1.z080304.kloniranje.z03.zaposleni;

import java.time.LocalDate;

public class RadniOdnos implements Cloneable {
   private String opisPosla;
   private double plata;
   private LocalDate datumZaposlenja;

   public RadniOdnos(String opisPosla, double plata, LocalDate datumZaposlenja) {
      this.opisPosla = opisPosla;
      this.datumZaposlenja = datumZaposlenja;
      this.plata = plata;
   }

   public RadniOdnos(String opisPosla, double plata) {
      this(opisPosla, plata, LocalDate.of(2000, 1, 1));
   }

   public RadniOdnos(String opisPosla) {
      this(opisPosla, 300);
   }

   public String getOpisPosla() {
      return opisPosla;
   }

   public void setOpisPosla(String opisPosla) {
      this.opisPosla = opisPosla;
   }

   public double getPlata() {
      return plata;
   }

   public void setPlata(double plata) {
      this.plata = plata;
   }

   public LocalDate getDatumZaposlenja() {
      return datumZaposlenja;
   }

   public void setDatumZaposlenja(LocalDate datumZaposlenja) {
      this.datumZaposlenja = datumZaposlenja;
   }

   @Override
   public RadniOdnos clone() throws CloneNotSupportedException {
      return (RadniOdnos) super.clone();
   }
}
