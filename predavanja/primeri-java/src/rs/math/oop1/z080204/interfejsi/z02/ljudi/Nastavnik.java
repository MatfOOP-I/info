package rs.math.oop1.z080204.interfejsi.z02.ljudi;


class Nastavnik extends Covek implements Deskripcija, Kvalitet {
   private String predmet;
   private int godinaStaza;

   public Nastavnik(String ime, String prezime, String predmet, int godinaStaza) {
      super(ime, prezime);
      this.predmet = predmet;
      this.godinaStaza = godinaStaza;
   }

   @Override
   public String toString() {
      return "" +
            super.toString() +
            ", predmet: '" + predmet + '\'' +
            ", godina staza: " + godinaStaza +
            "";
   }

   @Override
   public void predstaviSe() {
      System.out.println(this);
   }

   @Override
   public int jeDobar() {
      return 100;
   }

   @Override
   public int jePosten() {
      return 100;
   }


}