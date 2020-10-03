package rs.math.oop1.z070502.prevazilazenje.z06.zaposleniMenadzeri;


import java.time.LocalDate;

class Zaposleni extends Osoba {
   private double plata;
   private LocalDate datumZaposlenja;

   public Zaposleni(String ime, double plata, int godinaRodjenja, int mesecRodjenja, int danRodjenja,
                    int godinaZaposlenja, int mesecZaposlenja, int danZaposlenja) {
      super(ime, godinaRodjenja, mesecRodjenja, danRodjenja);
      this.plata = plata;
      datumZaposlenja = LocalDate.of(godinaZaposlenja, mesecZaposlenja, danZaposlenja);
   }

   public Zaposleni(String ime, double plata, int godinaZaposlenja, int mesecZaposlenja, int danZaposlenja) {
      this(ime, plata, 1970, 1, 1, godinaZaposlenja, mesecZaposlenja, danZaposlenja);
   }

   public double getPlata() {
      return plata;
   }

   public LocalDate getDatumZaposlenja() {
      return datumZaposlenja;
   }

   public void povisica(double procenat) {
      double iznosPovisice = plata * procenat / 100;
      plata += iznosPovisice;
   }

   @Override
   public String toString() {
      return "Zaposleni{" +
            super.toString() +
            "plata=" + plata +
            ", datumZaposlenja=" + datumZaposlenja +
            '}';
   }
}
