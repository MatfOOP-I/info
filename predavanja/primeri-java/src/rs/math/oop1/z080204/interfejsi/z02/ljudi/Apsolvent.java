package rs.math.oop1.z080204.interfejsi.z02.ljudi;

class Apsolvent extends Student {
   private int brojRokovaDoIstekaStaza;

   public Apsolvent(String ime, String prezime, String smer, String brojIndeksa, int godinaStudija,
                    int brojRokovaDoIstekaStaza) {
      super(ime, prezime, smer, brojIndeksa, godinaStudija);
      this.brojRokovaDoIstekaStaza = brojRokovaDoIstekaStaza;
   }

   @Override
   public String toString() {
      return "" +
            super.toString() +
            " broj rokova do isteka staza: " + brojRokovaDoIstekaStaza +
            "";
   }

   @Override
   public void predstaviSe() {
      System.out.println(this);
   }

   @Override
   public int jeDobar() {
      return getDobrota() - 10;
   }

   @Override
   public int jePosten() {
      return Integer.min(getPostenje() + 10, 100);
   }

}
