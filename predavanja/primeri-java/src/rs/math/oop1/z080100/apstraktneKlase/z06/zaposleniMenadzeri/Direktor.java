package rs.math.oop1.z080100.apstraktneKlase.z06.zaposleniMenadzeri;

class Direktor extends Zaposleni {
   private double bonus;

   public Direktor(String ime, double plata, int godinaRodjenja, int mesecRodjenja, int danRodjenja,
                   int godinaZaposlenja, int mesecZaposlenja, int danZaposlenja) {
      super(ime, plata, godinaRodjenja, mesecRodjenja, danRodjenja, godinaZaposlenja, mesecZaposlenja, danZaposlenja);
      bonus = 0;
   }

   public Direktor(String ime, double plata, int godinaZaposlenja, int mesecZaposlenja, int danZaposlenja) {
      this(ime, plata, 1970, 1, 1, godinaZaposlenja, mesecZaposlenja, danZaposlenja);
   }

   public double getPlata() {
      double osnovnaPlata = super.getPlata();
      return osnovnaPlata + bonus;
   }

   public void setBonus(double b) {
      bonus = b;
   }

   @Override
   public String toString() {
      return "Direktor{" +
            super.toString() +
            "bonus=" + bonus +
            '}';
   }
}
