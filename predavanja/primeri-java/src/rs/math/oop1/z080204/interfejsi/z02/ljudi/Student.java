package rs.math.oop1.z080204.interfejsi.z02.ljudi;

class Student extends Covek implements Deskripcija, Kvalitet {
   private String smer;
   private String brojIndeksa;
   private int godinaStudija;
   private int dobrota = 95;
   private int postenje = 90;

   public Student(String ime, String prezime, String smer, String brojIndeksa, int godinaStudija) {
      super(ime, prezime);
      this.smer = smer;
      this.brojIndeksa = brojIndeksa;
      this.godinaStudija = godinaStudija;
   }


   public String getSmer() {
      return smer;
   }

   public void setSmer(String smer) {
      this.smer = smer;
   }

   public String getBrojIndeksa() {
      return brojIndeksa;
   }

   public void setBrojIndeksa(String brojIndeksa) {
      this.brojIndeksa = brojIndeksa;
   }

   public int getGodinaStudija() {
      return godinaStudija;
   }

   public void setGodinaStudija(int godinaStudija) {
      this.godinaStudija = godinaStudija;
   }

   public int getDobrota() {
      return dobrota;
   }

   public void setDobrota(int dobrota) {
      this.dobrota = dobrota;
   }

   public int getPostenje() {
      return postenje;
   }

   public void setPostenje(int postenje) {
      this.postenje = postenje;
   }

   @Override
   public String toString() {
      return "" +
            super.toString() +
            " smer: '" + smer + '\'' +
            ", broj indeksa: '" + brojIndeksa + '\'' +
            ", godina studija: " + godinaStudija +
            "";
   }

   @Override
   public void predstaviSe() {
      System.out.println(this);
   }

   @Override
   public int jeDobar() {
      return dobrota;
   }

   @Override
   public int jePosten() {
      return postenje;
   }

}