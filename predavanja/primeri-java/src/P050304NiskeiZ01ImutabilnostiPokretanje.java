public class P050304NiskeiZ01ImutabilnostiPokretanje {
   public static void main(String[] args) {
      int duzina = 20_000;

      long pocetak = System.nanoTime();
      String velikaNiska = "";
      for (int i = 0; i < duzina; i++) {
         String parce = "A";
         velikaNiska += parce;
      }
      double trajanje = (System.nanoTime() - pocetak)/1e9;
      System.out.printf("Za %f sekundi je napravlenja niska \n %s \n\n", trajanje, velikaNiska);

      pocetak = System.nanoTime();
      StringBuilder graditeljNiske = new StringBuilder();
      for (int i = 0; i < duzina; i++) {
         String parce = "A";
         graditeljNiske.append(parce);
      }
      velikaNiska = graditeljNiske.toString();
      trajanje = (System.nanoTime() - pocetak)/1e9;
      System.out.printf("Za %f sekundi je napravlenja niska \n %s \n\n", trajanje, velikaNiska);

      pocetak = System.nanoTime();
      graditeljNiske = new StringBuilder();
      for (int i = 0; i < duzina; i++) {
         char parce = 'A';
         graditeljNiske.append(parce);
      }
      velikaNiska = graditeljNiske.toString();
      trajanje = (System.nanoTime() - pocetak)/1e9;
      System.out.printf("Za %f sekundi je napravlenja niska \n %s \n\n", trajanje, velikaNiska);
   }
}
